package com.example.spring_boot.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.spring_boot.domain.Order;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderUsecase {
    private final OrderRepositoryInterface orderRepo;

    public OrderUsecase(OrderRepositoryInterface repo) {
        orderRepo = repo;
    }

    public Order createOrder(Order order) {
        log.debug("createOrder called");
        return orderRepo.save(order);
    }

    public Order getOrder(Long id) {
        log.info("getOrder called");
        return orderRepo.findById(id).get();
    }

    public List<Order> getOrderByUserId(String userId) {
        return orderRepo.findByUserId(userId);
    }
}
