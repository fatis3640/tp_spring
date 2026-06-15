package com.example.tp_spring.blog.service;

import com.example.tp_spring.blog.entity.Article;
import com.example.tp_spring.blog.entity.Comment;
import com.example.tp_spring.blog.repository.ArticleRepository;
import com.example.tp_spring.blog.repository.CommentRepository;
import com.example.tp_spring.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepo;
    private final ArticleRepository articleRepo;

    public CommentService(CommentRepository commentRepo,
                          ArticleRepository articleRepo) {
        this.commentRepo = commentRepo;
        this.articleRepo = articleRepo;
    }

    public List<Comment> getAll() {
        return commentRepo.findAll();
    }

    public Comment getById(Long id) {
        return commentRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Comment not found with id: " + id));
    }

    public Comment addComment(Long articleId, Comment comment) {

        Article article = articleRepo.findById(articleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Article not found with id: " + articleId));

        comment.setArticle(article);

        return commentRepo.save(comment);
    }

    public void delete(Long id) {

        Comment comment = getById(id);

        commentRepo.delete(comment);
    }
    public Comment update(Long id, Comment comment) {

        Comment existing = getById(id);

        existing.setText(comment.getText());
        existing.setAuthor(comment.getAuthor());

        return commentRepo.save(existing);
    }
}