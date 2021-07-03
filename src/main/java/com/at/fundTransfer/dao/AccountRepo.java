package com.at.fundTransfer.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.at.fundTransfer.entity.AccounEntity;

public interface AccountRepo extends JpaRepository<AccounEntity, Long> {

	List<AccounEntity> getByCustomerId(UUID customerId);

	AccounEntity findByAccountNumber(String accountNumber);

}
