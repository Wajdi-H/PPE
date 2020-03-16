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
import com.sesame.DAO.Adresse;
import com.sesame.Interface.AdresseMetierInterface;

@RestController
@RequestMapping("/adresse")
@CrossOrigin("*")
public class AdresseRest {

	@Autowired(required = false)
	private AdresseMetierInterface AF;

	@PostMapping("/add")
	public Adresse save(@RequestBody Adresse adresse) {
		if (adresse != null) {
			return AF.add(adresse);
		}
		return null;
	}

	@GetMapping("/get")
	public Collection<Adresse> findALL() {
		return AF.getAll();
	}

	@GetMapping("/get/{id}")
	public Adresse findById(@PathVariable Long id) {
		return AF.getId(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAdresse(@PathVariable(value = "id") Long adrId) {
		Adresse adresse = AF.getId(adrId);

		AF.delete(adresse.getIdAdr());

		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public Adresse updateAdresse(@PathVariable(value = "id") Long Id, @Valid @RequestBody Adresse adresseDetails) {

		Adresse adresse = AF.getId(Id);

		adresse.setCodePostal(adresseDetails.getCodePostal());
		adresse.setRegion(adresseDetails.getRegion());
		adresse.setRue(adresseDetails.getRue());
		adresse.setVille(adresseDetails.getVille());

		Adresse updatedadresse = AF.add(adresse);
		return updatedadresse;
	}

}
