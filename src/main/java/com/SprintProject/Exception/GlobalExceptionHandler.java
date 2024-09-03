package com.SprintProject.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import jakarta.validation.constraints.NotNull;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception e){
		ErrorResponse er=new ErrorResponse();
		er.setMessage("validation failed");
		er.setTimestamp(LocalDate.now());
		System.out.println(er);
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException e){
		ErrorResponse er=new ErrorResponse();
		er.setMessage(e.getMessage());
		er.setTimestamp(LocalDate.now());
		System.out.println(er);
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(OfficeNotFoundException e){
		ErrorResponse er=new ErrorResponse();
		er.setMessage(e.getMessage());
		er.setTimestamp(LocalDate.now());
		System.out.println(er);
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(CustomerNotFoundByCityException e){
		ErrorResponse er=new ErrorResponse();
		er.setMessage(e.getMessage());
		er.setTimestamp(LocalDate.now());
		System.out.println(er);
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(CustomerAlreadyExistsException e){
		ErrorResponse er=new ErrorResponse();
		er.setMessage(e.getMessage());
		er.setTimestamp(LocalDate.now());
		System.out.println(er);
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	}
	
}
