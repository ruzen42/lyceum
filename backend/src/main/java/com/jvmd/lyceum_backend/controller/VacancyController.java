package com.jvmd.lyceum_backend.controller;

import com.jvmd.lyceum_backend.model.Vacancy;
import com.jvmd.lyceum_backend.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacancies")
@RequiredArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Vacancy>> getAll() {
        return ResponseEntity.ok(vacancyService.getActive());
    }

    @PostMapping("/new")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Vacancy> create(
            @RequestParam String title,
            @RequestParam(required = false) String description) {
        return ResponseEntity.ok(vacancyService.create(title, description));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vacancyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
