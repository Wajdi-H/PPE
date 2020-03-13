package com.sesame.MetierInterface;

import java.util.Collection;


import com.sesame.DAO.Compte;

public interface CompteMetierInterface {
	public Collection<Compte> getAll();
	public Compte getId(Long id);
	public void delete(long id);
	public Compte add (Compte c );

}
