package com.jvmd.lyceum_backend.controller.rest;

import com.jvmd.lyceum_backend.model.StudentPortfolio;
import com.jvmd.lyceum_backend.service.StudentPortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
@RequiredArgsConstructor
public class StudentPortfolioController {

    private final StudentPortfolioService portfolioService;

    @GetMapping("/get-all")
    public ResponseEntity<List<StudentPortfolio>> getAll() {
        return ResponseEntity.ok(portfolioService.getAll());
    }

    @PostMapping(value = "/new", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<StudentPortfolio> create(
            @RequestParam String studentName,
            @RequestParam String grade,
            @RequestPart("file") MultipartFile file
    ) throws IOException {
        return ResponseEntity.ok(portfolioService.create(studentName, grade, file));
    }
}
