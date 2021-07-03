package com.at.fundTransfer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import com.at.fundTransfer.dto.CustomerDto;

public interface CustomerService {

	ResponseEntity<Object> authenticateUser(String userName, String password);

	UserDetails loadUserByUsername(String username);

	void saveCustomer(CustomerDto cutomerDto);

	CustomerDto getCustomerDetials(String userName);

}
