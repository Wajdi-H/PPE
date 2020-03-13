package com.sesame.MetierService;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sesame.DAO.Client;
import com.sesame.MetierInterface.ClientMetierInterface;
import com.sesame.Repository.ClientRepository;
@Service
public class ClientMetierService implements ClientMetierInterface {

	@Autowired
	private ClientRepository urc;
	@Transactional
	@Override
	public Collection<Client> getAll(){
		return urc.findAll();
	}
	@Override
	public Client getId(Long id) {
		return urc.findById(id).get();
	}
	@Override
	public void delete(long id) {
		urc.deleteById(id);
	}
	@Override
	public Client add (Client c ) {
		return urc.save(c);
	}
}



