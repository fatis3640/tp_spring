package com.example.tp_spring.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tp_spring.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}