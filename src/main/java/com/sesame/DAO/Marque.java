package com.sesame.DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Marque")
public class Marque implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdM; 
	private String nom; 
	private String modele; 
	private String gamme; 
	
	  @OneToMany(mappedBy="marque", cascade=CascadeType.ALL)
	  private List<Vehicule> Vehicules;

	public Long getIdM() {
		return IdM;
	}

	public void setIdM(Long idM) {
		IdM = idM;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getGamme() {
		return gamme;
	}

	public void setGamme(String gamme) {
		this.gamme = gamme;
	}

	public List<Vehicule> getVehicules() {
		return Vehicules;
	}

	public void setVehicules(List<Vehicule> vehicules) {
		Vehicules = vehicules;
	}

	@Override
	public String toString() {
		return "Marque [IdM=" + IdM + ", nom=" + nom + ", modele=" + modele + ", gamme=" + gamme + "]";
	}

	public Marque(Long idM, String nom, String modele, String gamme) {
		super();
		IdM = idM;
		this.nom = nom;
		this.modele = modele;
		this.gamme = gamme;
	}

	public Marque() {
		super();
		// TODO Auto-generated constructor stub
	}



}
