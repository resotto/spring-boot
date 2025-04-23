package com.example.spring_boot.adapter;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.spring_boot.domain.Order;
import com.example.spring_boot.usecase.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderUsecase orderUsecase;
    private final TransactionalUsecase transactionalUsecase;

    public OrderController(OrderUsecase order, TransactionalUsecase transactional) {
        this.orderUsecase = order;
        this.transactionalUsecase = transactional;
    }

    @PostMapping("")
    public Order createOrder(@Valid @RequestBody Order order) {
        return orderUsecase.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderUsecase.getOrder(id);
    }

    @GetMapping("")
    public List<Order> getOrder(@RequestParam String userId) {
        return orderUsecase.getOrderByUserId(userId);
    }

    @PostMapping("/register")
    public Order registerOrder(@Valid @RequestBody Order order) {
        return transactionalUsecase.registerOrder(order);
    }
}
