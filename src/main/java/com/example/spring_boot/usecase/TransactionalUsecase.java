package com.example.spring_boot.usecase;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring_boot.domain.*;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TransactionalUsecase {
    private final UserRepositoryInterface userRepo;
    private final OrderRepositoryInterface orderRepo;

    public TransactionalUsecase(UserRepositoryInterface user, OrderRepositoryInterface order) {
        userRepo = user;
        orderRepo = order;
    }

    @Transactional
    public Order registerOrder(Order order) {
        orderRepo.save(order);
        if (order.getAmount() % 2 == 0) {
            throw new RuntimeException();
        }
        userRepo.save(new User(99, "temp"));
        return order;
    }
}
