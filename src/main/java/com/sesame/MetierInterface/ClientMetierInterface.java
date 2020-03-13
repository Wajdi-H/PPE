package com.sesame.MetierInterface;

import java.util.Collection;

import com.sesame.DAO.Client;

public interface ClientMetierInterface {
	public Collection<Client> getAll();
	public Client getId(Long id);
	public void delete(long id);
	public Client add (Client c );
}



