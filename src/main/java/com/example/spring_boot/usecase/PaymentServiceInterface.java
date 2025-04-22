package com.example.spring_boot.usecase;

public interface PaymentServiceInterface {
    int charge(String userId, int amount);
}
