package com.sesame.Service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sesame.DAO.ChefCouloir;
import com.sesame.Interface.ChefCouloirMetierInterface;
import com.sesame.Repository.ChefRepository;

@Service
public class ChefServiceMetier implements ChefCouloirMetierInterface {
	
	@Autowired
	private ChefRepository CR; 

	
	@Transactional
	@Override
	public Collection<ChefCouloir> getAll() {
		// TODO Auto-generated method stub
		return CR.findAll() ;
	}

	@Override
	public ChefCouloir getId(Long id) {
		// TODO Auto-generated method stub
		return CR.getOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		CR.deleteById(id);
	}

	@Override
	public ChefCouloir add(ChefCouloir chef) {
		// TODO Auto-generated method stub
		return CR.save(chef);
	}

}
