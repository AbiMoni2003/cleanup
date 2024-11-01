package com.example.cleanup.service;

import com.example.cleanup.dto.UserResponseDto;
import com.example.cleanup.entity.User;
import com.example.cleanup.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto deleteInactiveUsers() {
        LocalDateTime thresholdDate = LocalDateTime.now().minus(6, ChronoUnit.MONTHS);
        List<User> inactiveUsers = userRepository.findInactiveUsers(thresholdDate);
        int deletedCount = 0;

        for (User user : inactiveUsers) {
            userRepository.deleteUserById(user.getId());
            deletedCount++;
        }

        return new UserResponseDto("Inactive users deleted", deletedCount);
    }
}
