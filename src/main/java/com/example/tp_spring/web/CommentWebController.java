package com.example.tp_spring.web;

import com.example.tp_spring.blog.entity.Comment;
import com.example.tp_spring.blog.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentWebController {

    private final CommentService service;

    public CommentWebController(CommentService service) {
        this.service = service;
    }

    @GetMapping("/comments")
    public String comments(Model model) {

        model.addAttribute("comments", service.getAll());

        return "comments";
    }

    @GetMapping("/comments/new")
    public String addForm() {
        return "add-comment";
    }

    @GetMapping("/comments/edit/{id}")
    public String editComment(@PathVariable Long id,
                              Model model) {

        model.addAttribute("comment",
                service.getById(id));

        return "edit-comment";
    }

    @PostMapping("/comments/update/{id}")
    public String updateComment(
            @PathVariable Long id,
            @ModelAttribute Comment comment) {

        service.update(id, comment);

        return "redirect:/comments";
    }

    @GetMapping("/comments/delete/{id}")
    public String deleteComment(@PathVariable Long id) {

        service.delete(id);

        return "redirect:/comments";
    }
}