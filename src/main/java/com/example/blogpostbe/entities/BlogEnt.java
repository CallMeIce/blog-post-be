package com.example.blogpostbe.entities;

import javax.persistence.*;
import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BlogEnt {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String body;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEnt author;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEnt> comments = new ArrayList<>();

    public BlogEnt(String title, String body, LocalDateTime createdDate, LocalDateTime updatedDate, UserEnt author) {
        this.title = title;
        this.body = body;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.author = author;
    }

    public BlogEnt() {}

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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public UserEnt getAuthor() {
        return author;
    }

    public void setAuthor(UserEnt author) {
        this.author = author;
    }

    public List<CommentEnt> getComments() {
        return comments;
    }

    public void setComments(List<CommentEnt> comment) {
        this.comments = comments;
    }

    public void addComment(CommentEnt comment) {
        comments.add(comment);
        comment.setBlog(this);
    }

    public void removeComment(CommentEnt comment) {
        comments.remove(comment);
        comment.setBlog(null);
    }
}
