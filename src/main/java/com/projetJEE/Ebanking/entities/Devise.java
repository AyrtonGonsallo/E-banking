package com.projetJEE.Ebanking.entities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.format.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="DEVISE")@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Devise {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DEVISE")
	Long id;
	
	@Column(name="CODE_DEVISE", unique=true)
	String code;
	
	@Column(name="NOM_DEVISE")
	String nom;
	
	@Column(name="LANGUE_DEVISE")
	String langue;
	
	@Column(name="ALPHA_CODE_DEVISE")
	String alphaCode;
	
	@Column(name="ISO_CODE_DEVISE")
	String isoCode;
	
	@Column(name="BANK_CODE_DEVISE")
	String bankCode="MA001";
	
	@Column(name="PAYS_CODE_DEVISE")
	String paysCode="MA";
	
	@Column(name="CREATION_DATE_DEVISE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDateTime creationDate;
	
	@ManyToOne
	@JoinColumn(name="CREATION_ADMIN_DEVISE")
	Admin creationAdmin;
	
	@Column(name="MODIFICATION_DATE_DEVISE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDateTime modificationDate;
	
	@ManyToOne
	@JoinColumn(name="MODIFICATION_ADMIN_DEVISE")
	Admin modificationAdmin;

	public Devise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Devise(Long id, String code, String nom, String langue, String alphaCode, String isoCode, String bankCode,
			String paysCode, LocalDateTime creationDate, Admin creationAdmin, LocalDateTime modificationDate,
			Admin modificationAdmin) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.langue = langue;
		this.alphaCode = alphaCode;
		this.isoCode = isoCode;
		this.bankCode = bankCode;
		this.paysCode = paysCode;
		this.creationDate = creationDate;
		this.creationAdmin = creationAdmin;
		this.modificationDate = modificationDate;
		this.modificationAdmin = modificationAdmin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String getAlphaCode() {
		return alphaCode;
	}

	public void setAlphaCode(String alphaCode) {
		this.alphaCode = alphaCode;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getPaysCode() {
		return paysCode;
	}

	public void setPaysCode(String paysCode) {
		this.paysCode = paysCode;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Admin getCreationAdmin() {
		return creationAdmin;
	}

	public void setCreationAdmin(Admin creationAdmin) {
		this.creationAdmin = creationAdmin;
	}

	public LocalDateTime getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(LocalDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Admin getModificationAdmin() {
		return modificationAdmin;
	}

	public void setModificationAdmin(Admin modificationAdmin) {
		this.modificationAdmin = modificationAdmin;
	}
	

	
}
