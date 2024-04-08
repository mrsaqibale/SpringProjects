package com.secure.dao;

import org.springframework.data.repository.CrudRepository;

import com.secure.models.User;

public interface RegisterLoginRepo extends CrudRepository<User, Integer>{
	
}
