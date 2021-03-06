package com.application.Tasks.Service;

import com.application.Tasks.DTOs.TaskCreationDTO;
import com.application.Tasks.DTOs.TaskDeleteDTO;
import com.application.Tasks.Model.Task;
import com.application.Tasks.Model.User;
import com.application.Tasks.Repository.TaskRepository;
import com.application.Tasks.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.*;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    private final UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Task addTask(@Valid @RequestBody TaskCreationDTO taskCreationDTO) {
        User user = userRepository.findUserByUsername(taskCreationDTO.getUsername());
        Task task = new Task(taskCreationDTO.getName(), taskCreationDTO.getDescription(),
                taskCreationDTO.getDueDate(), taskCreationDTO.getStatus(),
                user);
        return taskRepository.saveAndFlush(task);
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> findMyTasks(Long userId) {
        return taskRepository.findTasksByUserId(userId);
    }

    public Task updateTask(@Valid @RequestBody TaskCreationDTO taskCreationDTO) {
        User user = userRepository.findUserByUsername(taskCreationDTO.getUsername());
        Task task = new Task(taskCreationDTO.getId(), taskCreationDTO.getName(), taskCreationDTO.getDescription(),
                taskCreationDTO.getDueDate(), taskCreationDTO.getStatus(),
                user);
        return taskRepository.saveAndFlush(task);
    }

    @Transactional
    public Long deleteTaskById(TaskDeleteDTO taskDeleteDTO) {
        return taskRepository.deleteTaskById(taskDeleteDTO.getTaskId());
    }
}
