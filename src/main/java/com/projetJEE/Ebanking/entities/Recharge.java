package com.projetJEE.Ebanking.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="RECHARGE")
@NoArgsConstructor @AllArgsConstructor @ToString
public @Data class Recharge {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_RECHARGE")
	Long id;
	
	@Column(name="SOMME_ENV_RECHARGE")
	double sommeEnv;
	
	@Column(name="SOMME_RECU_RECHARGE")
	double sommeRecu;
	
	@ManyToOne
	@JoinColumn(name="DEVISE_RECHARGE")
	Devise devise;
	
	@Column(name="TELEPHONE_RECHARGE")
	String telephone;
	
	@Column(name="DATE_RECHARGE")
	LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name="COMPTE_RECHARGE")
	Compte compte;
	
	@ManyToOne
	@JoinColumn(name="OPERATEUR_RECHARGE")
	Operateur operateur;

	public Recharge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recharge(Long id, double sommeEnv, double sommeRecu, Devise devise, String telephone, LocalDateTime date,
			Compte compte, Operateur operateur) {
		super();
		this.id = id;
		this.sommeEnv = sommeEnv;
		this.sommeRecu = sommeRecu;
		this.devise = devise;
		this.telephone = telephone;
		this.date = date;
		this.compte = compte;
		this.operateur = operateur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSommeEnv() {
		return sommeEnv;
	}

	public void setSommeEnv(double sommeEnv) {
		this.sommeEnv = sommeEnv;
	}

	public double getSommeRecu() {
		return sommeRecu;
	}

	public void setSommeRecu(double sommeRecu) {
		this.sommeRecu = sommeRecu;
	}

	public Devise getDevise() {
		return devise;
	}

	public void setDevise(Devise devise) {
		this.devise = devise;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Operateur getOperateur() {
		return operateur;
	}

	public void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}
	
	

}
