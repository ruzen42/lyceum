package com.jvmd.lyceum_backend.repository;

import com.jvmd.lyceum_backend.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findAllByActiveTrueOrderByCreatedAtDesc();
}
