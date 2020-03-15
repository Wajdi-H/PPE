package com.sesame.Service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sesame.DAO.Client;
import com.sesame.Interface.ClientMetierInterface;
import com.sesame.Repository.ClientRepository;



@Service
public class ClientMetierService implements ClientMetierInterface {

	@Autowired
	private ClientRepository URC;

	@Override
	public Collection<Client> getAll() {
		// TODO Auto-generated method stub
		return URC.findAll() ;
	}

	@Override
	public Client getId(Long id) {
		// TODO Auto-generated method stub
		return URC.getOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
	   URC.deleteById(id);	
	}

	@Override
	public Client add(Client c) {
		// TODO Auto-generated method stub
		return URC.save(c);
	}

	
	
	
}



