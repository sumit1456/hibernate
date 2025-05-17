package com.exception;

public class InvalidIdException extends RuntimeException {

	public String getMessage() {
		return "Invalid id or Id does not exist";
	}
}
