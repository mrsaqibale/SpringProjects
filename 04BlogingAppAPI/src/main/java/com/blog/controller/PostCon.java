package com.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.PostDto;
import com.blog.servicesImp.PostServImp;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/auth")
public class PostCon {

	@Autowired
	private PostServImp postServImp;

	
//	create post
	@PostMapping("/user/{userId}/cat/{catId}/post")
	public ResponseEntity<PostDto> postMethodName(@RequestBody PostDto entity,
			@PathVariable int userId,
			@PathVariable int catId)
	{
		PostDto postDto = this.postServImp.createPost(entity, userId, catId);
		return new ResponseEntity<PostDto>(postDto, HttpStatus.CREATED);
	}
	
//	update post
	@PutMapping("/post/{postId}")
	public ResponseEntity<PostDto> putMethodName(@PathVariable int postId, @RequestBody PostDto entity) {
		return  ResponseEntity.ok(this.postServImp.updatePost(entity, postId));
	}
	
	
//	get post by id
	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto> getMethodName(@PathVariable Integer postId) {
		return ResponseEntity.ok(this.postServImp.getPostById(postId));
	}
	
// get all posts
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> getAllPost() {
		return ResponseEntity.ok(this.postServImp.getAllPosts());
	}
	
	
//	get post by category id
	@GetMapping("/cat/{catId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCat(@PathVariable Integer catId) {
		return ResponseEntity.ok(this.postServImp.getPostByCategory(catId));
	}
	
	
	
//	get post by user id
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId) {
		return ResponseEntity.ok(this.postServImp.getPostByUser(userId));
	}

//	get post by search of title
	@GetMapping("/posts/search/{keys}")
	public ResponseEntity<List<PostDto>> getMethodName(@RequestParam String keys) {
//		List<PostDto> postdtos = this.postServImp.searchByTitle(keys);
//		return new ResponseEntity<List<PostDto>>(postdtos, HttpStatus.OK);
		return null;
	}
	
	
//	delete post
	@DeleteMapping("/post/{postId}")
	public ResponseEntity<?> deletePost(@PathVariable Integer postId){
		this.postServImp.deletePost(postId);
		return new ResponseEntity(Map.of("message" , "Deleted"), HttpStatus.OK);
	}
	
	
	
}
