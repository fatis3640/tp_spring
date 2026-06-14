package com.example.tp_spring.product.entity;

import jakarta.persistence.*;
        import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Positive
    private double price;

    @NotBlank
    private String description;

    // getters and setters

}