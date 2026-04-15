package com.jvmd.lyceum_backend.repository;

import com.jvmd.lyceum_backend.model.StudentPortfolio;
import com.jvmd.lyceum_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentPortfolioRepository extends JpaRepository<StudentPortfolio, Long> {
    List<StudentPortfolio> findAllByOrderByCreatedAtDesc();
    Optional<StudentPortfolio> findByUser(User user);
}
