package com.at.fundTransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.at.fundTransfer.dto.CustomerDto;
import com.at.fundTransfer.service.CustomerService;
import com.at.fundTransfer.utils.CommonResponseUtil;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer")
	public ResponseEntity<Object> saveCustomer(@RequestBody CustomerDto cutomerDto) {

		customerService.saveCustomer(cutomerDto);

		return CommonResponseUtil.getSuccessResponse("CustomerUserName", cutomerDto.getCustomerName());

	}

	@GetMapping("/customer")
	public ResponseEntity<Object> getCustomerDetails(@RequestParam String userName) {

		CustomerDto customerDto = customerService.getCustomerDetials(userName);

		return CommonResponseUtil.getSuccessResponse("customerDetails", customerDto);

	}
}
