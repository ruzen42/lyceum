package com.jvmd.lyceum_backend.controller;

import com.jvmd.lyceum_backend.model.Achievement;
import com.jvmd.lyceum_backend.payload.AchievementCreateRequest;
import com.jvmd.lyceum_backend.service.AchievementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/achievements")
@RequiredArgsConstructor
public class AchievementController {

    private final AchievementService achievementService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Achievement>> getAll() {
        return ResponseEntity.ok(achievementService.getAll());
    }

    @PostMapping("/new")
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<Achievement> create(@Valid @RequestBody AchievementCreateRequest request) {
        return ResponseEntity.ok(achievementService.create(request));
    }
}
