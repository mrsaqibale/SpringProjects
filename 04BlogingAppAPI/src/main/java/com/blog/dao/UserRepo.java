package com.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.blog.models.User;

@Component
public interface UserRepo extends JpaRepository<User, Integer>{

}
