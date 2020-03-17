package com.sesame.Controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesame.DAO.Adresse;
import com.sesame.DAO.CentreVisite;
import com.sesame.DAO.Vehicule;
import com.sesame.Interface.AdresseMetierInterface;
import com.sesame.Interface.CentreMetierInterface;
import com.sesame.Interface.VehiculeMetierInterface;

@RestController
@RequestMapping("/centre")
@CrossOrigin("*")
public class CentreRest {
	@Autowired
	private  CentreMetierInterface CF;
	@Autowired
	private AdresseMetierInterface ADR;
	
	
	
	@PostMapping("/add/{idadresse}") 
	public void save(@RequestBody CentreVisite centreVisite,@PathVariable long id)
	
	{ Adresse ad = new Adresse();
	  ad=ADR.getId(id);
	  centreVisite.setAdresse(ad);
		CF.add(centreVisite);
	}
	
	@GetMapping("/get")
	public Collection<CentreVisite> findALL()
	{
		return CF.getAll();
	}
	@GetMapping("/get/{id}")
	public CentreVisite findById(@PathVariable Long id)
	{
		return CF.getId(id);
	}
	
	
	@DeleteMapping("/supprimer/{id}")
	public void supprimer(@PathVariable Long id) {
	
		CF.delete(id);
	}
	@PutMapping("edit/{id}")  // modification

	public void update(@PathVariable Long id , @RequestBody CentreVisite centreVisite)
	
	{
		centreVisite.setIdCentre(id);
		CF.add(centreVisite)	;
	}
	
}


