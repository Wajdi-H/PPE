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
import com.sesame.DAO.Compte;
import com.sesame.Interface.CompteMetierInterface;

@RestController
@RequestMapping("/compte")
@CrossOrigin("*")
public class CompteRest {

	@Autowired(required = false)
	private CompteMetierInterface CF;

	@PostMapping("/add")
	public Compte save(@RequestBody Compte compte) {
		if (compte != null) {
			return CF.add(compte);
		}
		return null;
	}

	@GetMapping("/get")
	public Collection<Compte> findALL() {
		return CF.getAll();
	}

	@GetMapping("/get/{id}")
	public Compte findById(@PathVariable Long id) {
		return CF.getId(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCompte(@PathVariable(value = "id") Long cptId) {

		Compte compte = CF.getId(cptId);

		CF.delete(compte.getId());

		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public Compte updateCompte(@PathVariable(value = "id") Long Id, @Valid @RequestBody Compte compteDetails) {

		Compte compte = CF.getId(Id);

		compte.setLogin(compteDetails.getLogin());
		compte.setMdp(compteDetails.getMdp());

		Compte updatedcompte = CF.add(compte);
		return updatedcompte;
	}

}