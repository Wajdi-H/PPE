package com.sesame.MetierService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sesame.DAO.Marque;
import com.sesame.MetierInterface.MarqueMetierInterface;
import com.sesame.Repository.MarqueRepository;

@Service
public class MarqueMetierService implements MarqueMetierInterface{

	@Autowired
	private MarqueRepository urc;
	@Transactional
	@Override
	public Collection<Marque> getAll(){
		return urc.findAll();
	}
	@Override
	public Marque getId(Long id) {
		return urc.findById(id).get();
	}
	@Override
	public void delete(long id) {
		urc.deleteById(id);
	}
	@Override
	public Marque add (Marque M ) {
		return urc.save(M);
	}
}

