package com.unitTest.demo.service;

import com.unitTest.demo.dto.CreateUserRequest;
import com.unitTest.demo.entity.UserEntity;
import com.unitTest.demo.mapper.UserMapper;
import com.unitTest.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public ResponseEntity<?> fetchAllUsers() {

        List<UserEntity> users = userRepo.findAll();
        if (users.isEmpty()) ResponseEntity.ok("no user record");

        return ResponseEntity.ok(users);
    }

    public ResponseEntity<?> createNewUser(CreateUserRequest createUserRequest) {
        UserEntity newUser = userMapper.mapCreateUserRequestDtoToUserEntity(createUserRequest);
        userRepo.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("new user created");
    }
}
