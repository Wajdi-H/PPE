package com.sesame.DAO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Adresse")
public class Adresse implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long IdAdr;
	private String ville; 
	private String region; 
	private String rue; 
	private int codePostal ;
	 @OneToOne
	   @JoinColumn(name="num_client")
	   private Client client;
	 
	 @OneToOne
	   @JoinColumn(name="num_centre")
	   private CentreVisite centre;

	public Long getIdAdr() {
		return IdAdr;
	}

	public void setIdAdr(Long idAdr) {
		IdAdr = idAdr;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public CentreVisite getCentre() {
		return centre;
	}

	public void setCentre(CentreVisite centre) {
		this.centre = centre;
	}

	public Adresse(Long idAdr, String ville, String region, String rue, int codePostal, Client client,
			CentreVisite centre) {
		super();
		IdAdr = idAdr;
		this.ville = ville;
		this.region = region;
		this.rue = rue;
		this.codePostal = codePostal;
		this.client = client;
		this.centre = centre;
	}

	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Adresse [IdAdr=" + IdAdr + ", ville=" + ville + ", region=" + region + ", rue=" + rue + ", codePostal="
				+ codePostal + ", client=" + client + ", centre=" + centre + "]";
	}


	
	
	
}
