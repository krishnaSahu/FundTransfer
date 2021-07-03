package com.at.fundTransfer.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.fundTransfer.dao.AccountRepo;
import com.at.fundTransfer.dto.AccountDto;
import com.at.fundTransfer.entity.AccounEntity;
import com.at.fundTransfer.service.AccountService;
import com.at.fundTransfer.utils.ObjectMapperUtils;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo accountRepo;

	public List<AccountDto> getAccountListByCustomerId(UUID customerId) {

		List<AccounEntity> accountList = accountRepo.getByCustomerId(customerId);

		return ObjectMapperUtils.mapAll(accountList, AccountDto.class);
	}

	@Override
	public UUID saveAccount(AccountDto accountDto) {

		AccounEntity entity = ObjectMapperUtils.map(accountDto, AccounEntity.class);

		entity.setActive(true);
		entity = accountRepo.save(entity);

		return entity.getAccountId();
	}
}
