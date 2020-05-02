package com.sesame.Rest;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sesame.DAO.Centre_Visite;
import com.sesame.DAO.couloir;
import com.sesame.MetierService.Centre_visiteMetierInterface;
import com.sesame.MetierService.coulirMetierInterface;

public class couloirRest {

	@Autowired(required = false)
	private coulirMetierInterface COF;
	@Autowired 
	private Centre_visiteMetierInterface CF;

	@PostMapping("/add/{idcentre}")
	public couloir save(@RequestBody couloir couloir, @PathVariable Long  id) {
		if (couloir != null) {
			Centre_Visite cv = new Centre_Visite();
			cv=CF.getId(id);
			couloir.setCentre_Visite(cv);
			return COF.add(couloir);
		}
		return null;
	}

	@GetMapping("/get")
	public Collection<couloir> findALL() {
		return COF.getAll();
	}

	@GetMapping("/get/{id}")
	public couloir findById(@PathVariable Long id) {
		return COF.getId(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCouloir(@PathVariable(value = "id") Long Id) {

		couloir couloir = COF.getId(Id);

		COF.delete(couloir.getNumero_Couloir());

		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public couloir updateCompte(@PathVariable(value = "id") Long Id, @Valid @RequestBody couloir couloirDetails) {

		couloir couloir = COF.getId(Id);

		couloir.setChef_couloir(couloirDetails.getChef_couloir());
		couloir.setCentre_Visite(couloirDetails.getCentre_Visite());

		couloir updatedcouloir = COF.add(couloir);
		return updatedcouloir;
	}
}