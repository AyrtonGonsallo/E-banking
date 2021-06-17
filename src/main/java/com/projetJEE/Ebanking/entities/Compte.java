package com.projetJEE.Ebanking.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="COMPTE")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Compte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COMPTE")
	Long id;
	
	@Column(name="NUMERO_COMPTE")
	String numero;
	
	@Column(name="TYPE_COMPTE")
	String type;
	
	@Column(name="SOLDE_COMPTE")
	double solde;
	
	@ManyToOne
	@JoinColumn(name="DEVISE_COMPTE")
	Devise devise;
	
	@Column(name="CREATION_DATE_COMPTE")
	LocalDateTime creationDate;
	
	@ToString.Exclude
	@JoinColumn(name="PROPRIETAIRE_COMPTE")
	@ManyToOne
	Client proprietaire;
	
	@JoinColumn(name="CREATION_AGENT_COMPTE")
	@ManyToOne
	Agent creationAgent;
	
	@ToString.Exclude
	@JsonIgnore
	@Column(name="VIREMENTS_ENVOYES_COMPTE")
	@OneToMany(mappedBy="creancier",cascade=CascadeType.ALL)
	List<Virement> virementsEnvoyes;
	
	@ToString.Exclude
	@JsonIgnore
	@Column(name="VIREMENTS_RECUS_COMPTE")
	@OneToMany(mappedBy="debiteur",cascade=CascadeType.ALL)
	List<Virement> virementsRecus;
	
	@JsonIgnore
	@Column(name="RECHARGES_COMPTE")
	@OneToMany(mappedBy="compte",cascade=CascadeType.ALL)
	List<Recharge> recharges;
	
	@ToString.Exclude
	@JsonIgnore
	@Column(name="OPERATIONS_COMPTE")
	@OneToMany(mappedBy="compte",cascade=CascadeType.ALL)
	List<Operation> operations;

	
	
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Compte(Long id, String numero, String type, double solde, Devise devise, LocalDateTime creationDate,
			Client proprietaire, Agent creationAgent, List<Virement> virementsEnvoyes, List<Virement> virementsRecus,
			List<Recharge> recharges, List<Operation> operations) {
		super();
		this.id = id;
		this.numero = numero;
		this.type = type;
		this.solde = solde;
		this.devise = devise;
		this.creationDate = creationDate;
		this.proprietaire = proprietaire;
		this.creationAgent = creationAgent;
		this.virementsEnvoyes = virementsEnvoyes;
		this.virementsRecus = virementsRecus;
		this.recharges = recharges;
		this.operations = operations;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Devise getDevise() {
		return devise;
	}

	public void setDevise(Devise devise) {
		this.devise = devise;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Client getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Client proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Agent getCreationAgent() {
		return creationAgent;
	}

	public void setCreationAgent(Agent creationAgent) {
		this.creationAgent = creationAgent;
	}

	public List<Virement> getVirementsEnvoyes() {
		return virementsEnvoyes;
	}

	public void setVirementsEnvoyes(List<Virement> virementsEnvoyes) {
		this.virementsEnvoyes = virementsEnvoyes;
	}

	public List<Virement> getVirementsRecus() {
		return virementsRecus;
	}

	public void setVirementsRecus(List<Virement> virementsRecus) {
		this.virementsRecus = virementsRecus;
	}

	public List<Recharge> getRecharges() {
		return recharges;
	}

	public void setRecharges(List<Recharge> recharges) {
		this.recharges = recharges;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	
}
