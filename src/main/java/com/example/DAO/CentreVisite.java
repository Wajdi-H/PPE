package com.example.DAO;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CentreVisite implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdCentre;
	private String nom ; 
	private int nbCouloir; 
	 @OneToOne
	   @JoinColumn(name="num_Adr")
	   private Adresse adresse;
	
	 @OneToMany(mappedBy="CentreVisite", cascade=CascadeType.ALL)
	  private Collection<RendezVous> rdvs; 
	 
	 @OneToMany(mappedBy="CentreVisite", cascade=CascadeType.ALL)
	  private Collection<Couloir> couloirs;

	public Long getIdCentre() {
		return IdCentre;
	}

	public void setIdCentre(Long idCentre) {
		IdCentre = idCentre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Collection<RendezVous> getRdvs() {
		return rdvs;
	}

	public void setRdvs(Collection<RendezVous> rdvs) {
		this.rdvs = rdvs;
	}

	public Collection<Couloir> getCouloirs() {
		return couloirs;
	}

	public void setCouloirs(Collection<Couloir> couloirs) {
		this.couloirs = couloirs;
	}

	

	@Override
	public String toString() {
		return "CentreVisite [IdCentre=" + IdCentre + ", nom=" + nom + ", nbCouloir=" + nbCouloir + ", adresse="
				+ adresse + ", rdvs=" + rdvs + ", couloirs=" + couloirs + "]";
	}

	public CentreVisite(Long idCentre, String nom, int nbCouloir, Adresse adresse, Collection<RendezVous> rdvs,
			Collection<Couloir> couloirs) {
		super();
		IdCentre = idCentre;
		this.nom = nom;
		this.nbCouloir = nbCouloir;
		this.adresse = adresse;
		this.rdvs = rdvs;
		this.couloirs = couloirs;
	}

	public int getNbCouloir() {
		return nbCouloir;
	}

	public void setNbCouloir(int nbCouloir) {
		this.nbCouloir = nbCouloir;
	}

	public CentreVisite() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	 
}
