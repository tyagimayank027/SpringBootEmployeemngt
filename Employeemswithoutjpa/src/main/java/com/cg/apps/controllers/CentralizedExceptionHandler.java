package com.cg.apps.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.cg.apps.exceptions.InvalidDepartmentException;
import com.cg.apps.exceptions.InvalidEmployeeNameException;
import com.cg.apps.exceptions.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public String handleEmployeeNotFound(EmployeeNotFoundException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidEmployeeNameException.class)
	public String handleInvalidEmployeeName(InvalidEmployeeNameException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidDepartmentException.class)
	public String handleInvalidDepartmentName(InvalidDepartmentException e) {
		return e.getMessage();
	}
}
