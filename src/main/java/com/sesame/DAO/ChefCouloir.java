package com.sesame.DAO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ChefCouloir")
public class ChefCouloir implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdChef;
	private String nomChef;
	private String prenomChef ; 
	
	 @OneToOne
	   @JoinColumn(name="num_couloir")
	   private Couloir couloir;

	public Long getIdChef() {
		return IdChef;
	}

	public void setIdChef(Long idChef) {
		IdChef = idChef;
	}

	public String getNomChef() {
		return nomChef;
	}

	public void setNomChef(String nomChef) {
		this.nomChef = nomChef;
	}

	public String getPrenomChef() {
		return prenomChef;
	}

	public void setPrenomChef(String prenomChef) {
		this.prenomChef = prenomChef;
	}

	public Couloir getCouloir() {
		return couloir;
	}

	public void setCouloir(Couloir couloir) {
		this.couloir = couloir;
	}

	@Override
	public String toString() {
		return "ChefCouloir [IdChef=" + IdChef + ", nomChef=" + nomChef + ", prenomChef=" + prenomChef + ", couloir="
				+ couloir + "]";
	}

	public ChefCouloir(Long idChef, String nomChef, String prenomChef, Couloir couloir) {
		super();
		IdChef = idChef;
		this.nomChef = nomChef;
		this.prenomChef = prenomChef;
		this.couloir = couloir;
	}

	public ChefCouloir() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	
	 
	 

}
