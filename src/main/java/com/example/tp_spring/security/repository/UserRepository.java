package com.example.tp_spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tp_spring.security.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}