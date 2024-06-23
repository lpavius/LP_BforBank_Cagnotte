package com.bforbank.cagnotte.service;

public interface ClientService {
	
	public void checkoutClient(Long clientId);
	
	public int countCheckout(Long clientId);

}
