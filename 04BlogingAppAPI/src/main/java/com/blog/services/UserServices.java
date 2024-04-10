package com.blog.services;

import java.util.List;

import com.blog.dto.UserDto;

public interface UserServices {

	UserDto createUser(UserDto user);
	
	
	UserDto updateUser(UserDto user, Integer userId);
	
	
	UserDto getUserById(Integer userId);
	
	
	List<UserDto>  getAllUsers();
	
	
	void deleteUser(int userId);
	
	
	void disableUser(int userId);

}
