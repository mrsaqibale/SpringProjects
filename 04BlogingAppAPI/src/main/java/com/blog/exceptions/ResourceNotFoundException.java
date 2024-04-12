package com.blog.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private int id ;
	private String first;
	private String second;
	public ResourceNotFoundException(int id, String first, String second) {
		super(String.format("%s not found with %s : %s",first, second, id));
		this.id = id;
		this.first = first;
		this.second = second;
	}
	
}
