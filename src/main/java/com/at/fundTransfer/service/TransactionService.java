package com.at.fundTransfer.service;

import org.springframework.http.ResponseEntity;

public interface TransactionService {

	ResponseEntity<Object> getTransactionSummary(Long customerId, String startDateStr, String endDateStr);

}
