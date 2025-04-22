package com.example.spring_boot.usecase;

import org.springframework.stereotype.Component;

import com.example.spring_boot.domain.Order;

@Component
public class OrderUsecase {
    private final OrderRepositoryInterface orderRepo;

    public OrderUsecase(OrderRepositoryInterface repo) {
        orderRepo = repo;
    }

    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    public Order getOrder(Long id) {
        return orderRepo.findById(id).get();
    }
}
