package com.application.Tasks.Service;

import com.application.Tasks.Model.Task;
import com.application.Tasks.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(Task task) {
        task.setName("Task name");
        task.setDescription("Task description");
        task.setDate(new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime());
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
        taskRepository.deleteTaskById(id);
    }
}
