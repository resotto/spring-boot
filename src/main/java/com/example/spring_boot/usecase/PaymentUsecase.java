package com.example.spring_boot.usecase;

import org.springframework.stereotype.Component;

@Component
public class PaymentUsecase {
    private final PaymentServiceInterface service;

    // @Autowired unnecessary for single constructor
    public PaymentUsecase(PaymentServiceInterface service) {
        this.service = service;
    }

    public int execute(String userId, int amount) {
        return service.charge(userId, amount);
    }
}
