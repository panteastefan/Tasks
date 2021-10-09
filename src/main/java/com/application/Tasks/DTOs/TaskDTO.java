package com.application.Tasks.DTOs;

import com.application.Tasks.Model.Status;
import com.application.Tasks.Model.Task;

import java.util.Date;

public class TaskDTO extends AuthenticatedRequestDTO{
    TaskCreationDTO taskCreationDTO;
    public TaskDTO() {
    }

    public TaskDTO(String userToken, TaskCreationDTO taskCreationDTO) {
        super(userToken);
        this.taskCreationDTO = taskCreationDTO;
    }

    public TaskDTO(TaskCreationDTO taskCreationDTO) {
        this.taskCreationDTO = taskCreationDTO;
    }

    public TaskCreationDTO getTaskCreationDTO() {
        return taskCreationDTO;
    }

    public void setTaskCreationDTO(TaskCreationDTO taskCreationDTO) {
        this.taskCreationDTO = taskCreationDTO;
    }
}
