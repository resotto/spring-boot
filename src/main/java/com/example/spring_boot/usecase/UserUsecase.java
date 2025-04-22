package com.example.spring_boot.usecase;

import org.springframework.stereotype.Component;

import com.example.spring_boot.domain.User;

@Component
public class UserUsecase {
    private final UserRepositoryInterface userRepo;

    public UserUsecase(UserRepositoryInterface repo) {
        userRepo = repo;
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public User getUser(String id) {
        return userRepo.findById(id).get();
    }
}
