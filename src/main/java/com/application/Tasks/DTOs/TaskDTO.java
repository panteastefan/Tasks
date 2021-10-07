package com.application.Tasks.DTOs;

import com.application.Tasks.Model.Status;
import com.application.Tasks.Model.Task;

import java.util.Date;

public class TaskDTO extends AuthenticatedRequestDTO{
    Task task;
    public TaskDTO() {
    }

    public TaskDTO(String userToken, Task task) {
        super(userToken);
        this.task = task;
    }

    public TaskDTO(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
