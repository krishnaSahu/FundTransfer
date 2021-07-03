package com.at.fundTransfer.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.at.fundTransfer.controller.TransactionController;
import com.at.fundTransfer.dao.AccountRepo;
import com.at.fundTransfer.dao.TransactionRepo;
import com.at.fundTransfer.dto.TransactionRequestDTO;
import com.at.fundTransfer.entity.AccounEntity;
import com.at.fundTransfer.entity.TransactionEntity;
import com.at.fundTransfer.exceptions.InvalidAmountException;
import com.at.fundTransfer.exceptions.UserNotAuthorizedException;
import com.at.fundTransfer.service.TransactionService;
import com.at.fundTransfer.utils.CommonResponseUtil;

import ch.qos.logback.classic.Logger;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepo transactionRepo;

	@Autowired
	private AccountRepo accountRepo;

	Logger logger = (Logger) LoggerFactory.getLogger(TransactionController.class);

	@Override
	@Transactional
	public TransactionEntity saveTransaction(TransactionRequestDTO newTransaction) {
		TransactionEntity transactionData = null;

		Optional<AccounEntity> accounEntityOptional;
		AccounEntity accountEntity;

		try {

			if (validateTransactionDTO(newTransaction)) {

				transactionData = transactionRepo.save(getTransactionObject(newTransaction));

				accounEntityOptional = Optional.of(accountRepo.findByAccountNumber(newTransaction.getFromAccountId()));
				accountEntity = accounEntityOptional.get();
				accountEntity.setAvailableBalance(transactionData.getCurrBalance());

				accountRepo.save(accountEntity);
			}

		} catch (UserNotAuthorizedException ue) {
			logger.warn("User is not found for :" + newTransaction.getToken() + ue.getCause());
			throw new UserNotAuthorizedException();
		} catch (InvalidAmountException ie) {
			logger.warn("Invalid amount" + newTransaction.getAmount() + ie.getCause());
			throw new InvalidAmountException(newTransaction.getAmount());
		}
		return transactionData;
	}

	private TransactionEntity getTransactionObject(TransactionRequestDTO newTransaction) {

		TransactionEntity transactionEntity = new TransactionEntity();

		// transactionEntity.setAccountId(newTransaction.getFromAccountId());

		transactionEntity.setTransactionAccountNumber(newTransaction.getToAccountId());
		transactionEntity.setTransactionAmount(newTransaction.getAmount());
		transactionEntity.setTransactionDate(new Date());
		transactionEntity.setTransactionDescription(newTransaction.getDescription());
		transactionEntity.setTransactionType(newTransaction.getTransactioType());

		if (newTransaction.getTransactioType().equals("C")) {
			transactionEntity.setCurrBalance(
					getAvailableBalance(newTransaction.getFromAccountId()) + newTransaction.getAmount());
		} else {
			transactionEntity.setCurrBalance(
					getAvailableBalance(newTransaction.getFromAccountId()) - newTransaction.getAmount());
		}
		return transactionEntity;
	}

	private Double getAvailableBalance(String fromAccNumber) {
		return (accountRepo.findByAccountNumber(fromAccNumber)).getAvailableBalance();
	}

	private boolean validateTransactionDTO(TransactionRequestDTO newTransaction) {
		boolean isValid = false;

		if (accountsAreValid(newTransaction.getFromAccountId(), newTransaction.getToAccountId())) {

			if (newTransaction != null && newTransaction.getFromAccountId() != null
					&& newTransaction.getToAccountId() != null && newTransaction.getAmount() != null) {

				if (newTransaction.getTransactioType().equals("debit")
						&& getAvailableBalance(newTransaction.getFromAccountId()) > newTransaction.getAmount()) {
					isValid = true;

				} else if (newTransaction.getTransactioType().equals("credit")) {

					if (newTransaction.getAmount() > 0) {
						isValid = true;
					}
				}
			}
		}
		return isValid;
	}

	private boolean accountsAreValid(String fromAcc, String toAcc) {
		boolean areActive = false;

		if ((accountRepo.findByAccountNumber(fromAcc)).getActive()
				&& (accountRepo.findByAccountNumber(fromAcc)).getActive()) {

			areActive = true;
		}
		return areActive;
	}

	@Override
	public ResponseEntity<Object> getTransactionSummary(Long accountId) {

		List<TransactionEntity> transactionList = transactionRepo.findTransactionByAcountId(accountId);

		return CommonResponseUtil.getSuccessResponse("transactionSummary", transactionList);
	}

}
