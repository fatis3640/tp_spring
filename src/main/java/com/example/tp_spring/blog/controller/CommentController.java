package com.example.tp_spring.blog.controller;

import org.springframework.web.bind.annotation.*;
        import java.util.List;
import com.example.tp_spring.blog.entity.Comment;
import com.example.tp_spring.blog.service.CommentService;

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

    @PostMapping("/{articleId}")
    public Comment add(@PathVariable Long articleId,
                       @RequestBody Comment comment) {
        return service.addComment(articleId, comment);
    }
}