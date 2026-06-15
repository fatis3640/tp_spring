package com.example.tp_spring.product.service;

import com.example.tp_spring.product.entity.Product;
import com.example.tp_spring.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void delete(Long id) {
        repo.deleteById(id);
    }
    public Product getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Product update(Long id, Product product) {

        Product existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setDescription(product.getDescription());

            return repo.save(existing);
        }

        return null;
    }
}