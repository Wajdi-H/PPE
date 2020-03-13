package com.example.Repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DAO.Client;

public interface ClientRepository  extends JpaRepository<Client, Long > {

	public List<Client> findByNomC(String nom);
	
	// pageable  : objet ou on va définit le taille d'une page
	public Page<Client> findByNomC(String nom, Pageable p );
	
	public List<Client> findByNomCContaining(String a);
	
	public List<Client> findByPrenomC(String prenom); 
	
	public List<Client> findByCINC(String cin); 
	
}
