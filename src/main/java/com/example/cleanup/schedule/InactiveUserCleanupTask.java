package com.example.cleanup.schedule;

import com.example.cleanup.dto.UserResponseDto;
import com.example.cleanup.service.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class InactiveUserCleanupTask {
    private final UserService userService;

    public InactiveUserCleanupTask(UserService userService) {
        this.userService = userService;
    }

    @Scheduled(cron = "* * * * * ?")
    public void performCleanup() {
        UserResponseDto response = userService.deleteInactiveUsers();
        System.out.println("Cleanup task completed: " + response.getMessage() + ", Users deleted: " + response.getDeletedUserCount());
    }
}
