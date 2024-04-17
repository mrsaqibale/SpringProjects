package com.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.CategoryDto;
import com.blog.response.ApiResponse;
import com.blog.services.CategoryServices;
import com.blog.servicesImp.CategoryServImp;

import jakarta.validation.Valid;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth/cat")
public class CategoryCon {

	@Autowired
	private CategoryServImp categoryServImp;
	
//	Create method
	@PostMapping("/")
	public ResponseEntity<CategoryDto> create(@Valid @RequestBody CategoryDto entity) {
		CategoryDto res = this.categoryServImp.createCategory(entity);
		System.out.print("hello");
		return new ResponseEntity<CategoryDto>(res,HttpStatus.CREATED);
	}

	
//	update method
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto entity, @PathVariable Integer id){
		CategoryDto res = categoryServImp.updateCategory(entity, id);
		return ResponseEntity.ok(res);
	}
	
	
//	get all method
	
//	get by id method
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getById(@PathVariable Integer id){
		CategoryDto res = this.categoryServImp.getCategoryById(id);
		return ResponseEntity.ok(res);
	}
	
	
//	delete mehtod
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer id){
		this.categoryServImp.DeleteCategory(id);
		return new ResponseEntity(Map.of("message", "Deleted"),HttpStatus.OK);
	}
}
