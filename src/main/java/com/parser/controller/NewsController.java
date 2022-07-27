package com.parser.controller;

import com.parser.model.News;
import com.parser.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news")
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }
}
