package com.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.dto.CategoryDto;

@Service
public interface CategoryServices {

//	create Category
	CategoryDto createCategory(CategoryDto entity);

	
	//	update Category
	CategoryDto updateCategory(CategoryDto entity, Integer id);
	
	
//	Delete Category
	void DeleteCategory( Integer id);
	
	
//	Get by id Category
	CategoryDto getCategoryById( Integer id);
	
	
//	Get All Categorys
	List<CategoryDto> getAllCategories();
	
}
