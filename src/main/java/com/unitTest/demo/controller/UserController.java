package com.unitTest.demo.controller;

import com.unitTest.demo.dto.CreateUserRequest;
import com.unitTest.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<?> fetchAll() {
        return userService.fetchAllUsers();
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest createUserRequest) {
        return userService.createNewUser(createUserRequest);
    }
}
