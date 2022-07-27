package com.parser.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Post {
    private String title;
    private String detailsLink;
    private String author;
    private String authorDetailsLink;
    private String dateOfCreated;

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", detailsLink='" + detailsLink + '\'' +
                ", author='" + author + '\'' +
                ", authorDetailsLink='" + authorDetailsLink + '\'' +
                ", dateOfCreated='" + dateOfCreated + '\'' +
                '}';
    }
}
