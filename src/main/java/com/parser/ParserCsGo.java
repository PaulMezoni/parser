package com.parser;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParserCsGo {
    @SneakyThrows
    public static void main(String[] args) {
        String urlCSGO = "https://market.csgo.com/";
        Document doc = Jsoup.connect(urlCSGO).get();
        Elements postTitleElements = doc.getElementsByAttribute("item hot");
        postTitleElements.forEach(e -> System.out.println(e.attr("item hot") + " " + e.attr("href")));
    }
}
