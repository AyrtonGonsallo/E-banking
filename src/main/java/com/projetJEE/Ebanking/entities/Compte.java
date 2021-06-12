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
	@OneToMany(mappedBy="debiteur",cascade=CascadeType.ALL)
	List<Virement> virementsEnvoyes;
	
	@ToString.Exclude
	@JsonIgnore
	@Column(name="VIREMENTS_RECUS_COMPTE")
	@OneToMany(mappedBy="creancier",cascade=CascadeType.ALL)
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

}
