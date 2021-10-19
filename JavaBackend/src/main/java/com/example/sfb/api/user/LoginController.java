package com.example.sfb.api.user;

import com.example.sfb.domain.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
@AllArgsConstructor

public class LoginController {

    private final UserService userService;

    @GetMapping
    public UserDto login(@RequestHeader HttpHeaders headers){
        String creds = headers.getFirst("Authorization");
        String[] encodedCreds = creds.split(" ");
        byte[] decodedCreds = Base64.getDecoder().decode(encodedCreds[1]);
        String decodedStringCreds = new String(decodedCreds);
        String[] splitCreds = decodedStringCreds.split(":");
        return userService.getUser(splitCreds[0]);
    }
}
