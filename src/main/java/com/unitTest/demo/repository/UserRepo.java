package com.unitTest.demo.repository;

import com.unitTest.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserEntity findByFirstName(String firstName);
}
