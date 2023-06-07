package com.example.blogpostbe.repositories;

import com.example.blogpostbe.entities.UserEnt;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEnt, Long> {
}
