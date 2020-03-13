package com.sesame.MetierService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sesame.DAO.Compte;
import com.sesame.MetierInterface.CompteMetierInterface;
import com.sesame.Repository.CompteRepository;

@Service
public class CompteMetierService implements CompteMetierInterface {
	@Autowired
	private CompteRepository urc;
	@Transactional
	@Override
	public Collection<Compte> getAll(){
		return urc.findAll();
	}
	@Override
	public Compte getId(Long id) {
		return urc.findById(id).get();
	}
	@Override
	public void delete(long id) {
		urc.deleteById(id);
	}
	@Override
	public Compte add (Compte c ) {
		return urc.save(c);
	}

}
