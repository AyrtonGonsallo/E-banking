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
@Table(name="OPERATION")
@NoArgsConstructor @AllArgsConstructor @ToString
public @Data class Operation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_OPERATION")
	Long id;
	
	@ToString.Exclude
	@JoinColumn(name="COMPTE_OPERATION")
	@ManyToOne 
	Compte compte;

	
	@Column(name="DATE_OPERATION")
	LocalDateTime date;
	
	@Column(name="SOMME_ESPECE_OPERATION")
	double sommeEspece;
	
	@Column(name="SOMME_COMPTE_OPERATION")
	double sommeCompte;
	
	@Column(name="TYPE_OPERATION")
	String type;
	
	@ManyToOne
	@JoinColumn(name="DEVISE_OPERATION")
	Devise devise;

	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Operation(Long id, Compte compte, LocalDateTime date, double sommeEspece, double sommeCompte, String type,
			Devise devise) {
		super();
		this.id = id;
		this.compte = compte;
		this.date = date;
		this.sommeEspece = sommeEspece;
		this.sommeCompte = sommeCompte;
		this.type = type;
		this.devise = devise;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getSommeEspece() {
		return sommeEspece;
	}

	public void setSommeEspece(double sommeEspece) {
		this.sommeEspece = sommeEspece;
	}

	public double getSommeCompte() {
		return sommeCompte;
	}

	public void setSommeCompte(double sommeCompte) {
		this.sommeCompte = sommeCompte;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Devise getDevise() {
		return devise;
	}

	public void setDevise(Devise devise) {
		this.devise = devise;
	}
	
	

}
