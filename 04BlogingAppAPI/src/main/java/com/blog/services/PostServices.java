package com.blog.services;

import java.util.List;

import com.blog.dto.PostDto;
import com.blog.models.Category;
import com.blog.models.Post;
import com.blog.models.User;

public interface PostServices {

//	Create post
	PostDto createPost(PostDto entity, int userId, int categoryId);
	
//	update post
	PostDto updatePost(PostDto entity, int postId);
	
//	get post by user and post

	
//	Get all posts
	List<PostDto> getAllPosts();
	
	
//	Delete post
	void deletePost(Integer id);
	
// get post by user id
	List<PostDto> getPostByUser(Integer id);
	
//	get post by category id
	List<PostDto> getPostByCategory(Integer id);
	
//	search by title 
	List<Post> searchByTitle(String title);
	
}
