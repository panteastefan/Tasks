package com.application.Tasks.Service;

import com.application.Tasks.DTOs.LoginDTO;
import com.application.Tasks.Model.User;
import com.application.Tasks.Repository.UserRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    private final UserRepository userRepository;
    public static Map<String, Long> userTokenMap = new HashMap<>();

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    final String LOGIN_SECRET_PASSWORD = "rsOha.y[m#!GJ%.>\"HE[F4K;*aVe-vtF/]/<9qC_zjc}S[xNaNm8/Xw1f8zb&H1";
    final String TOKEN = "m#!TU=Im20`Rn[}8'*Sp5Hm)>unnU|Ip]R|bEgpnq4?A3j0j7r3XF;?b&'#f[hf";
    public String authenticate(LoginDTO loginDTO){
        String hashedPassword = Hashing.sha256().hashString(loginDTO.getPassword() + LOGIN_SECRET_PASSWORD,
                        StandardCharsets.UTF_8).toString();
        System.out.println(hashedPassword);
        User user = userRepository.findUserByUserNameAndPassword(loginDTO.getUsername(), hashedPassword);
        String token = null;
        if (user != null){
            token = Hashing.sha256().hashString(user.getUserName() + TOKEN +
                            System.currentTimeMillis(), StandardCharsets.UTF_8).toString();
            userTokenMap.put(token, user.getId());
        }
        return token;
    }
}
