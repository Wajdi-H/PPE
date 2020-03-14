package com.sesame.DAO;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	  @OneToMany(mappedBy = "", cascade=CascadeType.ALL)
	  
	  private Collection<Vehicule> Vehicules;

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

	public Collection<Vehicule> getVehicules() {
		return Vehicules;
	}

	public void setVehicules(Collection<Vehicule> vehicules) {
		Vehicules = vehicules;
	}

	public Marque(Long idM, String nom, String modele, String gamme, Collection<Vehicule> vehicules) {
		super();
		IdM = idM;
		this.nom = nom;
		this.modele = modele;
		this.gamme = gamme;
		Vehicules = vehicules;
	}

	public Marque() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Marque [IdM=" + IdM + ", nom=" + nom + ", modele=" + modele + ", gamme=" + gamme + ", Vehicules="
				+ Vehicules + "]";
	}
	  
	  

}
