package com.example.blogpostbe.services;

import com.example.blogpostbe.entities.UserEnt;
import com.example.blogpostbe.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserEnt> getAllUsers() {
        return (List<UserEnt>) userRepo.findAll();
    }

    public UserEnt getUserById(Long id) throws ChangeSetPersister.NotFoundException {
        return userRepo.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public UserEnt createUser(UserEnt user) {
        return userRepo.save(user);
    }

    public UserEnt updateUser(UserEnt user) {
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
