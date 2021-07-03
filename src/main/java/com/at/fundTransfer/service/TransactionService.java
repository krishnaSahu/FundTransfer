package com.at.fundTransfer.service;

import org.springframework.http.ResponseEntity;

import com.at.fundTransfer.dto.TransactionRequestDTO;
import com.at.fundTransfer.entity.TransactionEntity;

public interface TransactionService {

	TransactionEntity saveTransaction(TransactionRequestDTO newTransaction);

	ResponseEntity<Object> getTransactionSummary(Long accountId);
}
