package com.blog.servicesImp;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.CategoryRepo;
import com.blog.dao.PostRepo;
import com.blog.dao.UserRepo;
import com.blog.dto.PostDto;
import com.blog.dto.UserDto;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.models.Category;
import com.blog.models.Post;
import com.blog.models.User;
import com.blog.services.PostServices;

@Service
public class PostServImp implements PostServices {

	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private PostRepo postRepo;


	@Autowired
	private UserRepo userRepo;
	
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public PostDto createPost(PostDto entity, int userId, int categoryId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException(userId, "User", "id"));
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(categoryId, "Category","Id" ));
		
		entity.setCategory(cat);
		entity.setUser(user);
		entity.setPost_added_date(new Date());
		entity.setPost_image("default.image");
		Post post = this.modelMapper.map(entity, Post.class);
		Post result =  this.postRepo.save(post);
		return this.modelMapper.map(result, PostDto.class);
	}

// update post with id
	@Override
	public PostDto updatePost(PostDto entity, int postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException(postId, "Post", "id"));
		Post res = this.postRepo.save(this.modelMapper.map(entity, Post.class));
		Post fres = this.postRepo.save(res);
		return this.modelMapper.map(fres, PostDto.class);
	}

// get all posts and pagination concept apply
	@Override
	public List<PostDto> getAllPosts() {
		List<Post> posts = this.postRepo.findAll();
		List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

//  delete method
	@Override
	public void deletePost(Integer id) {
		this.postRepo.deleteById(id);		
	}

// get post by user id
	@Override
	public List<PostDto> getPostByUser(Integer id) {
		User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException(id, "User", "Id"));
		List<Post>  posts = this.postRepo.findByUser(user);
		List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}


//	get all post by categories
	@Override
	public List<PostDto> getPostByCategory(Integer id) {
		Category cat = this.categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(id, "Category", "Id"));
		List<Post> posts = this.postRepo.findByCategory(cat);
		List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}


	@Override
	public List<Post> searchByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
