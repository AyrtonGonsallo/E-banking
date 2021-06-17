package com.projetJEE.Ebanking.entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="OPERATEUR")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Operateur extends Client{
	private int numeroOperateur;

	
	public Operateur(String estOperateur, Agent creationAgent, Agence agence, List<Compte> comptes) {
		super(estOperateur, creationAgent, agence, comptes);
		// TODO Auto-generated constructor stub
	}

	public Operateur(String estOperateur, Agent creationAgent, Agence agence, List<Compte> comptes,
			int numeroOperateur) {
		super(estOperateur, creationAgent, agence, comptes);
		this.numeroOperateur = numeroOperateur;
	}

	public Operateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNumeroOperateur() {
		return numeroOperateur;
	}

	public void setNumeroOperateur(int numeroOperateur) {
		this.numeroOperateur = numeroOperateur;
	}
	
		

}
