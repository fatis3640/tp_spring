package com.example.tp_spring.blog.controller;

import com.example.tp_spring.blog.entity.Article;
import com.example.tp_spring.blog.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public Article getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Article create(@Valid @RequestBody Article article) {
        return service.save(article);
    }

    @PutMapping("/{id}")
    public Article update(
            @PathVariable Long id,
            @Valid @RequestBody Article article) {

        return service.update(id, article);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}