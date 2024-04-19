package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.PostDto;
import com.blog.servicesImp.PostServImp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



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
	
	
	
}
