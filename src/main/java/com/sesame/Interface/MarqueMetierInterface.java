package com.sesame.Interface;

import java.util.Collection;

import com.sesame.DAO.Marque;

public interface MarqueMetierInterface {
	public Collection<Marque> getAll();
	public Marque getId(Long id);
	public void delete(long id);
	public Marque add (Marque M );
	public Marque getnom(String name);
	
}
