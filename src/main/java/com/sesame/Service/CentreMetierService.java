package com.sesame.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sesame.DAO.CentreVisite;
import com.sesame.Interface.CentreMetierInterface;
import com.sesame.Repository.CentreRepository;

@Service
public class CentreMetierService implements CentreMetierInterface{
	
	@Autowired
	private CentreRepository CR;

	@Override
	public Collection<CentreVisite> getAll() {
		// TODO Auto-generated method stub
		return CR.findAll();
	}

	@Override
	public CentreVisite getId(Long id) {
		// TODO Auto-generated method stub
		return CR.getOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		CR.deleteById(id);
	}

	@Override
	public CentreVisite add(CentreVisite chef) {
		// TODO Auto-generated method stub
		return CR.save(chef);
	} 
	
	
	

}
