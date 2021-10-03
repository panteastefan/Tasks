package com.application.Tasks.Model;

public class UserDTO {
    Long userId;

    public UserDTO() {
    }

    public UserDTO(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                '}';
    }
}
