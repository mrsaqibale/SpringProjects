package com.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.blog.models.Post;

@Component
public interface PostRepo extends JpaRepository<Post, Integer>{

}
