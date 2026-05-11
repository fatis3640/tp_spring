package com.example.tp_spring.blog.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.tp_spring.blog.entity.Article;
import com.example.tp_spring.blog.repository.ArticleRepository;

@Service
public class ArticleService {

    private final ArticleRepository repo;

    public ArticleService(ArticleRepository repo) {
        this.repo = repo;
    }

    public List<Article> getAll() {
        return repo.findAll();
    }

    public Article save(Article a) {
        return repo.save(a);
    }
}