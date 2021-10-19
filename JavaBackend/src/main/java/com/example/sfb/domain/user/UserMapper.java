package com.example.sfb.domain.user;

import com.example.sfb.api.user.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    UserDto mapToDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .age(user.getAge())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    User mapToEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .age(userDto.getAge())
                .email(userDto.getEmail())
                .role(userDto.getRole())
                .build();
    }
}
