package com.at.fundTransfer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class AccounEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_acct_id", columnDefinition = "serial")
	private Long accountId;

	@Column(name = "a_cust_acctnum")
	private String accountNumber;

	@Column(name = "c_cust_custid")
	private Long customerId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_cust_custid", insertable = false, updatable = false, nullable = true)
	private CustomerEntity customerEntity;

	@Column(name = "a_acct_type")
	private String accountType;

	@Column(name = "a_acct_avail")
	private Double availableBalance;

	@Column(name = "b_acco_isactive")
	private Boolean active;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

}
