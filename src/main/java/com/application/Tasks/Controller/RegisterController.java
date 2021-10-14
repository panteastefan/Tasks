package com.application.Tasks.Controller;

import com.application.Tasks.DTOs.RegisterUserDTO;
import com.application.Tasks.Model.User;
import com.application.Tasks.Service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

@RestController
@RequestMapping("/register")
public class RegisterController {
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService){
        this.registerService = registerService;
    }
    @PostMapping("/add")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterUserDTO registerUserDTO){
        try{
            System.out.println(registerUserDTO);
            if (registerUserDTO == null){
                return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            }
            User user = registerService.register(registerUserDTO);
            if (user != null){
                return new ResponseEntity<>(user, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
        catch( ConstraintViolationException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
