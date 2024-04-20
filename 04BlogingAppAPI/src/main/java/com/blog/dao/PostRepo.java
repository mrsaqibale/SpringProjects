package com.blog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.blog.dto.PostDto;
import com.blog.models.Post;
import com.blog.models.User;
import com.blog.models.Category;



@Component
public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	List<Post> findByPost_title(String post_title);
}
