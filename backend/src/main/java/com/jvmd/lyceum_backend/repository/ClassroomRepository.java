package com.jvmd.lyceum_backend.repository;

import com.jvmd.lyceum_backend.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
