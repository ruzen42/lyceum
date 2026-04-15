package com.jvmd.lyceum_backend.service;

import com.jvmd.lyceum_backend.model.StudentPortfolio;
import com.jvmd.lyceum_backend.model.User;
import com.jvmd.lyceum_backend.repository.StudentPortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentPortfolioService {

    private final StudentPortfolioRepository portfolioRepository;
    private final S3Service s3Service;

    @Transactional(readOnly = true)
    public List<StudentPortfolio> getAll() {
        return portfolioRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional(readOnly = true)
    public Optional<StudentPortfolio> findByUser(User user) {
        return portfolioRepository.findByUser(user);
    }

    @Transactional
    public StudentPortfolio create(String studentName, String grade, MultipartFile file) throws IOException {
        validateDocx(file);
        String fileUrl = s3Service.uploadFile(file, "portfolio");
        return portfolioRepository.save(StudentPortfolio.builder()
                .studentName(studentName)
                .grade(grade)
                .fileUrl(fileUrl)
                .build());
    }

    @Transactional
    public StudentPortfolio createOrUpdateForStudent(User user, String studentName, String grade,
                                                     MultipartFile file) throws IOException {
        StudentPortfolio portfolio = portfolioRepository.findByUser(user)
                .orElseGet(() -> StudentPortfolio.builder().user(user).build());

        portfolio.setStudentName(studentName);
        portfolio.setGrade(grade);

        if (file != null && !file.isEmpty()) {
            validateDocx(file);
            portfolio.setFileUrl(s3Service.uploadFile(file, "portfolio"));
        }

        return portfolioRepository.save(portfolio);
    }

    private void validateDocx(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("Файл не выбран");
        }
        String name = file.getOriginalFilename() != null ? file.getOriginalFilename().toLowerCase() : "";
        if (!name.endsWith(".docx")) {
            throw new IllegalArgumentException("Разрешены только файлы .docx");
        }
    }
}
