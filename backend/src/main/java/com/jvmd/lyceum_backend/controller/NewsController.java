package com.jvmd.lyceum_backend.controller;

import com.jvmd.lyceum_backend.model.News;
import com.jvmd.lyceum_backend.model.Role;
import com.jvmd.lyceum_backend.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@AllArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/get-all")
    public ResponseEntity<List<News>> getAll() {
        return ResponseEntity.ok(newsService.getAll());
    }

    @PostMapping("/new")
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<News> createNewNews(News news) {
        return ResponseEntity.ok(newsService.save(news));
    }


}
