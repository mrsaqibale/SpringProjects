package com.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.blog.models.Category;

@Component
public interface CategoryRepo extends CrudRepository<Category, Integer> {

}
