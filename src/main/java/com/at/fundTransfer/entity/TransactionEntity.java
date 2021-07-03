package com.at.fundTransfer.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Krishna Sahu
 *
 */
@Entity
@Table(name = "transaction")
public class TransactionEntity {

	@Id
	@Column(name = "c_tran_id")
	private Long transactionId;

	@Column(name = "a_tran_num", nullable = false)
	private String transactioNumber;

	@Column(name = "c_acct_id", nullable = false)
	private UUID accountId;

	@Column(name = "a_tran_accountnum", nullable = false)
	private String transactionAccountNumber;

	@Column(name = "d_tran_date", nullable = false)
	private Date transactionDate;

	@Column(name = "e_tran_amount", nullable = false)
	private Double transactionAmount;

	@Column(name = "a_tran_type", nullable = false)
	private String transactionType;

	@Column(name = "a_tran_description", nullable = true)
	private String transactionDescription;

	@Column(name = "a_tran_currbal", nullable = true)
	private Double currBalance;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_acct_id", insertable = false, updatable = false, nullable = true)
	private AccounEntity accountEntity;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactioNumber() {
		return transactioNumber;
	}

	public void setTransactioNumber(String transactioNumber) {
		this.transactioNumber = transactioNumber;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public Double getCurrBalance() {
		return currBalance;
	}

	public void setCurrBalance(Double currBalance) {
		this.currBalance = currBalance;
	}

	public UUID getAccountId() {
		return accountId;
	}

	public void setAccountId(UUID accountId) {
		this.accountId = accountId;
	}

	public AccounEntity getAccountEntity() {
		return accountEntity;
	}

	public void setAccountEntity(AccounEntity accountEntity) {
		this.accountEntity = accountEntity;
	}

	public String getTransactionAccountNumber() {
		return transactionAccountNumber;
	}

	public void setTransactionAccountNumber(String transactionAccountNumber) {
		this.transactionAccountNumber = transactionAccountNumber;
	}

}
