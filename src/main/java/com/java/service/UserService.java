package com.java.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.model.Role;
import com.java.model.UserEntity;
import com.java.repositories.RoleRepository;
import com.java.repositories.UserRepository;


@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRep;
	
	
	@Autowired
	private RoleRepository roleRep;
	
	public List<UserEntity> findAll(){
		
		return userRep.findAll();
	}

	public UserEntity findOne(int id) {
		
		
		return userRep.findOne(id);
	}

	public void save(UserEntity users) {
		users.setEnabled(true);
		List<Role> roles=new ArrayList<Role>();
		roles.add(roleRep.findByName("ROLE_USER"));
		users.setRoles(roles);
		userRep.save(users);
	}

	public UserEntity findByname(String name) {
		
		return userRep.findByName(name);
	}

	public void delete(int id) {
		
		
		
		userRep.delete(userRep.findOne(id));
		
	}
	


}
