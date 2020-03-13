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
import com.sesame.DAO.Compte;
import com.sesame.MetierInterface.ClientMetierInterface;
import com.sesame.MetierInterface.CompteMetierInterface;

@RestController
@RequestMapping("/Compte")
@CrossOrigin("*")
public class CompteRest {

	@Autowired
	private  CompteMetierInterface CF;
	
	
	@PostMapping("/add") 
	public void save(@RequestBody Compte compte)
	
	{	CF.add(compte);
	}
	
	@GetMapping("/get")
	public Collection<Compte> findALL()
	{
		return CF.getAll();
	}
	@GetMapping("/get/{id}")
	public Compte findById(@PathVariable Long id)
	{
		return CF.getId(id);
	}
	
	
	@DeleteMapping("/supprimer/{id}")
	public void supprimer(@PathVariable Long id) {
	
		CF.delete(id);
	}
	@PutMapping("edit/{id}")  // modification

	public void update(@PathVariable Long id , @RequestBody Compte compte)
	
	{
		compte.setId(id);
		CF.add(compte)	;
	}
	
}