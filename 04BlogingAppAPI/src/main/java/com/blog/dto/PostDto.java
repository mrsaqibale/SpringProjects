package com.blog.dto;

import java.util.Date;

import com.blog.models.Category;
import com.blog.models.User;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
public class PostDto {

	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostDto( String post_title, String post_content, Date post_added_date, String post_image,
			Category category, User user) {
		super();
		this.post_title = post_title;
		this.post_content = post_content;
		this.post_added_date = post_added_date;
		this.post_image = post_image;
		this.category = category;
		this.user = user;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public Date getPost_added_date() {
		return post_added_date;
	}
	public void setPost_added_date(Date post_added_date) {
		this.post_added_date = post_added_date;
	}
	public String getPost_image() {
		return post_image;
	}
	public void setPost_image(String post_image) {
		this.post_image = post_image;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@NotEmpty
	@Size(min = 4, message = "Title is greater then 4 charecters")
	private String post_title;
	private String post_content;
	private Date post_added_date;
	private String post_image;
	private Category category;
	private User user;
}
