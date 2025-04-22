package com.example.spring_boot.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.*;
import org.springframework.context.annotation.*;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class PaymentUsecaseTest {

    @TestConfiguration
    static class MockConfig {
        @Bean // @Autowired doesn't resolve this via @ComponentScan so we need the
              // PaymentServiceStub with profile "test"
        @Primary // and we have two beans after registering the following one so we need @Primary
                 // to prioritize this
        PaymentServiceInterface paymentService() {
            return mock(PaymentServiceInterface.class);
        }
    }

    @Autowired
    private PaymentUsecase paymentUsecase;

    @Autowired
    private PaymentServiceInterface paymentService;

    @BeforeEach
    void setup() {
        Mockito.reset(paymentService);
    }

    @Test
    void successCase() {
        when(paymentService.charge(anyString(), anyInt())).thenReturn(1000);

        var res = paymentUsecase.execute("test-id", 200);
        assertEquals(1000, res);
    }

    @Test
    void failureCase() {
        when(paymentService.charge(anyString(), anyInt())).thenReturn(-1);

        var res = paymentUsecase.execute("test-id", 200);
        assertEquals(-1, res);
    }

}
