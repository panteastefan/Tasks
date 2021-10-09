package com.application.Tasks.Mapper;

import com.application.Tasks.DTOs.TaskCreationDTO;
import com.application.Tasks.Model.Task;

public class TaskMapper {
    public static TaskCreationDTO mapTaskToDTO(Task task){
        TaskCreationDTO taskCreationDTO = new TaskCreationDTO();
        taskCreationDTO.setId(task.getId());
        taskCreationDTO.setDescription(task.getDescription());
        taskCreationDTO.setDueDate(task.getDueDate());
        taskCreationDTO.setStatus(task.getStatus());
        taskCreationDTO.setName(task.getName());
        taskCreationDTO.setUsername(task.getUser().getUsername());
        return taskCreationDTO;
    }
}
