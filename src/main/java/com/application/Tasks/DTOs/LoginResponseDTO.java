package com.application.Tasks.DTOs;

public class LoginResponseDTO {
    String loginToken;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String loginToken) {
        this.loginToken = loginToken;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }
}
