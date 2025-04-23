package com.example.spring_boot.usecase;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.example.spring_boot.domain.Order;

public interface OrderRepositoryInterface extends JpaRepository<Order, Long> {
    @Query(value = "SELECT * FROM orders WHERE user_id = :user_id", nativeQuery = true)
    List<Order> findByUserId(@Param("user_id") String userId);
}
