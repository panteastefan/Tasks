package com.application.Tasks.Controller;

import com.application.Tasks.DTOs.AuthenticatedRequestDTO;
import com.application.Tasks.Model.Task;
import com.application.Tasks.Service.LoginService;
import com.application.Tasks.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks(@RequestBody AuthenticatedRequestDTO authenticatedRequestDTO){
        if (authenticatedRequestDTO != null &&
                LoginService.userTokenMap.get(authenticatedRequestDTO.getUserToken()) != null){
            List<Task> tasks = taskService.findAllTasks();
            tasks.sort(Comparator.comparing(Task::getDueDate));
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
    @PostMapping("/mine")
    public ResponseEntity<List<Task>> getMyTasks(@RequestBody AuthenticatedRequestDTO authenticatedRequestDTO){
        if (authenticatedRequestDTO != null &&
                LoginService.userTokenMap.get(authenticatedRequestDTO.getUserToken()) != null){

            List<Task> tasks =
                    taskService.findMyTasks(LoginService.userTokenMap.get(authenticatedRequestDTO.getUserToken()));

            tasks.sort(Comparator.comparing(Task::getDueDate).reversed());
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

//    @GetMapping("/find/{id}")
//    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id){
//        Task task = taskService.findTaskById(id);
//        return new ResponseEntity<>(task, HttpStatus.OK);
//    }

    // in loc de Task -> TaskDTO
    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        Task newTask = taskService.addTask(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

//    @PostMapping("/update")
//    public ResponseEntity<Task> updateTask(@RequestBody Task task){
//        Task updateTask = taskService.updateTask(task);
//        return new ResponseEntity<>(updateTask, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteTask(@PathVariable("id") Long id){
//        taskService.deleteTask(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
