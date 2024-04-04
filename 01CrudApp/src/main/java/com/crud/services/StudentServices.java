package com.crud.services;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.crud.dao.studentRepo;
import com.crud.entity.student;

@Component
public class StudentServices {
	
	@Autowired
	private studentRepo sr;
	
	//Get all the students
	public List<student> allStudents(){
		List<student> list = (List<student>)this.sr.findAll();
		return list;
	}
	
	//Get student with id
	public Optional<student> getStudentId(int id){
		Optional<student> std = null;
		try {
			std = this.sr.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return std;
	}
	
	//Add student with Post method
	public student addStudent(student std){
		student result;
		result = sr.save(std);
		 return result;
	}
	
	//Delete student data with id
	public void deleteStudent(int did) {
		sr.deleteById(did);
	}
	
	
	//Updata student data
	public student updataStudent(student std, int std_id) {
		std.setStd_id(std_id);
		sr.save(std);
		return std;
	}
}
