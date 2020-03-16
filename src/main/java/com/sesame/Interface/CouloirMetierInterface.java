package com.sesame.Interface;

import java.util.Collection;

import com.sesame.DAO.Couloir;


public interface CouloirMetierInterface {

	public Collection<Couloir> getAll();
	public Couloir getId(Long id);
	public void delete(long id);
	public Couloir add (Couloir c);
	
	
	
}
