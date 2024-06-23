package com.bforbank.cagnotte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bforbank.cagnotte.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
