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
import com.sesame.DAO.RendezVous;
import com.sesame.DAO.Vehicule;
import com.sesame.Interface.CentreMetierInterface;
import com.sesame.Interface.RendezVousMetierInterface;
import com.sesame.Interface.VehiculeMetierInterface;

@RestController
@RequestMapping("/rendez-vous")
@CrossOrigin("*")
public class RendezVousRest {

	@Autowired(required = false)
	private RendezVousMetierInterface CF;
	@Autowired
	private VehiculeMetierInterface VF;
	@Autowired
	private CentreMetierInterface CVF;
	

	@PostMapping("/add/{idc}/{idv}")
	public RendezVous save(@RequestBody RendezVous rdv,@PathVariable long idc,@PathVariable long idv)
	{
		Vehicule vh = new Vehicule();
		CentreVisite CV = new CentreVisite();
		vh = VF.getId(idv);
		CV = CVF.getId(idc);
		rdv.setCentre(CV);
		rdv.setVehicule(vh);

		return CF.Add(rdv);

	}

	@GetMapping("/get")
	public Collection<RendezVous> findALL() {
		return CF.getAll();
	}

	@GetMapping("/get/{id}")
	public RendezVous findById(@PathVariable Long id) {
		return CF.getId(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteRendezVous(@PathVariable(value = "id") Long Id) {

		RendezVous rdv = CF.getId(Id);

		CF.Delete(rdv.getIdR());

		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public RendezVous update(@PathVariable(value = "id") Long Id, @Valid @RequestBody RendezVous rdvDetails) {

		RendezVous rdv = CF.getId(Id);

		rdv.setDateR(rdvDetails.getDateR());
		rdv.setHeure(rdvDetails.getHeure());

		RendezVous updatedrdv = CF.Add(rdv);
		return updatedrdv;
	}

}
