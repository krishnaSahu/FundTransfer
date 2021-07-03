package com.at.fundTransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.at.fundTransfer.service.TransactionService;

@RestController
public class TransactionSummaryController {

	@Autowired
	private TransactionService transactionService;


}
