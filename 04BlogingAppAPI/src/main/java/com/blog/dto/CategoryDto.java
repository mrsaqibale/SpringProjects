package com.blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryDto {

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryDto(int cat_id, String cat_title, String cat_description) {
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
	
	private int cat_id;
	@NotBlank
	@Size(min=4)
	private String cat_title;
	@NotBlank
	@Size(min=10)
	private String cat_description;
}
