package com.bforbank.cagnotte.service;

import com.bforbank.cagnotte.model.Client;
import com.bforbank.cagnotte.repository.CagnotteRepository;
import com.bforbank.cagnotte.repository.ClientRepository;

import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
	
	private ClientRepository clientRepository;
	private CagnotteRepository cagnotteRepository;

	public ClientServiceImpl(ClientRepository clientRepository, CagnotteRepository cagnotteRepository) {
		super();
		this.clientRepository = clientRepository;
		this.cagnotteRepository = cagnotteRepository;
	}



	@Override
	public void checkoutClient(Long clientId) {
		Client client = clientRepository.findById(clientId).orElseThrow(() 
				-> new EntityNotFoundException("Client not found"));
		LocalDate date = LocalDate.now();
		client.getCheckout().add(date);
		clientRepository.save(client);

	}

}
