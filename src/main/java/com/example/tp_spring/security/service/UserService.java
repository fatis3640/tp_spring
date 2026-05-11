package com.example.tp_spring.security.service;

import org.springframework.stereotype.Service;
import com.example.tp_spring.security.repository.UserRepository;
import com.example.tp_spring.security.entity.User;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User save(User user) {
        return repo.save(user);
    }
}