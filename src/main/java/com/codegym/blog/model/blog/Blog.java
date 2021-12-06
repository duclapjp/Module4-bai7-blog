package com.codegym.blog.model.blog;

import com.codegym.blog.model.category.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "tieu de khong duoc bo trong")
    private String title;
    @NotEmpty(message = "noi dung khong duoc bo trong")
    private String content;
    @NotEmpty(message = "tac gia khong duoc bo trong")
    private String author;
    private Date time;
    private String image;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="category_id")
    private Category category;
    public Blog() {
    }

    public Blog(@NotEmpty String title,@NotEmpty String content,@NotEmpty String author, Date time,String image,Category category) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.time = time;
        this.image = image;
        this.category = category;
    }

    public Blog(Long id, String title, String content, String author, Date time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.time = time;
    }

    public Blog(@NotEmpty String title,@NotEmpty String content, String author, Date time, Category category) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.time = time;
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
}
