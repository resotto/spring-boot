package com.example.spring_boot.usecase;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot.domain.Order;

public interface OrderRepositoryInterface extends JpaRepository<Order, Long> {
}
