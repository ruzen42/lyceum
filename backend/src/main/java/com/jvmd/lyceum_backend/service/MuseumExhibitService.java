package com.jvmd.lyceum_backend.service;

import com.jvmd.lyceum_backend.model.MuseumExhibit;
import com.jvmd.lyceum_backend.repository.MuseumExhibitRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MuseumExhibitService {

    private final MuseumExhibitRepository museumExhibitRepository;
    private final S3Service s3Service;
    private final OllamaHtmlService ollamaHtmlService;

    public MuseumExhibit create(
            String title,
            String description,
            List<MultipartFile> images,
            List<Long> relatedExhibitIds
    ) throws IOException {
        List<String> imageUrls = new ArrayList<>();
        if (images != null && !images.isEmpty()) {
            imageUrls = s3Service.uploadFiles(images, "exhibits");
        }

        List<MuseumExhibit> relatedExhibits = new ArrayList<>();
        if (relatedExhibitIds != null && !relatedExhibitIds.isEmpty()) {
            relatedExhibits = museumExhibitRepository.findAllById(relatedExhibitIds);
        }

        String html = ollamaHtmlService.generateExhibitHtml(title, description, imageUrls, relatedExhibits);

        MuseumExhibit exhibit = MuseumExhibit.builder()
                .title(title)
                .description(description)
                .htmlContent(html)
                .imageUrls(imageUrls)
                .relatedExhibits(relatedExhibits)
                .build();

        return museumExhibitRepository.save(exhibit);
    }

    public MuseumExhibit regenerateHtml(Long id) {
        MuseumExhibit exhibit = museumExhibitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Exhibit not found: " + id));

        String html = ollamaHtmlService.generateExhibitHtml(
                exhibit.getTitle(),
                exhibit.getDescription(),
                exhibit.getImageUrls(),
                exhibit.getRelatedExhibits()
        );
        exhibit.setHtmlContent(html);
        return museumExhibitRepository.save(exhibit);
    }

    public List<MuseumExhibit> getAll() {
        return museumExhibitRepository.findAll();
    }

    public MuseumExhibit getById(Long id) {
        return museumExhibitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Exhibit not found: " + id));
    }
}
