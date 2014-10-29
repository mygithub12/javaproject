package com.java.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.repositories.UserRepository;

public class UniqueUsernamevalidator implements ConstraintValidator<UniqueUsername, String>{
	
	@Autowired
	private UserRepository userRep;

	public void initialize(UniqueUsername constraintAnnotation) {
		
		
	}


	public boolean isValid(String value, ConstraintValidatorContext context) {
	
		if(userRep==null){
			return true;
		}
		return userRep.findByName(value)==null;
	}

}
