package com.example.spring_boot.adapter;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    private String name = "World";

    @GetMapping("/")
    public String hello() {
        return "Hello, " + name + "!";
    }

    @PostMapping("/update")
    public String update(@RequestParam String entity) {
        this.name = entity;
        return entity;
    }

}