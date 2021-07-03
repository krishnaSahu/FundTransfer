package com.at.fundTransfer.service;

import java.util.List;
import java.util.UUID;

import com.at.fundTransfer.dto.AccountDto;

public interface AccountService {

	List<AccountDto> getAccountListByCustomerId(UUID customerId);

	UUID saveAccount(AccountDto accountDto);

}
