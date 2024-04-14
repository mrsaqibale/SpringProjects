package com.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.UserDto;
import com.blog.models.User;
import com.blog.servicesImp.UserServImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/auth")
public class UserCon {

	@Autowired
	private UserServImp userServImp;
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto entity) {
//		register user
		System.out.print(entity.getEmail());
		UserDto user = userServImp.createUser(entity);
		return new ResponseEntity<UserDto>(user,HttpStatus.CREATED);
	}
	
//	update password 
	
//	update about 
	
//	delete user
	
	
}
	

