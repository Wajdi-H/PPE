package com.sesame.Controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesame.DAO.CentreVisite;
import com.sesame.DAO.Couloir;
import com.sesame.Interface.CentreMetierInterface;
import com.sesame.Interface.CouloirMetierInterface;

@RestController
@RequestMapping("/couloir")
@CrossOrigin("*")
public class CouloirRest {

	@Autowired(required = false)
	private CouloirMetierInterface COF;
	@Autowired 
	private CentreMetierInterface CF;

	@PostMapping("/add/{idcentre}")
	public Couloir save(@RequestBody Couloir couloir, @PathVariable Long  id) {
		if (couloir != null) {
			CentreVisite cv = new CentreVisite();
			cv=CF.getId(id);
			couloir.setCentre(cv);
			return COF.add(couloir);
		}
		return null;
	}

	@GetMapping("/get")
	public Collection<Couloir> findALL() {
		return COF.getAll();
	}

	@GetMapping("/get/{id}")
	public Couloir findById(@PathVariable Long id) {
		return COF.getId(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCouloir(@PathVariable(value = "id") Long Id) {

		Couloir couloir = COF.getId(Id);

		COF.delete(couloir.getId());

		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public Couloir updateCompte(@PathVariable(value = "id") Long Id, @Valid @RequestBody Couloir couloirDetails) {

		Couloir couloir = COF.getId(Id);

		couloir.setChefC(couloirDetails.getChefC());
		couloir.setCentre(couloirDetails.getCentre());

		Couloir updatedcouloir = COF.add(couloir);
		return updatedcouloir;
	}
}
