package com.example.blogpostbe.repositories;

import com.example.blogpostbe.entities.BlogEnt;
import com.example.blogpostbe.entities.UserEnt;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepo extends CrudRepository<BlogEnt, Long> {
}
