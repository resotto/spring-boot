package com.example.spring_boot.usecase;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot.domain.User;

public interface UserRepositoryInterface extends JpaRepository<User, String> {
}
