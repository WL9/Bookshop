package com.example.william.xebiabookshop.data.models;

import java.util.List;

public class Book {

    private String isbn;
    private String title;
    private Integer price;
    private String cover;
    private List<String> synopsis = null;

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPrice() {
        return price;
    }

    public String getCover() {
        return cover;
    }

    public List<String> getSynopsis() {
        return synopsis;
    }
}
