package com.example.tp_spring.web;

import com.example.tp_spring.blog.entity.Article;
import com.example.tp_spring.blog.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleWebController {

    private final ArticleService service;

    public ArticleWebController(ArticleService service) {
        this.service = service;
    }

    @GetMapping("/articles")
    public String articles(Model model) {

        model.addAttribute("articles", service.getAll());

        return "articles";
    }

    @GetMapping("/articles/new")
    public String addForm() {
        return "add-article";
    }

    @PostMapping("/articles/add")
    public String addArticle(@ModelAttribute Article article) {

        service.save(article);

        return "redirect:/articles";
    }

    @GetMapping("/articles/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {

        service.delete(id);

        return "redirect:/articles";
    }

    @GetMapping("/articles/edit/{id}")
    public String editArticle(@PathVariable Long id, Model model) {

        model.addAttribute("article",
                service.getById(id));

        return "edit-article";
    }

    @PostMapping("/articles/update/{id}")
    public String updateArticle(
            @PathVariable Long id,
            @ModelAttribute Article article) {

        service.update(id, article);

        return "redirect:/articles";
    }
}