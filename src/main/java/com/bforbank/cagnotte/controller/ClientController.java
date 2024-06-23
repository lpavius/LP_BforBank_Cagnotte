package com.bforbank.cagnotte.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bforbank.cagnotte.service.CagnotteService;
import com.bforbank.cagnotte.service.ClientService;

@RestController
@RequestMapping("/api/checkout")
public class ClientController {
	
	private ClientService clientService;
	private CagnotteService cagnotteService;
	
	public ClientController(ClientService clientService, CagnotteService cagnotteService) {
		super();
		this.clientService = clientService;
		this.cagnotteService = cagnotteService;
	}
	
	
	@PostMapping("/record/{clientId}")
	public ResponseEntity<Void> recordCheckout(@PathVariable Long clientId){
		clientService.checkoutClient(clientId);
		
		return ResponseEntity.ok().build();
		
	}
}
