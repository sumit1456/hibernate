package com.exception;

public class EmptyListException extends RuntimeException {

	public String getMessage() {
		return "The List is empty";
	}
}
