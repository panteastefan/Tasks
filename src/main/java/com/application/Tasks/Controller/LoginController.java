package com.application.Tasks.Controller;

import com.application.Tasks.Model.LoginDTO;
import com.application.Tasks.Model.LoginResponseDTO;
import com.application.Tasks.Model.UserDTO;
import com.application.Tasks.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/add")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDTO){
        String token = loginService.authenticate(loginDTO);
        if (token != null){
            return new ResponseEntity<>(new LoginResponseDTO(token), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }
}