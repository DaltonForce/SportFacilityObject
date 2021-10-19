package com.example.sfb.api.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class UserDto {

    private int id;
    private String username;
    private String email;
    private String password;
    private int age;
    private String role;
}
