package com.at.fundTransfer.service;

import org.springframework.http.ResponseEntity;

import com.at.fundTransfer.dto.CustomerDto;

public interface CustomerService {

	ResponseEntity<Object> saveCustomer(CustomerDto customerDto);

}
