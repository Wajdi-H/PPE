package com.sesame.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sesame.DAO.Marque;
import com.sesame.Interface.MarqueMetierInterface;
import com.sesame.Repository.MarqueRepository;

@Service
public class MarqueMetierService implements MarqueMetierInterface {

	@Autowired
	private MarqueRepository urc;


	@Override
	public Collection<Marque> getAll() {
		return urc.findAll();
	}

	@Override
	public Marque getId(Long id) {
		return urc.findById(id).get();
	}
	@Override
	public Marque getnom(String name)
	{
		return urc.findByNom(name);
	}


	@Override
	public void delete(long id) {
		urc.deleteById(id);
	}

	@Override
	public Marque add(Marque M) {
		return urc.save(M);
	}
}
