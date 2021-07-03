package com.at.fundTransfer.exceptions;

public class InvalidAmountException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAmountException(Double amount) {

		super(String.format("Amount %d is not valid", amount));
	}
}
