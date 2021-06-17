package com.projetJEE.Ebanking.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="VIREMENT")
@NoArgsConstructor @AllArgsConstructor @ToString
public @Data class Virement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_VIREMENT")
	Long id;
	
	@JoinColumn(name="CREANCIER_VIREMENT")
	@ManyToOne 
	Compte creancier;
	
	@ToString.Exclude
	@JoinColumn(name="DEBITEUR_VIREMENT")
	@ManyToOne
	Compte debiteur;
	
	@Column(name="DATE_VIREMENT")
	LocalDateTime date;
	
	@Column(name="SOMME_ENV_VIREMENT")
	double sommeEnv;
	
	@Column(name="SOMME_RECU_VIREMENT")
	double sommeRecu;

	public Virement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Virement(Long id, Compte creancier, Compte debiteur, LocalDateTime date, double sommeEnv, double sommeRecu) {
		super();
		this.id = id;
		this.creancier = creancier;
		this.debiteur = debiteur;
		this.date = date;
		this.sommeEnv = sommeEnv;
		this.sommeRecu = sommeRecu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Compte getCreancier() {
		return creancier;
	}

	public void setCreancier(Compte creancier) {
		this.creancier = creancier;
	}

	public Compte getDebiteur() {
		return debiteur;
	}

	public void setDebiteur(Compte debiteur) {
		this.debiteur = debiteur;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
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

	

}