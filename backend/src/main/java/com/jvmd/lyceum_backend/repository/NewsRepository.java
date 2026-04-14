package com.jvmd.lyceum_backend.repository;

import com.jvmd.lyceum_backend.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
