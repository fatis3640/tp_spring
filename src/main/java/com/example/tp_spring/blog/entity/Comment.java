package com.example.tp_spring.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String text;
    private String author;

    @ManyToOne
    private Article article;

    // getters setters
}