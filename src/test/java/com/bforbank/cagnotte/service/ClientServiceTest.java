package com.bforbank.cagnotte.service;

import java.util.Optional;
import java.time.LocalDate;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bforbank.cagnotte.model.Client;
import com.bforbank.cagnotte.repository.ClientRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
	
	@Mock
	private ClientRepository clientRepository;
	
	@InjectMocks
	private ClientServiceImpl clientService;
	
	private Client client;
	
	@BeforeEach
	public void setUp() {
		client = new Client();
		client.setId(1L);
		client.setCheckout(new ArrayList<>());
	}
	
	@Test
	public void testCheckoutClient() {
		when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
		
		clientService.checkoutClient(1L);
		
		verify(clientRepository, times(1)).save(client);
		assertEquals(1, client.getCheckout().size());
	}
	
	@Test
	public void testCountCheckout() {
		client.getCheckout().add(LocalDate.now());
		client.getCheckout().add(LocalDate.now());
		
		when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

		int count = clientService.countCheckout(1L);
		assertEquals(2,	count);
		
	}
	
}
