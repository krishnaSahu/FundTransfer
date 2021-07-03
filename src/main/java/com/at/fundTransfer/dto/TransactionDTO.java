package com.at.fundTransfer.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

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

	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")
	public String getTransactioDescription() {
		return transactioDescription;
	}

	public void setTransactioDescription(String transactioDescription) {
		this.transactioDescription = transactioDescription;
	}

	@NotEmpty
	@Min(value = 0, message = "Amount must be equal or greater than 0")
	@Max(value = 10000000, message = "Amount must be equal or less than 10000000")
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

	@NotEmpty
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")
	public String getTransactionAccountNumber() {
		return transactionAccountNumber;
	}

	public void setTransactionAccountNumber(String transactionAccountNumber) {
		this.transactionAccountNumber = transactionAccountNumber;
	}

}
