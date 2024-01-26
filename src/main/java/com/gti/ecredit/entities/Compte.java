package com.gti.ecredit.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Compte {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private Long num_compte;
	@Column
	private String devise;
	@Column
	private LocalDate dateOuverture;
//	@JsonIgnore
    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Credit> credits;
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="client_id",referencedColumnName="id")
    //@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    private AppUser client;
	
	public Compte(Long id, Long num_compte, String devise, LocalDate dateOuverture, List<Credit> credits,
			AppUser client) {
		this.id = id;
		this.num_compte = num_compte;
		this.devise = devise;
		this.dateOuverture = dateOuverture;
		this.credits = credits;
		this.client = client;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNum_compte() {
		return num_compte;
	}
	public void setNum_compte(Long num_compte) {
		this.num_compte = num_compte;
	}
	public String getDevise() {
		return devise;
	}
	public void setDevise(String devise) {
		this.devise = devise;
	}
	public LocalDate getDateOuverture() {
		return dateOuverture;
	}
	public void setDateOuverture(LocalDate dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	public List<Credit> getCredits() {
		return credits;
	}
	public void setCredits(List<Credit> credits) {
		this.credits = credits;
	}
	public AppUser getClient() {
		return client;
	}
	public void setClient(AppUser client) {
		this.client = client;
	}
	public Compte() {
	}
}
