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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="RDV")
public class RendezVous implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdR;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateR;
	
	private String heure;
	
	@ManyToOne
	@JoinColumn(name = "codecentre")
	private CentreVisite centre;

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


}
