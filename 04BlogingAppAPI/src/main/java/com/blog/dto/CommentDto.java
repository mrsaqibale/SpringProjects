package com.blog.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.blog.models.Post;

import jakarta.validation.constraints.NotEmpty;

@Component
public class CommentDto {

	@NotEmpty
	 private String com_content;
	 
	 private Date com_date;
	 
	 private Post post ;
}
