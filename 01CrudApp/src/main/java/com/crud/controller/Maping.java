package com.crud.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.student;
import com.crud.services.StudentServices;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class Maping {

	@Autowired
	private StudentServices studentServices;
	
	
	//Get all the Data
	@GetMapping("/students")
	public ResponseEntity<List<student>> students() {

		List<student> result = this.studentServices.allStudents();
		if(result.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(result));
	}
	
	
	
	//Get Student data by id
	@GetMapping("/student/{id}")
	public ResponseEntity<Optional<student>> studentById(@PathVariable("id") int id){
		Optional<student> result = this.studentServices.getStudentId(id);
		if(result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(result));
	}
	
	//Save student data by post method
	@PostMapping("/students")
	public student addStudent(@RequestBody student entity) {
		//TODO: process POST request
		try {
			this.studentServices.addStudent(entity);	
		}catch (Exception e) {
			// TODO: handle exception
		}
		return entity;
	}
	
	//Delete student data with id
	@DeleteMapping("/student/{id}")
	public void delStudent(@PathVariable("id") int id) {
		studentServices.deleteStudent(id);
	}
	
	//update student
	@PutMapping("/student/{id}")
	public student updateStudent(@RequestBody student std, @PathVariable("id") int id) {
		student result;
		result = studentServices.updataStudent(std, id);
		return result;
	}
	
	
	
}

