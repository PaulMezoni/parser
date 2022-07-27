package com.parser;

import com.parser.model.News;
import com.parser.service.NewsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ParseTask {
    private final NewsService newsService;

    public ParseTask(NewsService newsService) {
        this.newsService = newsService;
    }

    @Scheduled(fixedDelay = 5000)
    public void parseNewNews() {
        String url = "https://news.ycombinator.com/";

        try {
            Document doc = Jsoup.connect(url)
//                    .userAgent("Chrome")
                    .timeout(50000)
                    .referrer("https://google.com")
                    .get();
            Elements news = doc.getElementsByClass("titlelink");
            for (Element el : news) {
                String title = el.ownText();
                if (newsService.isExists(title)) {
                    News obj = new News();
                    newsService.save(obj);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
