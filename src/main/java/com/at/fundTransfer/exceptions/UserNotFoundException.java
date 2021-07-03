package com.at.fundTransfer.exceptions;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String userName) {

		super(String.format("User with userName %d not found", userName));
	}
}
