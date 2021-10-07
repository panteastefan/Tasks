package com.application.Tasks.Controller;

import com.application.Tasks.DTOs.AuthenticatedRequestDTO;
import com.application.Tasks.Model.User;
import com.application.Tasks.Service.LoginService;
import com.application.Tasks.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(@RequestBody AuthenticatedRequestDTO authenticatedRequestDTO){
        if (authenticatedRequestDTO != null &&
                LoginService.userTokenMap.get(authenticatedRequestDTO.getUserToken()) != null){

            List<User> users = userService.findAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

//    @GetMapping("/find/{id}")
//    public ResponseEntity<User> getUserById(Long id){
//        User user = userService.findUserById(id);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<User> addUser(@RequestBody User newUser){
//        User user = userService.addUser(newUser);
//        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
//    }
}