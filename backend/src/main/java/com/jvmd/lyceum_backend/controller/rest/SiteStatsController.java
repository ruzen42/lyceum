package com.jvmd.lyceum_backend.controller.rest;

import com.jvmd.lyceum_backend.payload.SiteStatsResponse;
import com.jvmd.lyceum_backend.repository.AchievementRepository;
import com.jvmd.lyceum_backend.repository.NewsRepository;
import com.jvmd.lyceum_backend.repository.StudentPortfolioRepository;
import com.jvmd.lyceum_backend.repository.AdmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
public class SiteStatsController {

    private final NewsRepository newsRepository;
    private final AchievementRepository achievementRepository;
    private final StudentPortfolioRepository portfolioRepository;
    private final AdmissionRepository admissionRepository;

    @GetMapping
    public ResponseEntity<SiteStatsResponse> getStats() {
        return ResponseEntity.ok(SiteStatsResponse.builder()
                .newsCount(newsRepository.count())
                .achievementsCount(achievementRepository.count())
                .portfolioCount(portfolioRepository.count())
                .applicationsCount(admissionRepository.count())
                .build());
    }
}
