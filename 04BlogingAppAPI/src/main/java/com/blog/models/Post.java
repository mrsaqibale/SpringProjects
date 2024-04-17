package com.blog.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(int post_id, String post_title, String post_content, Date post_added_date, String post_image,
			Category category, User user) {
		super();
		this.post_id = post_id;
		this.post_title = post_title;
		this.post_content = post_content;
		this.post_added_date = post_added_date;
		this.post_image = post_image;
		this.category = category;
		this.user = user;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int post_id;
	
	@Column(name = "title" , length = 300)
	private String post_title;
	
	@Column(name = "content" , length = 10000)
	private String post_content;
	
	@Column(name = "added" )
	private Date post_added_date;
	
	@Column(name = "image" , length = 500)
	private String post_image;
	
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;
}
