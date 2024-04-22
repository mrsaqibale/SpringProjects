package com.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class CommentCon {

	@PostMapping("/post/{postId}/comment")
	public RequestMapping<com> postMethodName(@RequestBody SomeEnityData entity) {
		//TODO: process POST request
		
		return entity;
	}
	
}
