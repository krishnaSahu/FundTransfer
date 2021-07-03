package com.at.fundTransfer.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.at.fundTransfer.dto.AccountDto;
import com.at.fundTransfer.service.AccountService;
import com.at.fundTransfer.utils.SessionUser;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/accounts")
	public ResponseEntity<List<AccountDto>> getCustomerDetails(HttpServletRequest request) {

		SessionUser sessionUser = SessionUser.getInstance();
		UUID customerId = (UUID) sessionUser.get("customerId");

		List<AccountDto> customerAccounts = accountService.getAccountListByCustomerId(customerId);

		return ResponseEntity.ok(customerAccounts);

	}

	@PostMapping("/accounts")
	public ResponseEntity<UUID> saveAccountDetails(@RequestBody AccountDto accountDto) {

		SessionUser sessionUser = SessionUser.getInstance();
		UUID customerId = (UUID) sessionUser.get("customerId");

		accountDto.setCustomerId(customerId);

		UUID accountId = accountService.saveAccount(accountDto);

		return ResponseEntity.ok(accountId);

	}
}
