package com.sesame.Service;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sesame.DAO.Adresse;
import com.sesame.Interface.AdresseMetierInterface;
import com.sesame.Repository.AdresseRepository;


@Service
public class AdresseMetierService implements AdresseMetierInterface{
	
	
	@Autowired
	private AdresseRepository AR; 

	@Override
	public Collection<Adresse> getAll() {
		// TODO Auto-generated method stub
		return AR.findAll();
	}

	@Override
	public Adresse getId(Long id) {
		// TODO Auto-generated method stub
		return AR.getOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		AR.deleteById(id);
		
	}

	@Override
	public Adresse add(Adresse adr) {
		// TODO Auto-generated method stub
		return AR.save(adr);
	}

}
