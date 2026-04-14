package com.jvmd.lyceum_backend.repository;

import com.jvmd.lyceum_backend.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    List<Achievement> findAllByOrderByCreatedAtDesc();
}
