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
import com.sesame.DAO.Client;
import com.sesame.Interface.AdresseMetierInterface;
import com.sesame.Interface.ClientMetierInterface;

@RestController
@RequestMapping("/client")
@CrossOrigin("*")
public class ClientRest {

	@Autowired(required = false)
	private ClientMetierInterface CF;
	@Autowired
	private AdresseMetierInterface ADR;

	@PostMapping("/add/{idadresse}")
	public Client save(@RequestBody Client client, @PathVariable long id ) {
		if (client != null) {
			Adresse ad = new Adresse();
			  ad=ADR.getId(id);
			  client.setAdresse(ad);
			return CF.add(client);
		}
		return null;
	}

	@GetMapping("/get")
	public Collection<Client> findALL() {
		return CF.getAll();
	}

	@GetMapping("/get/{id}")
	public Client findById(@PathVariable Long id) {
		return CF.getId(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteClient(@PathVariable(value = "id") Long courId) {
		Client client = CF.getId(courId);

		CF.delete(client.getIdC());

		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public Client updateClient(@PathVariable(value = "id") Long clientId, @Valid @RequestBody Client clientDetails) {

		Client client = CF.getId(clientId);

		client.setAdresse(clientDetails.getAdresse());
		client.setCINC(clientDetails.getCINC());
		client.setNomC(clientDetails.getNomC());
		client.setPrenomC(clientDetails.getPrenomC());

		Client updatedclient = CF.add(client);
		return updatedclient;
	}

}