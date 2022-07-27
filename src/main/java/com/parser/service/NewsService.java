package com.parser.service;

import com.parser.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    void save(News news);

    boolean isExists(String newTitle);

    List<News> getAllNews();
}
