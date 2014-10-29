package com.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String string);

	

}
