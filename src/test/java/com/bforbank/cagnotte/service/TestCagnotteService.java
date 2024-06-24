package com.bforbank.cagnotte.service;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bforbank.cagnotte.model.Cagnotte;
import com.bforbank.cagnotte.model.Client;
import com.bforbank.cagnotte.repository.CagnotteRepository;
import com.bforbank.cagnotte.repository.ClientRepository;

@ExtendWith(MockitoExtension.class)
public class TestCagnotteService {
	
	@Mock
	private CagnotteRepository cagnotteRepository;
	
	@Mock
	private ClientRepository clientRepository;
	
	@Mock
	private ClientServiceImpl clientService;
	
	@InjectMocks
	private CagnotteServiceImpl cagnotteService;
	
	
	private Client client;
	private Cagnotte cagnotte;
	
	@BeforeEach
	private void setUp() {
		client = new Client();
		client.setId(1L);
		cagnotte = new Cagnotte();
		cagnotte.setAmount(0.0);
		client.setCagnotte(cagnotte);
	}
	
	@Test
	void testAddAmountCagnotte() {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        cagnotteService.addAmountToCagnotte(1L, 13.0);
        
        verify(cagnotteRepository, times(1)).save(cagnotte);
        assertEquals(13.0, cagnotte.getAmount());

	}
	
	@Test
	void testCheckAvailabilityCagnotte() {
		client.getCheckout().add(LocalDate.now());
		client.getCheckout().add(LocalDate.now());
		client.getCheckout().add(LocalDate.now());
		client.getCheckout().add(LocalDate.now());
		cagnotte.setAmount(15.0);
		
		when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
		when(clientService.countCheckout(1L)).thenReturn(4);
		
		boolean checkAvailable = cagnotteService.checkAvailabilityCagnotte(1L);
		assertTrue(checkAvailable);
	}

}
