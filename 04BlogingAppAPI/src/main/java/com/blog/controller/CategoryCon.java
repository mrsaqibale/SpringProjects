package com.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.CategoryDto;
import com.blog.services.CategoryServices;
import com.blog.servicesImp.CategoryServImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("auth/cat")
public class CategoryCon {

	@Autowired
	private CategoryServices categoryServices;
	
//	Create method
	@PostMapping("/")
	public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto entity) {
		CategoryDto res = this.categoryServices.createCategory(entity);
		System.out.print("hello");
		return new ResponseEntity<CategoryDto>(res,HttpStatus.CREATED);
	}
	
//	update method
	
//	get all method
	
//	get by id method
	
//	delete mehtod

}
