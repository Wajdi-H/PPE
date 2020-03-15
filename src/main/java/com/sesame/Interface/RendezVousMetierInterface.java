package com.sesame.Interface;

import java.util.Collection;

import com.sesame.DAO.RendezVous;
import com.sesame.DAO.Vehicule;



public interface RendezVousMetierInterface {

	public Collection<RendezVous> getAll() ; 
	public RendezVous getId(Long id) ; 
	public void Delete(Long id) ; 
	public RendezVous Add(RendezVous rdv);
	
	
}
