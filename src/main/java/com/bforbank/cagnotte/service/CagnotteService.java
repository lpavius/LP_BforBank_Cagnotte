package com.bforbank.cagnotte.service;

public interface CagnotteService {
	
	public void addAmountToCagnotte(Long clientId, Double amount);
	public boolean checkAvailabilityCagnotte(Long clientId);

}
