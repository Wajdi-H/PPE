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
@Table(name="Compte")
public class Compte implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String login ; 
	private String mdp ; 
	
	 @OneToOne
	   @JoinColumn(name="num_client")
	   private Client client;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Compte [Id=" + Id + ", login=" + login + ", mdp=" + mdp + ", client=" + client + "]";
	}

	public Compte(Long id, String login, String mdp, Client client) {
		super();
		Id = id;
		this.login = login;
		this.mdp = mdp;
		this.client = client;
	}

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	

}
