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

import com.sesame.DAO.Client;
import com.sesame.DAO.Marque;
import com.sesame.DAO.Vehicule;
import com.sesame.Interface.ClientMetierInterface;
import com.sesame.Interface.MarqueMetierInterface;
import com.sesame.Interface.VehiculeMetierInterface;

@RestController
@RequestMapping("/Vehicule")
@CrossOrigin("*")
public class VehiculeRest {
	
	
	
	@Autowired(required = false)
	private  VehiculeMetierInterface CF;
	@Autowired
	private MarqueMetierInterface MF ;
	@Autowired
	private ClientMetierInterface CFC;
	
	
	@PostMapping("/add/{idc}/{idm}") 
	public void save(@RequestBody Vehicule vehicule, @PathVariable long idc, @PathVariable long idm )
	
	{	Client c = new Client();
	   c=CFC.getId(idc);
	   vehicule.setClient(c);
		Marque m = new Marque();
	      m=MF.getId(idm);
	    vehicule.setMarque(m);
		CF.add(vehicule);
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

