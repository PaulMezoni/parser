package com.parser.service;

import com.parser.repository.NewsRepository;
import com.parser.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }

    @Override
    public boolean isExists(String newTitle) {
        List<News> newsList = newsRepository.findAll();
        for (News news : newsList) {
            if (news.getTitle().equals(newTitle)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }
}
