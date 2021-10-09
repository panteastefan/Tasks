package com.application.Tasks.DTOs;

import com.application.Tasks.Model.Status;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

public class TaskCreationDTO{
    private String name;
    private String description;
    private Date dueDate;
    private Status status;
    private String username;

    public TaskCreationDTO() {
    }

    public TaskCreationDTO(String name, String description, Date dueDate, Status status, String username) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
