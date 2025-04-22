package com.example.spring_boot.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Orders", indexes = @Index(name = "orders_by_user_id", columnList = "user_id"))
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private int amount;

    @ManyToOne(fetch = FetchType.EAGER)
    // @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference // for child
    private User user;
}
