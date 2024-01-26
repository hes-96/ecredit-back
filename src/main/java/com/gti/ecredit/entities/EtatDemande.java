package com.gti.ecredit.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EtatDemande {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String etat;
	
	@JsonIgnore
    @OneToMany(mappedBy = "etat", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Credit> credits;

	public EtatDemande(Long id, String etat, List<Credit> credits) {
		this.id = id;
		this.etat = etat;
		this.credits = credits;
	}

	public EtatDemande() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public List<Credit> getCredits() {
		return credits;
	}

	public void setCredits(List<Credit> credits) {
		this.credits = credits;
	}
    
    
}
