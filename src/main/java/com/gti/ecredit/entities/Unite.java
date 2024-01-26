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
public class Unite {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String unite;
	
	@JsonIgnore
    @OneToMany(mappedBy = "unite", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Credit> credits;

	public Unite(Long id, String unite, List<Credit> credits) {
		this.id = id;
		this.unite = unite;
		this.credits = credits;
	}

	public Unite() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public List<Credit> getCredits() {
		return credits;
	}

	public void setCredits(List<Credit> credits) {
		this.credits = credits;
	}
	
	
}
