package com.jvmd.lyceum_backend.service;

import com.jvmd.lyceum_backend.model.News;
import com.jvmd.lyceum_backend.repository.NewsRepository;
import com.jvmd.lyceum_backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public List<News> getAll() {
        return newsRepository.findAll();
    }

    public News save(News news) {
        newsRepository.save(news);
    }
}
