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
	 
	
	@Column(name = "content" , length = 500)
	 private String com_content;
	 
	
	@Column(name = "date")
	 private Date com_date;
	 
	@ManyToOne
	 private Post post ;
	 
	@ManyToOne
	 private User user;
	 
	
}
