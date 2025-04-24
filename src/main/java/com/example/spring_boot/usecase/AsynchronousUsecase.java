package com.example.spring_boot.usecase;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsynchronousUsecase {
    @Async
    public CompletableFuture<String> getAsync() {
        return CompletableFuture.completedFuture("[async usecase] thread name: " + Thread.currentThread().getName());
    }

    public String getSync() {
        return "[usecase] thread name: " + Thread.currentThread().getName();
    }
}
