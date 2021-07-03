package com.at.fundTransfer.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.at.fundTransfer.dao.CustomerRepo;
import com.at.fundTransfer.dto.CustomerDto;
import com.at.fundTransfer.entity.CustomerEntity;
import com.at.fundTransfer.service.CustomerService;
import com.at.fundTransfer.utils.CommonResponseUtil;
import com.at.fundTransfer.utils.ObjectMapperUtils;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Transactional
	@Override
	public ResponseEntity<Object> saveCustomer(CustomerDto customerDto) {

		CustomerEntity customerEntity = ObjectMapperUtils.map(customerDto, CustomerEntity.class);

		customerEntity = customerRepo.save(customerEntity);

		return CommonResponseUtil.getSuccessResponse("customerId", customerEntity.getCustomerId(), "");
	}

}
