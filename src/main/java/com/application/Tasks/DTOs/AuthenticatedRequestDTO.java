package com.application.Tasks.DTOs;

public class AuthenticatedRequestDTO {
    String userToken;

    public AuthenticatedRequestDTO(String userToken) {
        this.userToken = userToken;
    }

    public AuthenticatedRequestDTO() {
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
