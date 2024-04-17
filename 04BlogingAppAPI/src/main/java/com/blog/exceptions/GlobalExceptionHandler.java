package com.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	private ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	
	//exception for validations
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> dtoNotValidException(MethodArgumentNotValidException ex){
		Map<String, String> result = new HashMap<>();
		BindingResult br = ex.getBindingResult();
		
		for( FieldError fieldError : br.getFieldErrors()) {
			String fieldName = fieldError.getField();
			String message = fieldError.getDefaultMessage();
			result.put(fieldName, message);
		}
		return new ResponseEntity<Map<String,String>>(result,HttpStatus.BAD_REQUEST);
	}
}
