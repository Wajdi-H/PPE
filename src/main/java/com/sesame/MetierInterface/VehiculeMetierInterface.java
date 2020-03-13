package com.sesame.MetierInterface;

import java.util.Collection;

import com.sesame.DAO.Vehicule;

public interface VehiculeMetierInterface {

	public Collection<Vehicule> getAll();
	public Vehicule getId(Long id);
	public void delete(long id);
	public Vehicule add (Vehicule V );
}
