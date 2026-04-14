package com.jvmd.lyceum_backend.service;

import com.jvmd.lyceum_backend.model.Achievement;
import com.jvmd.lyceum_backend.payload.AchievementCreateRequest;
import com.jvmd.lyceum_backend.repository.AchievementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AchievementService {

    private final AchievementRepository achievementRepository;

    @Transactional(readOnly = true)
    public List<Achievement> getAll() {
        return achievementRepository.findAllByOrderByCreatedAtDesc();
    }

    public Achievement create(AchievementCreateRequest request) {
        Achievement achievement = Achievement.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .category(request.getCategory())
                .studentName(request.getStudentName())
                .year(request.getYear())
                .place(request.getPlace())
                .level(request.getLevel())
                .build();
        return achievementRepository.save(achievement);
    }
}
