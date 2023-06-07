package com.example.blogpostbe.repositories;

import com.example.blogpostbe.entities.CommentEnt;
import com.example.blogpostbe.entities.UserEnt;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<CommentEnt, Long> {
}
