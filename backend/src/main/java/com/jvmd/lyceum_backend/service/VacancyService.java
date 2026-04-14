package com.jvmd.lyceum_backend.service;

import com.jvmd.lyceum_backend.model.Vacancy;
import com.jvmd.lyceum_backend.repository.VacancyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    @Transactional(readOnly = true)
    public List<Vacancy> getActive() {
        return vacancyRepository.findAllByActiveTrueOrderByCreatedAtDesc();
    }

    public Vacancy create(String title, String description) {
        return vacancyRepository.save(Vacancy.builder()
                .title(title)
                .description(description)
                .build());
    }

    public void delete(Long id) {
        Vacancy vacancy = vacancyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vacancy not found: " + id));
        vacancy.setActive(false);
        vacancyRepository.save(vacancy);
    }
}
