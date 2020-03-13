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
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Client")
public class Client implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdC; 
	private String nomC; 
	private String prenomC; 
	private String CINC; 
	
	  @OneToOne
	   @JoinColumn(name="num_adr")
	   private Adresse adresse;
	  @OneToOne
	   @JoinColumn(name="num_compte")
	   private Compte compte;
	  @OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	  private Collection<Vehicule> Vehicules;
	  
	  
	public String getNomC() {
		return nomC;
	}
	public void setNomC(String nomC) {
		this.nomC = nomC;
	}
	
	public Long getIdC() {
		return IdC;
	}
	public void setIdC(Long idC) {
		IdC = idC;
	}
	public String getPrenomC() {
		return prenomC;
	}
	public void setPrenomC(String prenomC) {
		this.prenomC = prenomC;
	}
	public String getCINC() {
		return CINC;
	}
	public void setCINC(String cINC) {
		CINC = cINC;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Collection<Vehicule> getVehicules() {
		return Vehicules;
	}
	public void setVehicules(Collection<Vehicule> vehicules) {
		Vehicules = vehicules;
	}
	@Override
	public String toString() {
		return "Client [IdC=" + IdC + ", nomC=" + nomC + ", prenomC=" + prenomC + ", CINC=" + CINC + ", adresse="
				+ adresse + ", compte=" + compte + ", Vehicules=" + Vehicules + "]";
	}
	public Client(Long idC, String nomC, String prenomC, String cINC, Adresse adresse, Compte compte,
			Collection<Vehicule> vehicules) {
		super();
		IdC = idC;
		this.nomC = nomC;
		this.prenomC = prenomC;
		CINC = cINC;
		this.adresse = adresse;
		this.compte = compte;
		Vehicules = vehicules;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
