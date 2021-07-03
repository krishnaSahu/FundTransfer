package com.at.fundTransfer.serviceimpl;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.at.fundTransfer.dao.CustomerRepo;
import com.at.fundTransfer.dto.CustomerDto;
import com.at.fundTransfer.entity.CustomerEntity;
import com.at.fundTransfer.exceptions.UserNotFoundException;
import com.at.fundTransfer.service.CustomerService;
import com.at.fundTransfer.utils.CommonResponseUtil;
import com.at.fundTransfer.utils.ObjectMapperUtils;
import com.at.fundTransfer.utils.SessionUser;

@Service
public class CustomerServiceImpl implements CustomerService, UserDetailsService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public ResponseEntity<Object> authenticateUser(String userName, String password) {

		Optional<CustomerEntity> customerOptional = customerRepo.findByCustomerUserName(userName);

		if (!customerOptional.isPresent()) {
			throw new UserNotFoundException(userName);
		}

		SessionUser sessionUser = SessionUser.getInstance();

		long token = System.currentTimeMillis();

		sessionUser.put(String.valueOf(token), customerOptional.get().getCustomerId());

		return CommonResponseUtil.getSuccessResponse("token", token);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) {

		Optional<CustomerEntity> customerOptional = customerRepo.findByCustomerUserName(userName);

		if (!customerOptional.isPresent()) {
			throw new UserNotFoundException(userName);
		}

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		UserDetails userDetails = new User(customerOptional.get().getCustomerUserName(),
				customerOptional.get().getPassword(), grantedAuthorities);

		return userDetails;
	}

	@Override
	public void saveCustomer(CustomerDto cutomerDto) {

		CustomerEntity customerEntity = ObjectMapperUtils.map(cutomerDto, CustomerEntity.class);

		customerEntity.setPassword(passwordEncoder.encode(cutomerDto.getPassword()));

		customerEntity.setCreationDate(new Date());
		customerEntity.setActive(true);

		customerRepo.save(customerEntity);
	}

	@Override
	public CustomerDto getCustomerDetials(String userName) {

		Optional<CustomerEntity> customerOptional = customerRepo.findByCustomerUserName(userName);

		if (customerOptional.isPresent()) {
			return ObjectMapperUtils.map(customerOptional.get(), CustomerDto.class);
		}
		
		return null;
	}

}
