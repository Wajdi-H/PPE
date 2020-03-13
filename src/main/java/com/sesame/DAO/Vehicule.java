package com.sesame.DAO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Vehicules")
public class Vehicule implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdV;
	private String matricule; 
	private String typeV; 
	private Date dateSortie; 
	private int age; 
	private String kilometrage; 
	private int nbCylindre; 
	
	
	@ManyToOne
	@JoinColumn(name="code_Client")
	private  Client client;
	@OneToOne
	   @JoinColumn(name="num_rendezVous")
	   private RendezVous rendezVous;
	
	@ManyToOne
	@JoinColumn(name="codeMarque")
	private  Marque marque;

	public Long getIdV() {
		return IdV;
	}

	public void setIdV(Long idV) {
		IdV = idV;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getTypeV() {
		return typeV;
	}

	public void setTypeV(String typeV) {
		this.typeV = typeV;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(String kilometrage) {
		this.kilometrage = kilometrage;
	}

	public int getNbCylindre() {
		return nbCylindre;
	}

	public void setNbCylindre(int nbCylindre) {
		this.nbCylindre = nbCylindre;
	}

	public Client getClients() {
		return client;
	}

	public void setClients(Client clients) {
		this.client = clients;
	}

	public RendezVous getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(RendezVous rendezVous) {
		this.rendezVous = rendezVous;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	@Override
	public String toString() {
		return "Vehicule [IdV=" + IdV + ", matricule=" + matricule + ", typeV=" + typeV + ", dateSortie=" + dateSortie
				+ ", age=" + age + ", kilometrage=" + kilometrage + ", nbCylindre=" + nbCylindre + ", clients="
				+ client + ", rendezVous=" + rendezVous + ", marque=" + marque + "]";
	}

	public Vehicule(Long idV, String matricule, String typeV, Date dateSortie, int age, String kilometrage,
			int nbCylindre, Client clients, RendezVous rendezVous, Marque marque) {
		super();
		IdV = idV;
		this.matricule = matricule;
		this.typeV = typeV;
		this.dateSortie = dateSortie;
		this.age = age;
		this.kilometrage = kilometrage;
		this.nbCylindre = nbCylindre;
		this.client = clients;
		this.rendezVous = rendezVous;
		this.marque = marque;
	}

	public Vehicule() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
