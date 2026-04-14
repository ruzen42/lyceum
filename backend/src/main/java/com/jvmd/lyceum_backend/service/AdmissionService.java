package com.jvmd.lyceum_backend.service;

import com.jvmd.lyceum_backend.model.AdmissionApplication;
import com.jvmd.lyceum_backend.payload.AdmissionApplicationRequest;
import com.jvmd.lyceum_backend.repository.AdmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdmissionService {

    private final AdmissionRepository admissionRepository;

    public AdmissionApplication apply(AdmissionApplicationRequest request) {
        AdmissionApplication application = AdmissionApplication.builder()
                .parentName(request.getParentName())
                .childName(request.getChildName())
                .childAge(request.getChildAge())
                .phone(request.getPhone())
                .email(request.getEmail())
                .classType(request.getClassType())
                .message(request.getMessage())
                .build();
        return admissionRepository.save(application);
    }

    @Transactional(readOnly = true)
    public List<AdmissionApplication> getAll() {
        return admissionRepository.findAllByOrderByCreatedAtDesc();
    }
}
