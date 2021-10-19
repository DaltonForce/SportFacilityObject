package com.example.sfb.api.user;

import com.example.sfb.domain.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

    @PatchMapping("/{userId}")
    public void changeUserRole(@PathVariable int userId, @RequestParam String role){
        userService.changeUserRole(role, userId);
    }

    @PostMapping("/registration")
    public void register(@RequestBody UserDto userDto){
        userService.registerUser(userDto);
    }
}
