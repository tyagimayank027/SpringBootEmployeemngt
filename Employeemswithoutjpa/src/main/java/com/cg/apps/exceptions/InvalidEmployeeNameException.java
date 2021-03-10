package com.cg.apps.exceptions;

public class InvalidEmployeeNameException extends RuntimeException{
	
	public InvalidEmployeeNameException(String msg) {
		super(msg);
	}

}
