package com.SprintProject.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.management.RuntimeErrorException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class CustomerNotFoundByCityException extends RuntimeException {

	public CustomerNotFoundByCityException(String message) {
		super(message);
	}
}
