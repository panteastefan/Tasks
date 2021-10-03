package com.application.Tasks.Model;

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
