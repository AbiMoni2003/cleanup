package com.example.cleanup.dto;

public class UserResponseDto {
    private String message;
    private int deletedUserCount;

    public UserResponseDto(String message, int deletedUserCount) {
        this.message = message;
        this.deletedUserCount = deletedUserCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getDeletedUserCount() {
        return deletedUserCount;
    }

    public void setDeletedUserCount(int deletedUserCount) {
        this.deletedUserCount = deletedUserCount;
    }
}
