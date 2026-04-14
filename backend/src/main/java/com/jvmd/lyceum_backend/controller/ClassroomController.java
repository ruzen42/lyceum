package com.jvmd.lyceum_backend.controller;

import com.jvmd.lyceum_backend.model.Classroom;
import com.jvmd.lyceum_backend.model.Material;
import com.jvmd.lyceum_backend.model.User;
import com.jvmd.lyceum_backend.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/classroom")
@RequiredArgsConstructor
public class ClassroomController {

    private final ClassroomService classroomService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Classroom>> getAll() {
        return ResponseEntity.ok(classroomService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classroom> getById(@PathVariable Long id) {
        return ResponseEntity.ok(classroomService.getById(id));
    }

    @GetMapping(value = "/{id}/html", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> getHtml(@PathVariable Long id) {
        return ResponseEntity.ok(classroomService.getById(id).getHtmlContent());
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Classroom> create(@RequestParam String title) {
        return ResponseEntity.ok(classroomService.create(title));
    }

    @PostMapping(value = "/{id}/material", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<Material> addMaterial(
            @PathVariable Long id,
            @RequestParam String title,
            @RequestParam(required = false) String description,
            @RequestPart(value = "files", required = false) List<MultipartFile> files,
            @AuthenticationPrincipal User currentUser
    ) throws IOException {
        return ResponseEntity.ok(classroomService.addMaterial(id, title, description, files, currentUser));
    }

    @DeleteMapping("/material/{materialId}")
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long materialId) {
        classroomService.deleteMaterial(materialId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/regenerate-html")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Classroom> regenerateHtml(@PathVariable Long id) {
        return ResponseEntity.ok(classroomService.regenerateHtml(id));
    }
}
