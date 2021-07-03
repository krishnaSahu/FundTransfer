package com.at.fundTransfer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.at.fundTransfer.entity.TransactionEntity;

public interface TransactionRepo extends JpaRepository<TransactionEntity, Long> {

	@Query("select t.transactionAccountNumber,t.transactionAmount,t.transactionDescription "
			+ "from TransactionEntity t inner join t.accountEntity acc "
			+ "where acc.accountId=:accountId and rownum<=10 order by transactionDate desc")
	List<TransactionEntity> findTransactionByAcountId(@Param("accountId") Long accountId);

}
