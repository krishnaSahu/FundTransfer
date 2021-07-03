/**
 * 
 */
package com.at.fundTransfer.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.at.fundTransfer.entity.TransactionEntity;

/**
 * @author hackathon
 *
 */
class TransactionRepoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Autowired
	private TransactionRepo transactionRepository;

	@Test
	public void Isempty() {
		Iterable<TransactionEntity> transaction = transactionRepository.findAll();
		assertThat(transaction).isEmpty();
	}

}
