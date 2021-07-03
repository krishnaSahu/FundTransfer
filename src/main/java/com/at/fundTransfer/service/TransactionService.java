package com.at.fundTransfer.service;

import com.at.fundTransfer.dto.TransactionRequestDTO;
import com.at.fundTransfer.entity.TransactionEntity;

public interface TransactionService {

	TransactionEntity saveTransaction(TransactionRequestDTO newTransaction);
}
