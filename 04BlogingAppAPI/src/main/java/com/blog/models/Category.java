package com.blog.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int cat_id;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int cat_id, String cat_title, String cat_description) {
		super();
		this.cat_id = cat_id;
		this.cat_title = cat_title;
		this.cat_description = cat_description;
	}

	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_title() {
		return cat_title;
	}

	public void setCat_title(String cat_title) {
		this.cat_title = cat_title;
	}

	public String getCat_description() {
		return cat_description;
	}

	public void setCat_description(String cat_description) {
		this.cat_description = cat_description;
	}

	@Column(name = "title")
	private String cat_title;
	
	@Column(name = "description")
	private String cat_description;
	
	
	@OneToMany(mappedBy = "category" )
	private List<Post> post = new ArrayList();
}
