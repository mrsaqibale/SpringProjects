package com.blog.services;

import org.springframework.stereotype.Service;

import com.blog.dto.CommentDto;

@Service
public interface CommentServices {

//	create comment
	CommentDto createComment(CommentDto entity, Integer postId, Integer userId);
	
//	delete comment
	void deleteComment(Integer comId);
}
