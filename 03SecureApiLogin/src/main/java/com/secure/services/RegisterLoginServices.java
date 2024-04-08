package com.secure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.secure.dao.RegisterLoginRepo;
import com.secure.models.User;

@Service
public class RegisterLoginServices  {

	@Autowired
	private RegisterLoginRepo rlRepo;
	
	//save the user with encripted password
	public User RegisterUser(User user) {
		User result = null;
		
		result = rlRepo.save(user);
		result = rlRepo.save(user);
	
		return result;
	}
}
