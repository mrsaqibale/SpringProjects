package com.blog.servicesImp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.dao.CommentRepo;
import com.blog.dao.PostRepo;
import com.blog.dto.CommentDto;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.models.Comment;
import com.blog.models.Post;
import com.blog.services.CommentServices;

public class CommentServImp implements CommentServices{

	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PostRepo postRepo;
	@Override
	public CommentDto createComment(CommentDto entity, Integer postId, Integer userId) {

		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException(postId, "post", "id"));

		Comment comment = this.modelMapper.map(entity, Comment.class);

		comment.setPost(post);

		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer comId) {

		Comment com = this.commentRepo.findById(comId).orElseThrow(() -> new ResourceNotFoundException(comId,"Comment", "Id" ));
		this.commentRepo.delete(com);
		
	}

}
