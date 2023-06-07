package com.example.blogpostbe.services;

import com.example.blogpostbe.entities.CommentEnt;
import com.example.blogpostbe.entities.UserEnt;
import com.example.blogpostbe.repositories.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentRepo commentRepo;

    @Autowired
    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    public List<CommentEnt> getAllComments() {
        return (List<CommentEnt>) commentRepo.findAll();
    }

    public CommentEnt getCommentById(Long id) throws ChangeSetPersister.NotFoundException {
        return commentRepo.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public CommentEnt createComment(CommentEnt comment) {
        return commentRepo.save(comment);
    }

    public CommentEnt updateComment(CommentEnt comment) {
        return commentRepo.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepo.deleteById(id);
    }
}
