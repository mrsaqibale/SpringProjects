package com.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.UserDto;
import com.blog.models.User;
import com.blog.servicesImp.UserServImp;

import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/auth/user")
public class UserCon {

	@Autowired
	private UserServImp userServImp;
	
//	create user or register
	@PostMapping("/")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto entity) {
		System.out.print(entity.getEmail());
		UserDto user = userServImp.createUser(entity);
		return new ResponseEntity<UserDto>(user,HttpStatus.CREATED);
	}
	
//	update password
	@PutMapping("/upass/{userId}")
	public ResponseEntity<UserDto> updatePassword(@RequestBody UserDto entity,@PathVariable Integer userId){
		return ResponseEntity.ok(this.userServImp.updatePassword(entity, userId));
	}
//	update user about
	@PutMapping("/uabout/{userId}")
	public ResponseEntity<UserDto> updateAbout(@RequestBody UserDto entity,@PathVariable Integer userId){
		return ResponseEntity.ok(this.userServImp.updateAbout(entity, userId));
	}	
//	update user status
	@PutMapping("/status/{userId}")
	public ResponseEntity<UserDto> updateStatus(@RequestBody UserDto entity,@PathVariable Integer userId){
		return ResponseEntity.ok(this.userServImp.updateStatus(entity, userId));
	}
//	get user by id
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> allUsersbyId(@PathVariable Integer userId) {
		return ResponseEntity.ok(this.userServImp.getUserById(userId));
	}
//	get all users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> allUsers() {
		return ResponseEntity.ok(this.userServImp.getAllUsers());
	}
	
	
//	delete user
	@DeleteMapping("{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
		this.userServImp.deleteUser(userId);
		return new ResponseEntity(Map.of("message", "Deleted"),HttpStatus.OK);
	}
	
	
}
	

