package com.sesame.Interface;

import java.util.Collection;

import com.sesame.DAO.Adresse;

public interface AdresseMetierInterface {

	
	public Collection<Adresse> getAll();
	public Adresse getId(Long id);
	public void delete(long id);
	public Adresse add (Adresse adr );
	
}
