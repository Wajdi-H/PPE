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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Client")
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdC;
	private String nomC;
	private String prenomC;
	private String CINC;

	@OneToOne
	@JoinColumn(name = "num_adr")
	private Adresse adresse;
	@OneToOne
	@JoinColumn(name = "num_compte")
	private Compte compte;
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private Collection<Vehicule> Vehicules;

	public String getNomC() {
		return nomC;
	}

	public void setNomC(String nomC) {
		int tt=1;
		if(nomC.length()<=5)
			tt*=0;
		for(int i =0 ;i<nomC.length();i++) {
			 if((nomC.charAt(i)<65)||(nomC.charAt(i)>122)||((nomC.charAt(i)<96)&&(nomC.charAt(i)>91)))
		            tt*=0;
			 }
			 if(tt==1)
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
		int t=1;
		if(prenomC.length()<=5)
			t*=0;
		for(int i =0 ;i<nomC.length();i++) {
			 if((prenomC.charAt(i)<65)||(prenomC.charAt(i)>122)||((prenomC.charAt(i)<96)&&(prenomC.charAt(i)>91)))
		           t*=0;
			 }
			 if(t==1)
		this.prenomC = prenomC;
	}

	public String getCINC() {
		return CINC;
	}

	public void setCINC(String cINC) {
		int t=1;
		if(cINC.length() != 8)
			t*=0;
		for(int i =0 ;i<8;i++) {
			 if((cINC.charAt(i)-48<=0)&&(cINC.charAt(i)-48>=9))
       		  {    t*=0;
			       break ;
			       }
			        }
		
		 
		if(t==1)
		     this.CINC = cINC;
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
