package com.crud.dao;

import org.springframework.data.repository.CrudRepository;

import com.crud.entity.student;

public interface studentRepo extends CrudRepository<student, Integer> {

}
