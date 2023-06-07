package com.example.blogpostbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.blogpostbe.entities")
public class BlogPostBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogPostBeApplication.class, args);
    }

}
