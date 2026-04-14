package com.jvmd.lyceum_backend.controller.rest;

import com.jvmd.lyceum_backend.model.MuseumExhibit;
import com.jvmd.lyceum_backend.service.MuseumExhibitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/museum-exhibit")
@RequiredArgsConstructor
public class MuseumExhibitController {

    private final MuseumExhibitService museumExhibitService;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<MuseumExhibit> create(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam(required = false) List<Long> relatedExhibitIds,
            @RequestPart(value = "images", required = false) List<MultipartFile> images
    ) throws IOException {
        return ResponseEntity.ok(museumExhibitService.create(title, description, images, relatedExhibitIds));
    }

    @PostMapping("/{id}/regenerate-html")
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<MuseumExhibit> regenerateHtml(@PathVariable Long id) {
        return ResponseEntity.ok(museumExhibitService.regenerateHtml(id));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<MuseumExhibit>> getAll() {
        return ResponseEntity.ok(museumExhibitService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MuseumExhibit> getById(@PathVariable Long id) {
        return ResponseEntity.ok(museumExhibitService.getById(id));
    }

    @GetMapping(value = "/{id}/html", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> getHtml(@PathVariable Long id) {
        MuseumExhibit exhibit = museumExhibitService.getById(id);
        return ResponseEntity.ok(exhibit.getHtmlContent());
    }
}
