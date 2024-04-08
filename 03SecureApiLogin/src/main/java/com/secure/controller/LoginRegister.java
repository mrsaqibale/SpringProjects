package com.secure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.secure.models.User;
import com.secure.services.RegisterLoginServices;

@Controller
@RequestMapping("/auth")
public class LoginRegister {

	@Autowired
	private RegisterLoginServices rlServices;
	
	@PostMapping("/register")
	public String RegisterUser(@RequestBody User entity) {
		rlServices.RegisterUser(entity);
		return "hel";
	}
}
