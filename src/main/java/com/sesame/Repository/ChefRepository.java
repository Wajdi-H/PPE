package com.sesame.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sesame.DAO.ChefCouloir;


public interface ChefRepository extends JpaRepository<ChefCouloir, Long > {

	public List<ChefCouloir> findByNomChef(String nom);
	
	// pageable  : objet ou on va définit le taille d'une page
	public Page<ChefCouloir> findByNomChef(String nom, Pageable p );
	
	public List<ChefCouloir> findByNomChefContaining(String a);
	
	public List<ChefCouloir> findByPrenomChef(String prenom); 
	
	
	

}
