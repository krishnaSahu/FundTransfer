package com.at.fundTransfer.dto;

import java.util.Objects;

import org.springframework.lang.NonNull;

import com.sun.istack.NotNull;

public class TransactionRequestDTO {

	@NonNull
	private String fromAccountId;

	@NotNull
	private String toAccountId;

	@NonNull
	private Double amount;

	@NotNull
	private String transactioType;

	private String description;

	public String getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public String getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTransactioType() {
		return transactioType;
	}

	public void setTransactioType(String transactioType) {
		this.transactioType = transactioType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, description, fromAccountId, toAccountId, transactioType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		TransactionRequestDTO other = (TransactionRequestDTO) obj;

		return Objects.equals(amount, other.amount) && Objects.equals(description, other.description)
				&& Objects.equals(fromAccountId, other.fromAccountId) && Objects.equals(toAccountId, other.toAccountId)
				&& Objects.equals(transactioType, other.transactioType);
	}

}
