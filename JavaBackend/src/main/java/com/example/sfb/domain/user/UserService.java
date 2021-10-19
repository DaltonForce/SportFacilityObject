package com.example.sfb.domain.user;

import com.example.sfb.api.user.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class UserService {

    private final UserDao userDao;
    private final UserMapper userMapper;

    @Secured("ROLE_ADMIN")
    public List<UserDto> getUsers() {
        Iterable<User> users = userDao.findAll();

        return StreamSupport.stream(users.spliterator(), false)
                .map(userMapper::mapToDto)
                .collect(toList());
    }

    @Secured("ROLE_ADMIN")
    @Transactional
    public void changeUserRole(String role, int userId) {
        User user = userDao.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with id " + userId + " has not been found!"));

        user.setRole(role);
        userDao.save(user);
    }

    @Transactional
    public void registerUser(UserDto userDto) {
        userDao.findByUsername(userDto.getUsername())
                .ifPresent(e -> {
                    throw new RuntimeException("User with name " + userDto.getUsername() + " already exists!");
                });

        User user = userMapper.mapToEntity(userDto);
        user.setRole("USER");
        userDao.save(user);
    }

    public UserDto getUser(String splitCred) {
        User user = userDao.findByUsername(splitCred)
                .orElseThrow(() -> {
                    throw new RuntimeException("User with name " + splitCred + " already exists!");
                });
        return userMapper.mapToDto(user);
    }
}
