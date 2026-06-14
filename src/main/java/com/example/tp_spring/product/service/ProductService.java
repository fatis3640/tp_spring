package com.example.tp_spring.product.service;

import com.example.tp_spring.exception.ResourceNotFoundException;
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

    public Product getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found with id: " + id));
    }

    public Product save(Product product) {
        return repo.save(product);
    }

    public Product update(Long id, Product product) {

        Product existing = getById(id);

        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setDescription(product.getDescription());

        return repo.save(existing);
    }

    public void delete(Long id) {

        Product product = getById(id);

        repo.delete(product);
    }
}