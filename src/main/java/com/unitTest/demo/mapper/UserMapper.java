package com.unitTest.demo.mapper;


import com.unitTest.demo.dto.CreateUserRequest;
import com.unitTest.demo.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // create new user
    UserEntity mapCreateUserRequestDtoToUserEntity(CreateUserRequest createUserRequest);

}
