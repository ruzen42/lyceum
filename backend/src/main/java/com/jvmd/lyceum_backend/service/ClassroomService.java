package com.jvmd.lyceum_backend.service;

import com.jvmd.lyceum_backend.model.Classroom;
import com.jvmd.lyceum_backend.model.Material;
import com.jvmd.lyceum_backend.model.User;
import com.jvmd.lyceum_backend.repository.ClassroomRepository;
import com.jvmd.lyceum_backend.repository.MaterialRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final MaterialRepository materialRepository;
    private final S3Service s3Service;
    private final ClassroomHtmlService classroomHtmlService;

    @Transactional
    public Classroom create(String title) {
        Classroom classroom = Classroom.builder()
                .title(title)
                .build();
        classroom = classroomRepository.save(classroom);

        String html = classroomHtmlService.generateClassroomHtml(title, List.of());
        classroom.setHtmlContent(html);
        return classroomRepository.save(classroom);
    }

    @Transactional
    public Material addMaterial(
            Long classroomId,
            String title,
            String description,
            List<MultipartFile> files,
            User author
    ) throws IOException {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new EntityNotFoundException("Classroom not found: " + classroomId));

        List<String> fileUrls = new ArrayList<>();
        if (files != null && !files.isEmpty()) {
            fileUrls = s3Service.uploadFiles(files, "classrooms/" + classroomId);
        }

        Material material = Material.builder()
                .title(title)
                .description(description)
                .fileUrls(fileUrls)
                .author(author)
                .classroom(classroom)
                .build();

        material = materialRepository.save(material);

        regenerateHtml(classroom);

        return material;
    }

    @Transactional
    public void deleteMaterial(Long materialId) {
        Material material = materialRepository.findById(materialId)
                .orElseThrow(() -> new EntityNotFoundException("Material not found: " + materialId));
        Classroom classroom = material.getClassroom();
        materialRepository.delete(material);
        regenerateHtml(classroom);
    }

    public Classroom regenerateHtml(Long classroomId) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new EntityNotFoundException("Classroom not found: " + classroomId));
        regenerateHtml(classroom);
        return classroom;
    }

    private void regenerateHtml(Classroom classroom) {
        List<Material> materials = materialRepository.findAllByClassroomId(classroom.getId());
        String html = classroomHtmlService.generateClassroomHtml(classroom.getTitle(), materials);
        classroom.setHtmlContent(html);
        classroomRepository.save(classroom);
    }

    public List<Classroom> getAll() {
        return classroomRepository.findAll();
    }

    public Classroom getById(Long id) {
        return classroomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Classroom not found: " + id));
    }
}
