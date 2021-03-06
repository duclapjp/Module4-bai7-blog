package com.codegym.blog.model.blog;

import com.codegym.blog.model.category.Category;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.time.LocalDate;


public class BlogForm {
    private Long id;
    private String title;
    private String content;
    private String author;
    private Date time;
    private MultipartFile image;
    private Category category;

    public BlogForm() {
    }

    public BlogForm(Long id, String title, String content, String author, Date time, MultipartFile image, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.time = time;
        this.image = image;
        this.category = category;
    }

    public BlogForm(String title, String content, String author, Date time, MultipartFile image, Category category) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.time = time;
        this.image = image;
        this.category = category;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public  MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
