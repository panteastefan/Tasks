package com.application.Tasks.Service;
import com.application.Tasks.DTOs.RegisterUserDTO;
import com.application.Tasks.Model.User;
import com.application.Tasks.Repository.UserRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
@Service
public class RegisterService {

    private final UserRepository userRepository;

    @Autowired
    public RegisterService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    final String REGISTER_SECRET_PASSWORD = "rsOha.y[m#!GJ%.>\"HE[F4K;*aVe-vtF/]/<9qC_zjc}S[xNaNm8/Xw1f8zb&H1";

    private boolean isUsernameAvailable(@Valid @RequestBody RegisterUserDTO registerUserDTO){
        return !userRepository.existsUserByUsername(registerUserDTO.getUsername());
    }

    public User register(@Valid @RequestBody RegisterUserDTO registerUserDTO){
        if (this.isUsernameAvailable(registerUserDTO)){
            String hashedPassword = Hashing.sha256().hashString(registerUserDTO.getPassword() + REGISTER_SECRET_PASSWORD,
                    StandardCharsets.UTF_8).toString();
            User user = new User(registerUserDTO.getUsername(), hashedPassword,
                    registerUserDTO.getName());
            return this.userRepository.saveAndFlush(user);
        }
        return null;
    }
}
