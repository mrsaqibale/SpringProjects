package com.blog.servicesImp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.UserRepo;
import com.blog.dto.UserDto;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.models.User;
import com.blog.services.UserServices;

@Service
public class UserServImp implements UserServices {

	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		User fuser = null;
		fuser = dtoToUser(user);
		User res = userRepo.save(fuser);
		return userToDto(res);
	}

	@Override
	public UserDto updateAbout(UserDto user, Integer userId) {
		User fuser = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException(userId, "user", " id "));
		fuser.setAbout(user.getAbout());
		User res = userRepo.save(fuser);
		return userToDto(res);
	}
	
	
	@Override
	public UserDto updateStatus(UserDto user, Integer userId) {
		User fuser = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException(userId, "user", "id"));
		fuser.setStatus(user.getStatus());
		User res = userRepo.save(fuser);
		
		return userToDto(fuser);
	}
	
	
	@Override
	public UserDto updatePassword(UserDto user, Integer userId) {
		User fuser = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException(userId, "user", "id"));
		fuser.setPassword(user.getPassword());
		User res = userRepo.save(fuser);
		return userToDto(fuser);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User fuser = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException(userId, "user", "id"));
		return userToDto(fuser);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(int userId) {
		userRepo.deleteById(userId);
	}

	@Override
	public void disableUser(int userId) {
		User fuser = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException(userId, "user", "id"));
		fuser.setStatus(false);
		userRepo.save(fuser);
	}
	
	
//	Convert Dto to entity model class
	private User dtoToUser(UserDto userDto) {
		User user = new User() ;
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
		UserDto udto = new UserDto();
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











