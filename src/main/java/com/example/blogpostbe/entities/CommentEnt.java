package com.example.blogpostbe.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class CommentEnt {

    @Id
    @GeneratedValue
    private Long id;

    private String content;
    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEnt author;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private BlogEnt blog;

    // Constructors

    public CommentEnt() {
    }

    public CommentEnt(String content, LocalDateTime createdDate, UserEnt author, BlogEnt blog) {
        this.content = content;
        this.createdDate = createdDate;
        this.author = author;
        this.blog = blog;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public UserEnt getAuthor() {
        return author;
    }

    public void setAuthor(UserEnt author) {
        this.author = author;
    }

    public BlogEnt getBlog() {
        return blog;
    }

    public void setBlog(BlogEnt blog) {
        this.blog = blog;
    }
}
