package com.example.cleanup.controller;

import com.example.cleanup.dto.UserResponseDto;
import com.example.cleanup.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("/cleanup")
    public UserResponseDto deleteInactiveUsers() {
        return userService.deleteInactiveUsers();
    }
}
