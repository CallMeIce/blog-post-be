package com.example.blogpostbe.services;

import com.example.blogpostbe.entities.BlogEnt;
import com.example.blogpostbe.repositories.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    private final BlogRepo blogRepo;

    @Autowired
    public BlogService(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }

    public List<BlogEnt> getAllBlogs() {
        return (List<BlogEnt>) blogRepo.findAll();
    }

    public BlogEnt getBlogById(Long id) throws ChangeSetPersister.NotFoundException {
        return blogRepo.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public BlogEnt createBlog(BlogEnt blog) {
        return blogRepo.save(blog);
    }

    public BlogEnt updateBlog(BlogEnt blog) {
        return blogRepo.save(blog);
    }

    public void deleteBlog(Long id) {
        blogRepo.deleteById(id);
    }
}