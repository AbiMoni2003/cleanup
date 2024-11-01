package com.example.cleanup.repository;

import com.example.cleanup.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository {
    List<User> findInactiveUsers(LocalDateTime thresholdDate);
    void deleteUserById(Long id);
}
