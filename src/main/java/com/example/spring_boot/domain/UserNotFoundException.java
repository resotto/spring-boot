package com.example.spring_boot.domain;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String name) {
        super("User not found: " + name);
    }
}