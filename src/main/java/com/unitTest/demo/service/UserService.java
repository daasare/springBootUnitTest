package com.unitTest.demo.service;

import com.unitTest.demo.entity.UserEntity;
import com.unitTest.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public ResponseEntity<?> fetchAllUsers() {

        List<UserEntity> users = userRepo.findAll();
        if (users.isEmpty()) ResponseEntity.ok("no user record");

        return ResponseEntity.ok(users);
    }
}
