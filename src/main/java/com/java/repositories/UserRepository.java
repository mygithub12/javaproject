package com.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findByName(String name);

}
