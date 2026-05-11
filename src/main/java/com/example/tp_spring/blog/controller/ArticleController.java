package com.example.tp_spring.blog.controller;

import org.springframework.web.bind.annotation.*;
        import java.util.List;
import com.example.tp_spring.blog.entity.Article;
import com.example.tp_spring.blog.service.ArticleService;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService service;

    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Article> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Article create(@RequestBody Article a) {
        return service.save(a);
    }
}