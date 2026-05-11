package com.example.tp_spring.blog;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
        import com.example.tp_spring.blog.entity.Article;

public class ArticleServiceTest {

    @Test
    void testArticleTitle() {

        Article a = new Article();
        a.setTitle("Hello");

        assertEquals("Hello", a.getTitle());
    }
}