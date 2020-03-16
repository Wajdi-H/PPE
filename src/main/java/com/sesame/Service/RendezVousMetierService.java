package com.sesame.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sesame.DAO.RendezVous;
import com.sesame.Interface.RendezVousMetierInterface;
import com.sesame.Repository.RendezVousRepository;

@Service
public class RendezVousMetierService implements RendezVousMetierInterface {

	@Autowired
	private RendezVousRepository RR;

	@Override
	public Collection<RendezVous> getAll() {
		// TODO Auto-generated method stub
		return RR.findAll();
	}

	@Override
	public RendezVous getId(Long id) {
		// TODO Auto-generated method stub
		return RR.getOne(id);
	}

	@Override
	public void Delete(Long id) {
		// TODO Auto-generated method stub
		RR.deleteById(id);
	}

	@Override
	public RendezVous Add(RendezVous rdv) {
		// TODO Auto-generated method stub
		return RR.save(rdv);
	}

}
