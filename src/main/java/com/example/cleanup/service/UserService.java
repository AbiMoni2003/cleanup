package com.example.cleanup.service;

import com.example.cleanup.dto.UserResponseDto;

public interface UserService {
    UserResponseDto deleteInactiveUsers();
}
