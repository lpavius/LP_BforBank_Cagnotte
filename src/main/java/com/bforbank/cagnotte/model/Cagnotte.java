package com.bforbank.cagnotte.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Cagnotte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private Double amount;
	
	@OneToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public Cagnotte() {
		super();
	}

	public Long getId() {
		return id;
	}

	public Double getAmount() {
		return amount;
	}

	public Client getClient() {
		return client;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Cagnotte [id=" + id 
				+ ", amount=" + amount 
				+ ", client=" + client + "]";
	}
	
	
	
}
