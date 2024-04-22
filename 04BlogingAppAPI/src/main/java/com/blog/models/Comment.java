package com.blog.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	 private int com_id;
	 
	
	public int getCom_id() {
		return com_id;
	}

	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}

	public String getCom_content() {
		return com_content;
	}

	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}

	public Date getCom_date() {
		return com_date;
	}

	public void setCom_date(Date com_date) {
		this.com_date = com_date;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int com_id, String com_content, Date com_date, Post post, User user) {
		super();
		this.com_id = com_id;
		this.com_content = com_content;
		this.com_date = com_date;
		this.post = post;
		this.user = user;
	}

	@Column(name = "content" , length = 500)
	 private String com_content;
	 
	
	@Column(name = "date")
	 private Date com_date;
	 
	@ManyToOne
	 private Post post ;
	 
	@ManyToOne
	 private User user;
	 
	
}
