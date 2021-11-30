package com.codegym.blog.model;

import javax.persistence.*;

@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author;
    private String time;

    public Blog() {
    }

    public Blog(String title, String content, String author, String time) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.time = time;
    }

    public Blog(Long id, String title, String content, String author, String time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
