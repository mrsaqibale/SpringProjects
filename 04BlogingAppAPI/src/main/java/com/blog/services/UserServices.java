package com.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.dto.UserDto;
import com.blog.models.User;

@Service
public interface UserServices {

	UserDto createUser(UserDto user);
	
	
	UserDto updateAbout(UserDto user, Integer userId);
	
	
	UserDto updatePassword(UserDto user, Integer userId);
	
	
	UserDto updateStatus(UserDto user , Integer userId);
	
	
	UserDto getUserById(Integer userId);
	
	
	List<User>  getAllUsers();
	
	
	void deleteUser(int userId);
	
	
	void disableUser(int userId);

}
