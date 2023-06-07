package com.example.blogpostbe.controllers;

import com.example.blogpostbe.entities.BlogEnt;
import com.example.blogpostbe.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<BlogEnt>> getAllBlogs() {
        List<BlogEnt> blogs = blogService.getAllBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<BlogEnt> getBlogById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        BlogEnt blog = blogService.getBlogById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<BlogEnt> createBlog(@RequestBody BlogEnt blog) {
        BlogEnt createdBlog = blogService.createBlog(blog);
        return new ResponseEntity<>(createdBlog, HttpStatus.CREATED);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<BlogEnt> updateBlog(@PathVariable Long id, @RequestBody BlogEnt blog) {
        BlogEnt updatedBlog = blogService.updateBlog(blog);
        return new ResponseEntity<>(updatedBlog, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
