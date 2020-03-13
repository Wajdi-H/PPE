package com.sesame.Rest;

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

import com.sesame.DAO.Client;
import com.sesame.DAO.Vehicule;
import com.sesame.MetierInterface.ClientMetierInterface;
import com.sesame.MetierInterface.VehiculeMetierInterface;

@RestController
@RequestMapping("/Vehicule")
@CrossOrigin("*")
public class VehiculeRest {
	@Autowired
	private  VehiculeMetierInterface CF;
	
	
	@PostMapping("/add") 
	public void save(@RequestBody Vehicule vehicule)
	
	{	CF.add(vehicule);
	}
	
	@GetMapping("/get")
	public Collection<Vehicule> findALL()
	{
		return CF.getAll();
	}
	@GetMapping("/get/{id}")
	public Vehicule findById(@PathVariable Long id)
	{
		return CF.getId(id);
	}
	
	
	@DeleteMapping("/supprimer/{id}")
	public void supprimer(@PathVariable Long id) {
	
		CF.delete(id);
	}
	@PutMapping("edit/{id}")  // modification

	public void update(@PathVariable Long id , @RequestBody Vehicule vehicule)
	
	{
		vehicule.setIdV(id);
		CF.add(vehicule)	;
	}
	
}

