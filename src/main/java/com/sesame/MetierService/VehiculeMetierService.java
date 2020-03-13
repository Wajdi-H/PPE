package com.sesame.MetierService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sesame.DAO.Vehicule;
import com.sesame.MetierInterface.VehiculeMetierInterface;
import com.sesame.Repository.VehiculeRepository;

@Service
public class VehiculeMetierService  implements VehiculeMetierInterface{


	@Autowired
	private VehiculeRepository urc;
	@Transactional
	@Override
	public Collection<Vehicule> getAll(){
		return urc.findAll();
	}
	@Override
	public Vehicule getId(Long id) {
		return urc.findById(id).get();
	}
	@Override
	public void delete(long id) {
		urc.deleteById(id);
	}
	@Override
	public Vehicule add (Vehicule V ) {
		return urc.save(V);
	}
}



