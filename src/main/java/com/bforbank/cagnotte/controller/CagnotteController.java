package com.bforbank.cagnotte.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bforbank.cagnotte.service.CagnotteService;

@RestController
@RequestMapping("/api/cagnotte")
public class CagnotteController {
	
	private CagnotteService cagnotteService;

	public CagnotteController(CagnotteService cagnotteService) {
		super();
		this.cagnotteService = cagnotteService;
	}
	
	@PostMapping("/add/{clientId}")
	private ResponseEntity<Void> addAmount(@PathVariable Long clientId, @RequestParam double amount) {
		cagnotteService.addAmountToCagnotte(clientId, amount);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/check/{clientId}")
	private ResponseEntity<Boolean> checkAvailability(@PathVariable Long clientId) {
		boolean isAvailable = cagnotteService.checkAvailabilityCagnotte(clientId);
		return ResponseEntity.ok(isAvailable);
	}
	

}
