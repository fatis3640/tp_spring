package com.example.tp_spring.product.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.tp_spring.product.entity.Product;
import com.example.tp_spring.product.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product save(Product p) {
        return repo.save(p);
    }
}