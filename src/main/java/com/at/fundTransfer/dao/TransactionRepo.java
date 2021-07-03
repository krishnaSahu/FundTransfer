package com.at.fundTransfer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.at.fundTransfer.entity.TransactionEntity;

public interface TransactionRepo extends JpaRepository<TransactionEntity, Long> {

}
