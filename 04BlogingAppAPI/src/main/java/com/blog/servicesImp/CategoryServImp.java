package com.blog.servicesImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.CategoryRepo;
import com.blog.dto.CategoryDto;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.models.Category;
import com.blog.services.CategoryServices;

@Service
public class CategoryServImp implements CategoryServices{

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public CategoryDto createCategory(CategoryDto entity) {
		Category cat = this.categoryRepo.save(this.modelMapper.map(entity, Category.class));
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto entity, Integer id) {
		Category res = this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException(id, "category", "id"));
		res.setCat_description(entity.getCat_description());
		res.setCat_title(entity.getCat_title());
		Category fres = this.categoryRepo.save(res);
		return this.modelMapper.map(fres, CategoryDto.class);
	}

	@Override
	public void DeleteCategory(Integer id) {
		this.categoryRepo.deleteById(id);
		
	}

	@Override
	public CategoryDto getCategoryById(Integer id) {
		Category res = this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException(id,"Category", "id"));
		return this.modelMapper.map(res, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		//List<Category>  res = this.categoryRepo.findAll();
		//List<CategoryDto> catDtos = res.stream().map(user->this.modelMapper.map(user, CategoryDto.class)).collect(Collectors.toList());
		return null;
	}

}
