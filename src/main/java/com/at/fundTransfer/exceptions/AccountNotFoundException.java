package com.at.fundTransfer.exceptions;

public class AccountNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException() {

		super("Account Not Found");
	}
}
