package com.example.DAO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class RendezVous implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdR;
	private Date dateR; 
	private String heure; 
	 @OneToOne
	   @JoinColumn(name="num_vehicule")
	   private Vehicule vehicule;
	 @ManyToOne
	 @JoinColumn(name="codecentre")
	 private  CentreVisite centre;
	public Long getIdR() {
		return IdR;
	}
	public void setIdR(Long idR) {
		IdR = idR;
	}
	public Date getDateR() {
		return dateR;
	}
	public void setDateR(Date dateR) {
		this.dateR = dateR;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	public CentreVisite getCentre() {
		return centre;
	}
	public void setCentre(CentreVisite centre) {
		this.centre = centre;
	}
	@Override
	public String toString() {
		return "RendezVous [IdR=" + IdR + ", dateR=" + dateR + ", heure=" + heure + ", vehicule=" + vehicule
				+ ", centre=" + centre + "]";
	}
	public RendezVous(Long idR, Date dateR, String heure, Vehicule vehicule, CentreVisite centre) {
		super();
		IdR = idR;
		this.dateR = dateR;
		this.heure = heure;
		this.vehicule = vehicule;
		this.centre = centre;
	}
	public RendezVous() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}