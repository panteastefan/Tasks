package com.application.Tasks.Controller;
import com.application.Tasks.Model.User;
import com.application.Tasks.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/add")
    public ResponseEntity<User> userRegistration(User newUser){
        User user = userService.addUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}