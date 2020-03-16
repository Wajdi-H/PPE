package com.sesame.Interface;

import java.util.Collection;

import com.sesame.DAO.CentreVisite;

public interface CentreMetierInterface {

	public Collection<CentreVisite> getAll();
	public CentreVisite getId(Long id);
	public void delete(long id);
	public CentreVisite add (CentreVisite chef );
}
