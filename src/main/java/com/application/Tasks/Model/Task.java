package com.application.Tasks.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Task {
    private @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue Long id;

    @NotNull
    @Size(min=3, max=20, message = "Name of the task should have between 3 and 20 characters")
    private String name;
    private String description;
    private Date dueDate;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    public Task() {
    }

    public Task(String name, String description, Date dueDate, Status status, User user) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task(Long id, String name, String description, Date dueDate, Status status, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.user = user;
    }

    public Task(String name, String description, Date dueDate, Status status) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", user=" + user +
                '}';
    }
}
