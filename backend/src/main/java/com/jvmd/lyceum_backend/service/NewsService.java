package com.jvmd.lyceum_backend.service;

import com.jvmd.lyceum_backend.model.News;
import com.jvmd.lyceum_backend.model.User;
import com.jvmd.lyceum_backend.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;
    private final S3Service s3Service;

    public List<News> getAll() {
        return newsRepository.findAll();
    }

    public News saveWithImage(String title, String content, MultipartFile image, User author) throws IOException {
        String imageUrl = null;
        if (image != null && !image.isEmpty()) {
            imageUrl = s3Service.uploadFile(image, "news");
        }

        News news = News.builder()
                .title(title)
                .content(content)
                .imageUrl(imageUrl)
                .user(author)
                .build();

        return newsRepository.save(news);
    }
}
