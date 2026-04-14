package com.jvmd.lyceum_backend.repository;

import com.jvmd.lyceum_backend.model.StudentPortfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentPortfolioRepository extends JpaRepository<StudentPortfolio, Long> {
    List<StudentPortfolio> findAllByOrderByCreatedAtDesc();
}
