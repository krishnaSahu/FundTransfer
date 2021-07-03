/**
 * 
 */
package com.at.fundTransfer.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.at.fundTransfer.entity.TransactionEntity;

import ch.qos.logback.classic.Logger;

/**
 * @author hackathon
 *
 */
class TransactionRepoTest {

	private final static Logger logger = (Logger) LoggerFactory.getLogger(TransactionRepoTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.info("Transaction Sunmmary Controller Unit Testing");
	}

	@Before
	public void setUp() throws Exception {
		logger.info("Transaction Sunmmary");
	}

	@Autowired
	private TransactionRepo transactionRepository;

	@Test
	public void Isempty() {
		Iterable<TransactionEntity> transaction = transactionRepository.findAll();
		assertThat(transaction).isEmpty();
	}

}
