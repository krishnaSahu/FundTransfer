package com.at.fundTransfer.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.at.fundTransfer.entity.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {

	Optional<CustomerEntity> findByCustomerUserName(String userName);
}
