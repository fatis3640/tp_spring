package com.example.tp_spring.blog.service;

import com.example.tp_spring.blog.entity.Article;
import com.example.tp_spring.blog.repository.ArticleRepository;
import com.example.tp_spring.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository repo;

    public ArticleService(ArticleRepository repo) {
        this.repo = repo;
    }

    public List<Article> getAll() {
        return repo.findAll();
    }

    public Article getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Article not found with id: " + id));
    }

    public Article save(Article article) {
        return repo.save(article);
    }

    public Article update(Long id, Article article) {

        Article existing = getById(id);

        existing.setTitle(article.getTitle());
        existing.setContent(article.getContent());

        return repo.save(existing);
    }

    public void delete(Long id) {

        Article article = getById(id);

        repo.delete(article);
    }
}