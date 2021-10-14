package com.application.Tasks.Controller;

import com.application.Tasks.DTOs.AuthenticatedRequestDTO;
import com.application.Tasks.DTOs.LoginResponseDTO;
import com.application.Tasks.Service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logout")
public class LogoutController {
    public LogoutController(){
    }

    @PostMapping("/exit")
    public ResponseEntity<LoginResponseDTO> logout(@RequestBody AuthenticatedRequestDTO authenticatedRequestDTO){
        LoginService.userTokenMap.remove(authenticatedRequestDTO.getUserToken());
        return new ResponseEntity<>(new LoginResponseDTO(authenticatedRequestDTO.getUserToken()), HttpStatus.OK);
    }
}
