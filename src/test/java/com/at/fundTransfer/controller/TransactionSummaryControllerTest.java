package com.at.fundTransfer.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import ch.qos.logback.classic.Logger;

class TransactionSummaryControllerTest {

	private final static Logger logger = (Logger) LoggerFactory.getLogger(TransactionSummaryControllerTest.class);

	@Autowired
	private MockMvc mvc;

	@BeforeTestClass
	public static void setUpBeforeClass() throws Exception {
		logger.info("Transaction Sunmmary Controller Unit Testing");
	}

	@Before
	public void setUp() throws Exception {
		logger.info("Transaction Sunmmary");
	}

	@Test
	public void getTransactionSummary() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/account").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.account").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.account[*].accountId").isNotEmpty());
	}

	@Test
	public void getTransactionByIdAPI() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/account/{accountId}", 1).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.accountId").value(1));
	}

}
