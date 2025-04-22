package com.example.spring_boot.domain;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Users")
public class User {

    @Id // for Primary Key
    private String id;

    @Min(0)
    @Max(120)
    private int age;

    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 10)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // for parent
    private List<Order> orders = new ArrayList<>();

    // Default constructor required for entity
    public User() {
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
