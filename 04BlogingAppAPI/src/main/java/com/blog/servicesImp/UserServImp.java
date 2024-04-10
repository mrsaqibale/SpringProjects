package com.blog.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.dao.UserRepo;
import com.blog.dto.UserDto;
import com.blog.models.User;
import com.blog.services.UserServices;

public class UserServImp implements UserServices {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDto createUser(UserDto user) {
		User fuser 
		return null;
	}

	@Override
	public UserDto updateUser(UserDto user, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void disableUser(int userId) {
		// TODO Auto-generated method stub

	}
	
	
//	Convert Dto to entity model class
	private User dtoToUser(UserDto userDto) {
		User user = null ;
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setStatus(userDto.getStatus());
		user.setUsername(userDto.getUsername());
		return user;
	}
//	convert entity to dto 
	private UserDto userToDto(User user) {
		UserDto udto = null;
		udto.setAbout(user.getAbout());
		udto.setEmail(user.getEmail());
		udto.setId(user.getId());
		udto.setName(user.getName());
		udto.setPassword(user.getPassword());
		udto.setStatus(user.getStatus());
		udto.setUsername(user.getUsername());
		return udto;
	}

}











