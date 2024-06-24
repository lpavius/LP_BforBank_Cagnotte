package com.bforbank.cagnotte.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bforbank.cagnotte.service.ClientServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {
	
	@Mock
	private ClientServiceImpl clientService;

	@InjectMocks
	private ClientController clientController;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
	}
	
	@Test
	void testRecordCheckout() throws Exception {
		mockMvc.perform(post("/api/checkout/record/1")).andExpect(status().isOk());
		
		verify(clientService, times(1)).checkoutClient(1L);
	}
}
