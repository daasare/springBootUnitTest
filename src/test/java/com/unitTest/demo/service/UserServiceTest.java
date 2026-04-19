package com.unitTest.demo.service;

import com.unitTest.demo.dto.CreateUserRequest;
import com.unitTest.demo.entity.UserEntity;
import com.unitTest.demo.mapper.UserMapper;
import com.unitTest.demo.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    // these are classes we need to inject into the class we wanna test
    @Mock
    private UserRepo userRepo;
    @Mock
    private UserMapper userMapper;

    // this is the class we wanna test it function
    @InjectMocks // this annotation inject the mock class needed by this class
    private UserService userService;

    private CreateUserRequest userRequest;
    private UserEntity user;

    @BeforeEach
    void setUp() {

    }

    @Nested
    @DisplayName("this class is sole for user creation")
    class CreateUserTest {
        @Test
        void createUserSuccessfully() {
            // given
            var request = new CreateUserRequest("Frank", "Books");
//            when(userMapper.mapCreateUserRequestDtoToUserEntity(request)).thenReturn(user);

            // when
            var result = userService.createNewUser(request);

            // then
            assertNotNull(result);
            assertEquals(HttpStatus.CREATED, result.getStatusCode());

            // confirm if userRepo.save() was actual called or done it work
            verify(userRepo).save(user);
            verify(userMapper).mapCreateUserRequestDtoToUserEntity(request);
        }
    }
}