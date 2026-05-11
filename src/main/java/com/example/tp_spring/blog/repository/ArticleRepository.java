package com.example.tp_spring.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tp_spring.blog.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}