package com.application.Tasks.DTOs;

import com.application.Tasks.Model.Status;

import java.util.Date;

public class TaskDTO extends AuthenticatedRequestDTO{
    private String name;
    private String description;
    private Date dueDate;
    private Status status;
    private Long userId;

    public TaskDTO() {
    }

    public TaskDTO(String userToken, String name, String description, Date dueDate, Status status, Long userId) {
        super(userToken);
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
