package com.application.Tasks.Controller;

import com.application.Tasks.DTOs.AuthenticatedRequestDTO;
import com.application.Tasks.DTOs.TaskDTO;
import com.application.Tasks.DTOs.TaskDeleteDTO;
import com.application.Tasks.Model.Task;
import com.application.Tasks.Service.LoginService;
import com.application.Tasks.Service.TaskService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@RequestBody TaskDTO taskDTO){
        if (taskDTO != null &&
                LoginService.userTokenMap.get(taskDTO.getUserToken()) != null){
            Task newTask = taskService.addTask(taskDTO.getTaskCreationDTO());
            return new ResponseEntity<>(newTask, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
    @PostMapping("/update")
    public ResponseEntity<Task> updateTask(@RequestBody TaskDTO taskDTO){
        if (taskDTO != null &&
                LoginService.userTokenMap.get(taskDTO.getUserToken()) != null){
            Task newTask = taskService.updateTask(taskDTO.getTaskCreationDTO());
            return new ResponseEntity<>(newTask, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/delete")
    public ResponseEntity<Long> deleteTask(@RequestBody TaskDeleteDTO taskDeleteDTO){
        if (taskDeleteDTO != null &&
                LoginService.userTokenMap.get(taskDeleteDTO.getUserToken()) != null){
            boolean isRemoved = taskService.deleteTaskById(taskDeleteDTO);

            if (!isRemoved) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(taskDeleteDTO.getId(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
