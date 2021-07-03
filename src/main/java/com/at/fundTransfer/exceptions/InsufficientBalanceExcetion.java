package com.at.fundTransfer.exceptions;

public class InsufficientBalanceExcetion extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientBalanceExcetion() {

		super("Insufficient Amount");
	}
}
