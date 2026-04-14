package com.jvmd.lyceum_backend.repository;

import com.jvmd.lyceum_backend.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findAllByClassroomId(Long classroomId);
}
