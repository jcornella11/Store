package com.gcu.store.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.gcu.store.data.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    // Method for finding a user by their username
    UserEntity findByUserName(String userName);
}


