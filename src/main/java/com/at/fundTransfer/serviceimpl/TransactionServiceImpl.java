package com.at.fundTransfer.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.at.fundTransfer.dao.TransactionRepo;
import com.at.fundTransfer.service.TransactionService;
import com.at.fundTransfer.utils.CommonResponseUtil;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepo transactionRepo;

	@Override
	public ResponseEntity<Object> getTransactionSummary(Long customerId, String startDateStr, String endDateStr) {

		return CommonResponseUtil.getSuccessResponse("transactionSummary", null, "");
	}

}
