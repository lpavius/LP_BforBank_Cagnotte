package com.bforbank.cagnotte.service;

import org.springframework.stereotype.Service;

import com.bforbank.cagnotte.model.Cagnotte;
import com.bforbank.cagnotte.model.Client;
import com.bforbank.cagnotte.repository.CagnotteRepository;
import com.bforbank.cagnotte.repository.ClientRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CagnotteServiceImpl implements CagnotteService {
	
	private ClientRepository clientRepository;
	private CagnotteRepository cagnotteRepository;
	private ClientService clientService;
	

	public CagnotteServiceImpl(ClientRepository clientRepository, CagnotteRepository cagnotteRepository,
			ClientService clientService) {
		super();
		this.clientRepository = clientRepository;
		this.cagnotteRepository = cagnotteRepository;
		this.clientService = clientService;
	}

	@Override
	public void addAmountToCagnotte(Long clientId, Double amount) {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new EntityNotFoundException("Client No found"));
		
		Cagnotte cagnotte = client.getCagnotte();
		cagnotte.setAmount(cagnotte.getAmount() + amount);
		cagnotteRepository.save(cagnotte);

	}

	@Override
	public boolean checkAvailabilityCagnotte(Long clientId) {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new EntityNotFoundException("Client No found"));
		
		Cagnotte cagnotte = client.getCagnotte();
		return clientService.countCheckout(clientId) >= 3 && cagnotte.getAmount() >= 10.0;
	}

}
