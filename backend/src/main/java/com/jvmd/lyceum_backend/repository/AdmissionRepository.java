package com.jvmd.lyceum_backend.repository;

import com.jvmd.lyceum_backend.model.AdmissionApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdmissionRepository extends JpaRepository<AdmissionApplication, Long> {
    List<AdmissionApplication> findAllByOrderByCreatedAtDesc();
}
