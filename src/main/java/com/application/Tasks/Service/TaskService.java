package com.application.Tasks.Service;

import com.application.Tasks.Model.Status;
import com.application.Tasks.Model.Task;
import com.application.Tasks.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(Task task) {
        task.setName(task.getName());
        task.setDescription(task.getDescription());
        task.setDueDate(task.getDueDate());
        task.setStatus(Status.NEW);
        return taskRepository.save(task);
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public Task findTaskById(Long id) {
        return taskRepository.findTaskById(id);
    }

    public void deleteTask(Long id) {
        // @TODO taskRepository.deleteTaskById(id); not working. why ??
        taskRepository.deleteById(id);
    }
}
