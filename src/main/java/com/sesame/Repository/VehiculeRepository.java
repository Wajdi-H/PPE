package com.sesame.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sesame.DAO.Vehicule;



public interface VehiculeRepository extends JpaRepository<Vehicule, Long >{

public List<Vehicule> findByMatricule(String matricule);
	// pageable  : objet ou on va définit le taille d'une page
	public Page<Vehicule> findByMatricule(String matricule, Pageable p );
	
	public List<Vehicule> findByMatriculeContaining(String a);
	
	public List<Vehicule> findByTypeV(String type); 
	
	public List<Vehicule> findByDateSortie(Date date); 
	public List<Vehicule> findByAge(int age); 
	
	public List<Vehicule> findByKilometrage(String kilometrage); 
	public List<Vehicule> findByNbCylindre(int nb); 
	
	
	
	
}
