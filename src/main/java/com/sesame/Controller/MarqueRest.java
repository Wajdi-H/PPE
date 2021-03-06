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
import com.sesame.Interface.ClientMetierInterface;
import com.sesame.Interface.MarqueMetierInterface;

@RestController
@RequestMapping("/marque")
@CrossOrigin("*")
public class MarqueRest {
	
	
	@Autowired(required = false)
	private  MarqueMetierInterface CF;
	
	
	@PostMapping("/add") 
	public void save(@RequestBody Marque marque)
	
	{	CF.add(marque);
	}
	
	@GetMapping("/get")
	public Collection<Marque> findALL()
	{
		return CF.getAll();
	}
	@GetMapping("/get/{id}")
	public Marque findById(@PathVariable Long id)
	{
		return CF.getId(id);
	}
	
	
	@DeleteMapping("/supprimer/{id}")
	public void supprimer(@PathVariable Long id) {
	
		CF.delete(id);
	}
	@PutMapping("edit/{id}")  // modification

	public void update(@PathVariable Long id , @RequestBody Marque marque)
	
	{
		marque.setIdM(id);
		CF.add(marque)	;
	}
	
}

