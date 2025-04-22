package com.example.spring_boot.adapter;

import org.springframework.web.bind.annotation.*;

import com.example.spring_boot.domain.Order;
import com.example.spring_boot.usecase.OrderUsecase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderUsecase orderUsecase;

    public OrderController(OrderUsecase usecase) {
        this.orderUsecase = usecase;
    }

    @PostMapping("")
    public Order createOrder(@Valid @RequestBody Order order) {
        return orderUsecase.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderUsecase.getOrder(id);
    }
}
