package com.example.spring_boot.adapter;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.spring_boot.usecase.PaymentServiceInterface;

@Profile("dev")
@Service("paymentService")
public class PaymentServiceDev implements PaymentServiceInterface {

    @Override
    public int charge(String userId, int amount) {
        return -1;
    }
}
