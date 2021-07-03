package com.at.fundTransfer.exceptions;

public class UserNotAuthorizedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotAuthorizedException() {

		super("User Not Authorized");
	}
}
