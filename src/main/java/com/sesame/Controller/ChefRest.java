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
import com.sesame.DAO.ChefCouloir;
import com.sesame.Interface.AdresseMetierInterface;
import com.sesame.Interface.ChefCouloirMetierInterface;

@RestController
@RequestMapping("/chef")
@CrossOrigin("*")
public class ChefRest {

	@Autowired(required = false)
	private ChefCouloirMetierInterface CF;

	@PostMapping("/add")
	public ChefCouloir save(@RequestBody ChefCouloir chef) {
		if (chef != null) {
			return CF.add(chef);
		}
		return null;
	}

	@GetMapping("/get")
	public Collection<ChefCouloir> findALL() {
		return CF.getAll();
	}

	@GetMapping("/get/{id}")
	public ChefCouloir findById(@PathVariable Long id) {
		return CF.getId(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteChef(@PathVariable(value = "id") Long chefId) {
		ChefCouloir chef = CF.getId(chefId);

		CF.delete(chef.getIdChef());

		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public ChefCouloir updateAdresse(@PathVariable(value = "id") Long Id, @Valid @RequestBody ChefCouloir chefDetails) {

		ChefCouloir chef = CF.getId(Id);

		chef.setNomChef(chefDetails.getNomChef());
		chef.setPrenomChef(chefDetails.getPrenomChef());

		ChefCouloir updatedchef = CF.add(chef);
		return updatedchef;
	}

}
