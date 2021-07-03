package com.at.fundTransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.at.fundTransfer.service.TransactionService;

@RestController
public class TransactionSummaryController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/account/{accountId}")
	public ResponseEntity<Object> getTransactionSummary(
			@PathVariable(value = "accountId", required = true) Long accountId) {

		return transactionService.getTransactionSummary(accountId);
	}

}
