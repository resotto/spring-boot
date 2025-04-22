package com.example.spring_boot.adapter;

import java.util.*;

import org.springframework.web.bind.annotation.*;

import com.example.spring_boot.domain.*;
import com.example.spring_boot.usecase.UserUsecase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private Map<String, User> nameUsers = new HashMap<>();

    private final UserUsecase userUsecase;

    // @Autowired
    public UserController(UserUsecase usecase) {
        this.userUsecase = usecase;
    }

    @PostMapping(path = "", consumes = "application/json")
    public String createUser(@Valid @RequestBody User user) {
        nameUsers.put(user.getName(), user);
        return user.getName();
    }

    @GetMapping("")
    public int getUserAge(@RequestParam String name) {
        if (nameUsers.get(name) == null) {
            throw new UserNotFoundException(name);
        }
        return nameUsers.get(name).getAge();
    }

    @GetMapping(path = "/{name}", produces = "application/json")
    @ResponseBody
    public User getUser(@PathVariable String name) {
        if (nameUsers.get(name) == null) {
            throw new UserNotFoundException(name);
        }
        return nameUsers.get(name);
    }

    @PostMapping("/db")
    public User saveUser(@Valid @RequestBody User user) {
        return userUsecase.saveUser(user);
    }

    @GetMapping("/db/{id}")
    public User getUserById(@PathVariable String id) {
        return userUsecase.getUser(id);
    }
}
