package com.mktp.poc.arch.purchasesmktp;

import com.mktp.poc.arch.purchasesmktp.web.CustomerProductController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={
		ServiceUnitTestConfig.class})
class PurchasesMktpApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	@Qualifier("with_purchases")
	private CustomerProductController customerProductController;

	@Autowired
	@Qualifier("with_no_purchases")
	private CustomerProductController customerEmptyProductController;

	@Test
	void contextLoads() {
		mockMvc = MockMvcBuilders.standaloneSetup(customerProductController).build();

		assertThat(customerProductController).isNotNull();
	}

	@Test
	void responseWithPurchases() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(customerProductController).build();

		MvcResult mockResult = mockMvc.perform(get("/purchases"))
				.andExpect(status().isOk())
				.andReturn();

		assertThat(mockResult.getResponse().getContentAsString()).isNotEmpty();
	}

	@Test
	void responseWithNoPurchases() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(customerEmptyProductController).build();

		MvcResult mockResult = mockMvc.perform(get("/purchases"))
				.andReturn();

		assertEquals(204,mockResult.getResponse().getStatus());
		assertEquals("NO_PURCHASES_FOUND",mockResult.getResponse().getContentAsString());
	}

}
