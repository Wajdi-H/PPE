package com.sesame.Interface;

import java.util.Collection;

import com.sesame.DAO.ChefCouloir;


public interface ChefCouloirMetierInterface {

	
	public Collection<ChefCouloir> getAll();
	public ChefCouloir getId(Long id);
	public void delete(long id);
	public ChefCouloir add (ChefCouloir chef );
}
