package com.application.Tasks.Controller;

import com.application.Tasks.DTOs.AuthenticatedRequestDTO;
import com.application.Tasks.DTOs.TaskCreationDTO;
import com.application.Tasks.DTOs.TaskDTO;
import com.application.Tasks.DTOs.TaskDeleteDTO;
import com.application.Tasks.Mapper.TaskMapper;
import com.application.Tasks.Model.Task;
import com.application.Tasks.Service.LoginService;
import com.application.Tasks.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/all")
    public ResponseEntity<List<TaskCreationDTO>> getAllTasks(@RequestBody AuthenticatedRequestDTO authenticatedRequestDTO){
        if (authenticatedRequestDTO != null &&
                LoginService.userTokenMap.get(authenticatedRequestDTO.getUserToken()) != null){
            List<Task> tasks = taskService.findAllTasks();
            tasks.sort(Comparator.comparing(Task::getDueDate).reversed());

            List<TaskCreationDTO> taskCreationDTOs = tasks.stream().map(
                    TaskMapper::mapTaskToDTO).collect(Collectors.toList());
            return new ResponseEntity<>(taskCreationDTOs, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/mine")
    public ResponseEntity<List<TaskCreationDTO>> getMyTasks(@RequestBody AuthenticatedRequestDTO authenticatedRequestDTO){
        if (authenticatedRequestDTO != null &&
                LoginService.userTokenMap.get(authenticatedRequestDTO.getUserToken()) != null){

            List<Task> tasks =
                    taskService.findMyTasks(LoginService.userTokenMap.get(authenticatedRequestDTO.getUserToken()));
            tasks.sort(Comparator.comparing(Task::getDueDate).reversed());

            List<TaskCreationDTO> taskCreationDTOs = tasks.stream().map(
                    TaskMapper::mapTaskToDTO).collect(Collectors.toList());
            return new ResponseEntity<>(taskCreationDTOs, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@Valid @RequestBody TaskDTO taskDTO){
        try{
            if (taskDTO != null && LoginService.userTokenMap.get(taskDTO.getUserToken()) != null){
                if (taskDTO.getTaskCreationDTO().getUsername().equals("")){
                    return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
                }
                Task newTask = taskService.addTask(taskDTO.getTaskCreationDTO());
                return new ResponseEntity<>(newTask, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        catch( ConstraintViolationException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Task> updateTask(@Valid @RequestBody TaskDTO taskDTO){
        try{
            if (taskDTO != null &&
                    LoginService.userTokenMap.get(taskDTO.getUserToken()) != null){
                if (taskDTO.getTaskCreationDTO().getUsername().equals("")){
                    return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
                }
                Task newTask = taskService.updateTask(taskDTO.getTaskCreationDTO());

                return new ResponseEntity<>(newTask, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        catch( ConstraintViolationException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<Long> deleteTask(@RequestBody TaskDeleteDTO taskDeleteDTO){
        if (taskDeleteDTO != null &&
                LoginService.userTokenMap.get(taskDeleteDTO.getUserToken()) != null){
            Long isRemoved = taskService.deleteTaskById(taskDeleteDTO);
            if (isRemoved != null) {
                return new ResponseEntity<>(taskDeleteDTO.getTaskId(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
