package com.at.fundTransfer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.at.fundTransfer.entity.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {

}
