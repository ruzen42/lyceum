package com.jvmd.lyceum_backend.controller.rest;

import com.jvmd.lyceum_backend.model.AdmissionApplication;
import com.jvmd.lyceum_backend.payload.AdmissionApplicationRequest;
import com.jvmd.lyceum_backend.service.AdmissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admission")
@RequiredArgsConstructor
public class AdmissionController {

    private final AdmissionService admissionService;

    @PostMapping("/apply")
    public ResponseEntity<AdmissionApplication> apply(@Valid @RequestBody AdmissionApplicationRequest request) {
        return ResponseEntity.ok(admissionService.apply(request));
    }

    @GetMapping("/get-all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<AdmissionApplication>> getAll() {
        return ResponseEntity.ok(admissionService.getAll());
    }
}
