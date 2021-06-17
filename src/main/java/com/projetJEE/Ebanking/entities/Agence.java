package com.projetJEE.Ebanking.entities;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Table(name="AGENCE")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Agence {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_AGENCE")
	Long id;
	
	@Column(name="NOM_AGENCE", unique=true)
	String nom;
	
	@Column(name="ADRESSE_AGENCE")
	String adresse;
	
	@Column(name="TELEPHONE_AGENCE", unique=true)
	String telephone;
	
	@Column(name="FAX_AGENCE", unique=true)
	String fax;
	
	@Column(name="EMAIL_AGENCE")
	String email;
	
	@ManyToOne
	@JoinColumn(name="CREATION_ADMIN_AGENCE")
	Admin creationAdmin;
	
	@ToString.Exclude
	@JsonIgnore
	@OneToMany(mappedBy="agence",cascade=CascadeType.ALL)
	@Column(name="AGENTS_AGENCE")
	List<Agent> agents;
	
	@JsonIgnore
	@OneToMany(mappedBy="agence",cascade=CascadeType.ALL)
	@Column(name="CLIENTS_AGENCE")
	List<Client> clients;
    
	
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Agence(String nom, String adresse, String telephone, String fax, String email, Admin creationAdmin,
			List<Agent> agents, List<Client> clients) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.fax = fax;
		this.email = email;
		this.creationAdmin = creationAdmin;
		this.agents = agents;
		this.clients = clients;
	}


	public Agence(Long id, String nom, String adresse, String telephone, String fax, String email, Admin creationAdmin,
			List<Agent> agents, List<Client> clients) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.fax = fax;
		this.email = email;
		this.creationAdmin = creationAdmin;
		this.agents = agents;
		this.clients = clients;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Admin getCreationAdmin() {
		return creationAdmin;
	}


	public void setCreationAdmin(Admin creationAdmin) {
		this.creationAdmin = creationAdmin;
	}


	public List<Agent> getAgents() {
		return agents;
	}


	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}


	public List<Client> getClients() {
		return clients;
	}


	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
	
}
