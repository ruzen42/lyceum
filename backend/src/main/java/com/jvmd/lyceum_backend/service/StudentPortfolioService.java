package com.jvmd.lyceum_backend.service;

import com.jvmd.lyceum_backend.model.StudentPortfolio;
import com.jvmd.lyceum_backend.repository.StudentPortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentPortfolioService {

    private final StudentPortfolioRepository portfolioRepository;
    private final S3Service s3Service;

    @Transactional(readOnly = true)
    public List<StudentPortfolio> getAll() {
        return portfolioRepository.findAllByOrderByCreatedAtDesc();
    }

    public StudentPortfolio create(String studentName, String grade, String bio,
                                   MultipartFile image, List<String> skills,
                                   List<String> achievements) throws IOException {
        String imageUrl = null;
        if (image != null && !image.isEmpty()) {
            imageUrl = s3Service.uploadFile(image, "portfolio");
        }

        StudentPortfolio portfolio = StudentPortfolio.builder()
                .studentName(studentName)
                .grade(grade)
                .bio(bio)
                .imageUrl(imageUrl)
                .skills(skills)
                .achievements(achievements)
                .build();
        return portfolioRepository.save(portfolio);
    }
}
