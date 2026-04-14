package com.jvmd.lyceum_backend.controller;

import com.jvmd.lyceum_backend.model.News;
import com.jvmd.lyceum_backend.model.User;
import com.jvmd.lyceum_backend.service.NewsService;
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
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/get-all")
    public ResponseEntity<List<News>> getAll() {
        return ResponseEntity.ok(newsService.getAll());
    }

    @PostMapping(value = "/new", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<News> createNews(
            @RequestParam String title,
            @RequestParam String content,
            @RequestPart(value = "image", required = false) MultipartFile image,
            @AuthenticationPrincipal User currentUser
    ) throws IOException {
        return ResponseEntity.ok(newsService.saveWithImage(title, content, image, currentUser));
    }
}
