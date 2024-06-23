package com.bforbank.cagnotte.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = true)
	private String name;
	@Column(nullable = true)
	private Integer nbCheckout;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "client")
	private Cagnotte cagnotte;
	
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getNbCheckout() {
		return nbCheckout;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNbCheckout(Integer nbCheckout) {
		this.nbCheckout = nbCheckout;
	}
	public Cagnotte getCagnotte() {
		return cagnotte;
	}
	public void setCagnotte(Cagnotte cagnotte) {
		this.cagnotte = cagnotte;
	}
	@Override
	public String toString() {
		return "Client [id=" + id 
				+ ", name=" + name 
				+ ", nbCheckout=" + nbCheckout 
				+ ", cagnotte=" + cagnotte + "]";
	}
	
	
	
	
}
