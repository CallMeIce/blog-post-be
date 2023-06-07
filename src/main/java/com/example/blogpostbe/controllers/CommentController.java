package com.example.blogpostbe.controllers;

import com.example.blogpostbe.entities.CommentEnt;
import com.example.blogpostbe.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<CommentEnt>> getAllComments() {
        List<CommentEnt> comments = commentService.getAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<CommentEnt> getCommentById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        CommentEnt comment = commentService.getCommentById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<CommentEnt> createComment(@RequestBody CommentEnt comment) {
        CommentEnt createdComment = commentService.createComment(comment);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("edit/{id}")
    public ResponseEntity<CommentEnt> updateComment(@PathVariable Long id, @RequestBody CommentEnt comment) {
        CommentEnt updatedComment = commentService.updateComment(comment);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
