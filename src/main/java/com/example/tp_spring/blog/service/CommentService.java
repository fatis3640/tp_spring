package com.example.tp_spring.blog.service;

import lombok.Setter;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.tp_spring.blog.entity.Comment;
import com.example.tp_spring.blog.entity.Article;
import com.example.tp_spring.blog.repository.CommentRepository;
import com.example.tp_spring.blog.repository.ArticleRepository;

@Service
public class CommentService {

    private final CommentRepository commentRepo;
    private final ArticleRepository articleRepo;

    public CommentService(CommentRepository c, ArticleRepository a) {
        this.commentRepo = c;
        this.articleRepo = a;
    }

    public List<Comment> getAll() {
        return commentRepo.findAll();
    }

    public Comment addComment(Long articleId, Comment comment) {
        Article article = articleRepo.findById(articleId).orElse(null);
        if (article != null) {
            comment.setArticle(article);
            return commentRepo.save(comment);
        }
        return null;
    }
}