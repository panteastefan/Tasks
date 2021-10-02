package com.application.Tasks.Controller;

import com.application.Tasks.Model.Task;
import com.application.Tasks.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.findAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Task> getTaskById(Long id){
        Task task = taskService.findTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@RequestBody Task newTask){
        Task task = taskService.addTask(newTask);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }
}
