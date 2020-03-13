package com.sesame.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sesame.DAO.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, Long >{
public List<Adresse> findByVille(String ville );
	// pageable  : objet ou on va définit le taille d'une page
	public Page<Adresse> findByVille(String ville, Pageable p );
	
	public List<Adresse> findByVilleContaining(String a);
	
	public List<Adresse> findByRegion(String region); 
	
	public List<Adresse> findByRue(String rue); 
	public List<Adresse> findByCodePostal(int code); 
	

}
