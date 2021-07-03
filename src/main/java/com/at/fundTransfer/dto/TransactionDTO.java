package com.at.fundTransfer.dto;

/**
 * @author Krishna Sahu
 *
 */
public class TransactionDTO {

	private String transactioNumber;
	private String transactioDescription;
	private String transactionAccountNumber;
	private Double transactioAmount;
	private String transactioType;

	public String getTransactioNumber() {
		return transactioNumber;
	}

	public void setTransactioNumber(String transactioNumber) {
		this.transactioNumber = transactioNumber;
	}

	public String getTransactioDescription() {
		return transactioDescription;
	}

	public void setTransactioDescription(String transactioDescription) {
		this.transactioDescription = transactioDescription;
	}

	public Double getTransactioAmount() {
		return transactioAmount;
	}

	public void setTransactioAmount(Double transactioAmount) {
		this.transactioAmount = transactioAmount;
	}

	public String getTransactioType() {
		return transactioType;
	}

	public void setTransactioType(String transactioType) {
		this.transactioType = transactioType;
	}

	public String getTransactionAccountNumber() {
		return transactionAccountNumber;
	}

	public void setTransactionAccountNumber(String transactionAccountNumber) {
		this.transactionAccountNumber = transactionAccountNumber;
	}

}
