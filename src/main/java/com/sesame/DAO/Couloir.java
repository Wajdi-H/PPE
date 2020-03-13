package com.sesame.DAO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Couloir")
public class Couloir implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id; 

	@ManyToOne
    @JoinColumn(name="centre_id")
    private CentreVisite centre;
	
	
	@OneToOne
	@JoinColumn(name="num_chef")   
	private ChefCouloir chefC;
	
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public CentreVisite getCentre() {
		return centre;
	}
	public void setCentre(CentreVisite centre) {
		this.centre = centre;
	}
	public ChefCouloir getChefC() {
		return chefC;
	}
	public void setChefC(ChefCouloir chefC) {
		this.chefC = chefC;
	}
	@Override
	public String toString() {
		return "Couloir [Id=" + Id + ", centre=" + centre + ", chefC=" + chefC + "]";
	}
	public Couloir(Long id, CentreVisite centre, ChefCouloir chefC) {
		super();
		Id = id;
		this.centre = centre;
		this.chefC = chefC;
	}
	public Couloir() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
	 
	 
	 
}
