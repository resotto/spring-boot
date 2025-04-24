package com.example.spring_boot.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.example.spring_boot.domain.Order;
import com.example.spring_boot.usecase.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Value("${LOG_LEVEL:defaultLogLevel}")
    private String logLevel;

    private final OrderUsecase orderUsecase;
    private final TransactionalUsecase transactionalUsecase;
    private final AsynchronousUsecase asynchronousUsecase;

    public OrderController(OrderUsecase order, TransactionalUsecase transactional, AsynchronousUsecase async) {
        this.orderUsecase = order;
        this.transactionalUsecase = transactional;
        this.asynchronousUsecase = async;
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

    @GetMapping("/loglevel")
    public String getLogLevel() {
        return logLevel;
    }

    @GetMapping("/async/{isAsync}")
    public String getAsyncResult(@PathVariable boolean isAsync) {
        var sb = new StringBuilder();
        sb.append("[controller] thread name: " + Thread.currentThread().getName() + "\n");
        if (isAsync) {
            try {
                sb.append(asynchronousUsecase.getAsync().get());
            } catch (Exception e) {
                sb.append("failed to getAsync().get()");
            }
        } else {
            sb.append(asynchronousUsecase.getSync());
        }
        return sb.toString();
    }
}
