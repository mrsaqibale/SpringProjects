package com.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class student {

	//define scheema
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int std_id;
	
	private String std_fname;
	
	private String std_lname;
	
	private String std_adder;
	
	private boolean std_status;
	
	
	//super constructor
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
// con. with parameter
	public student(int std_id, String std_fname, String std_lname, String std_adder, boolean std_status) {
		super();
		this.std_id = std_id;
		this.std_fname = std_fname;
		this.std_lname = std_lname;
		this.std_adder = std_adder;
		this.std_status = std_status;
	}

	
	//getter nd set functions
	public int getStd_id() {
		return std_id;
	}

	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}

	public String getStd_fname() {
		return std_fname;
	}

	public void setStd_fname(String std_fname) {
		this.std_fname = std_fname;
	}

	public String getStd_lname() {
		return std_lname;
	}

	public void setStd_lname(String std_lname) {
		this.std_lname = std_lname;
	}

	public String getStd_adder() {
		return std_adder;
	}

	public void setStd_adder(String std_adder) {
		this.std_adder = std_adder;
	}

	public boolean isStd_status() {
		return std_status;
	}

	public void setStd_status(boolean std_status) {
		this.std_status = std_status;
	}


	
}
