package com.example.tp_spring.product.controller;

import org.springframework.web.bind.annotation.*;
        import java.util.List;
import jakarta.validation.Valid;
import com.example.tp_spring.product.entity.Product;
import com.example.tp_spring.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Product create(@Valid @RequestBody Product p) {
        return service.save(p);
    }
}