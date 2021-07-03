package com.at.fundTransfer.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.at.fundTransfer.dto.TransactionRequestDTO;
import com.at.fundTransfer.service.TransactionService;

import ch.qos.logback.classic.Logger;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	Logger logger = (Logger) LoggerFactory.getLogger(TransactionController.class);

	@PostMapping("/transaction")
	public ResponseEntity<String> makeTransaction(@RequestBody TransactionRequestDTO newTransaction) {

		return ResponseEntity.ok(transactionService.saveTransaction(newTransaction).getTransactioNumber());
	}

}
