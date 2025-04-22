package com.example.spring_boot.adapter;

import org.springframework.web.bind.annotation.*;

import com.example.spring_boot.usecase.PaymentUsecase;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentUsecase paymentUsecase;

    // @Autowired
    public PaymentController(PaymentUsecase paymentUsecase) {
        this.paymentUsecase = paymentUsecase;
    }

    @PostMapping("/charges/{userId}")
    public int charge(@PathVariable String userId) {
        return paymentUsecase.execute(userId, 200);
    }
}
