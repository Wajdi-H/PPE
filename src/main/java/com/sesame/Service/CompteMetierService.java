package com.sesame.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sesame.DAO.Compte;
import com.sesame.Interface.CompteMetierInterface;
import com.sesame.Repository.CompteRepository;

@Service
public class CompteMetierService implements CompteMetierInterface {

	@Autowired
	private CompteRepository CR;

	@Override
	public Collection<Compte> getAll() {
		// TODO Auto-generated method stub
		return CR.findAll();
	}

	@Override
	public Compte getId(Long id) {
		// TODO Auto-generated method stub
		return CR.getOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		CR.deleteById(id);
	}

	@Override
	public Compte add(Compte c) {
		// TODO Auto-generated method stub
		return CR.save(c);
	}

}
