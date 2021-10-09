package com.application.Tasks.DTOs;

public class TaskDeleteDTO extends AuthenticatedRequestDTO{
    private Long taskId;

    public TaskDeleteDTO(String userToken, Long taskId) {
        super(userToken);
        this.taskId = taskId;
    }

    public TaskDeleteDTO(Long taskId) {
        this.taskId = taskId;
    }

    public TaskDeleteDTO() {
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
