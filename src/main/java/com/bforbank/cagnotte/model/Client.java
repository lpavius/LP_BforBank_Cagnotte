package com.bforbank.cagnotte.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = true)
	private String name;
	@Column(nullable = true)
	//private Integer nbCheckout;
	private List<LocalDate> checkout = new ArrayList<>();
	
	@OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
	private Cagnotte cagnotte;
	
	public Client() {
		super();
	}

	public Client(Long id, String name, List<LocalDate> checkout, Cagnotte cagnotte) {
		super();
		this.id = id;
		this.name = name;
		this.checkout = checkout;
		this.cagnotte = cagnotte;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<LocalDate> getCheckout() {
		return checkout;
	}

	public Cagnotte getCagnotte() {
		return cagnotte;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCheckout(List<LocalDate> checkout) {
		this.checkout = checkout;
	}

	public void setCagnotte(Cagnotte cagnotte) {
		this.cagnotte = cagnotte;
	}
	
}
