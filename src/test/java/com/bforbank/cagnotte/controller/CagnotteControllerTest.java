package com.bforbank.cagnotte.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bforbank.cagnotte.service.CagnotteServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CagnotteControllerTest {

	@Mock
	private CagnotteServiceImpl cagnotteService;
	
	@InjectMocks
	private CagnotteController cagnotteController;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	void SetUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(cagnotteController).build();
	}
	
	@Test
	void testAddAmount() throws Exception {
		mockMvc.perform(post("/api/cagnotte/add/1").param("amount", "10")).andExpect(status().isOk());
		
		verify(cagnotteService, times(1)).addAmountToCagnotte(1L, 10.0);
	}
	
	void testCheckAvailability() throws Exception {
		mockMvc.perform(post("/api/cagnotte/check/1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", is(true)));
		
		verify(cagnotteService, times(1)).checkAvailabilityCagnotte(1L);

	}
}
