package com.application.Tasks.DTOs;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterUserDTO {
    @NotNull
    @Size(min=3, max=20)
    String username;
    @NotNull
    @Size(min=3)
    String password;
    @NotNull
    @Size(min=3, max=30)
    String name;

    public RegisterUserDTO() {
    }

    public RegisterUserDTO(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RegisterUserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
