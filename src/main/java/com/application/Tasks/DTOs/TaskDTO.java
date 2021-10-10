package com.application.Tasks.DTOs;

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
