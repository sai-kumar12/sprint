package com.SprintProject.Exception;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CustomerAlreadyExistsException extends RuntimeException{
  public CustomerAlreadyExistsException(String message) {
	  super(message);
  }
}
