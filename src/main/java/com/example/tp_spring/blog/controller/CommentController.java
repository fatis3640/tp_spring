package com.example.tp_spring.blog.controller;

import com.example.tp_spring.blog.entity.Comment;
import com.example.tp_spring.blog.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Comment> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Comment getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/{articleId}")
    public Comment addComment(
            @PathVariable Long articleId,
            @Valid @RequestBody Comment comment) {

        return service.addComment(articleId, comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}