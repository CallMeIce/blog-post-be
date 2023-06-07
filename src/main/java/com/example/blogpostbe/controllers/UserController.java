package com.example.blogpostbe.controllers;

import com.example.blogpostbe.entities.UserEnt;
import com.example.blogpostbe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<UserEnt>> getAllUsers() {
        List<UserEnt> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<UserEnt> getUserById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        UserEnt user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<UserEnt> createUser(@RequestBody UserEnt user) {
        UserEnt createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/edit{id}")
    public ResponseEntity<UserEnt> updateUser(@PathVariable Long id, @RequestBody UserEnt user) {
        UserEnt updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
