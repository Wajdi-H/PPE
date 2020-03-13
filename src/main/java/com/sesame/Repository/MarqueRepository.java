package com.sesame.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sesame.DAO.Client;
import com.sesame.DAO.Marque;



public interface MarqueRepository extends JpaRepository<Marque, Long >{
	
	
	public List<Marque> findByNom(String nom);
	
	// pageable  : objet ou on va définit le taille d'une page
	public Page<Marque> findByNom(String nom, Pageable p );
	
	public List<Marque> findByNomContaining(String a);
	
	public List<Marque> findByModele(String modele); 
	
	public List<Marque> findByGamme(String gamme); 
	

}
