package com.parser;

import com.parser.model.Post;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Parser {
    public static void main(String[] args) {
        List<Post> posts = new ArrayList<>();
        String url = "http://4pda.to";
        String urlCSGO = "https://market.csgo.com/";
        System.out.println("Подключение к главной странице...");
        Document doc = null;
        try {
            doc = Jsoup.connect(urlCSGO).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements postTitleElements = Objects.requireNonNull(doc).getElementsByAttributeValue("itemprop", "url");
        for (Element postTitleElement : postTitleElements) {
            String detailsLink = postTitleElement.attr("href");
            Post post = new Post();
            post.setDetailsLink(detailsLink);
            post.setTitle(postTitleElement.attr("title"));
//            System.out.println("Подключение к деталям о посте: " + detailsLink);
            Document postDetailsDoc = null;
            try {
                postDetailsDoc = Jsoup.connect(detailsLink).get();
            } catch (IOException e) {
//                e.printStackTrace();
            }
            try {
                Element authorElement = Objects.requireNonNull(Objects.requireNonNull(postDetailsDoc).getElementsByClass("name").first()).child(0);
                post.setAuthor(authorElement.text());
                post.setAuthorDetailsLink(authorElement.attr("href"));
                post.setDateOfCreated(Objects.requireNonNull(postDetailsDoc.getElementsByClass("date").first()).text());
            } catch (NullPointerException e) {
                post.setAuthor("Автора нет");
                post.setAuthorDetailsLink("Ссылки нет");
                post.setDateOfCreated("Даты создания нет");
            }
            posts.add(post);
        }
        posts.forEach(e ->
                System.out.println(
                        e.getAuthor() + "  |  " + e.getTitle() + "  |  " + e.getDetailsLink())
        );
    }
}
