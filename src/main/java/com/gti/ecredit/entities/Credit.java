package com.gti.ecredit.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Credit {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private Double montant;
	@Column
	private int nbEcheances;
	@Column
	private LocalDate entreEnRelationLe;
	@Column
	private String par;
	@Column
	private LocalDate dateDemande;
	@Column
	private int numDemande;
	@Column
	private Double montantRembourse;
	@Column
	private boolean decision;
	@Column(length=1000)
	private String observation;
	
	
    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Garantie> garanties;
	
    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL)
    private List<PieceJointe> pieces;
	
    @JsonIgnore
	@ManyToOne()
    @JoinColumn(name="compte_id")
    private Compte compte;
	
	
	@ManyToOne()
	@JoinColumn(name = "typeId")
    private TypeCredit type;
	
	@ManyToOne()
	@JoinColumn(name = "etatId")
    private EtatDemande etat;
	
	@ManyToOne()
	@JoinColumn(name = "uniteId")
    private Unite unite;

	public Credit(Long id, Double montant, int nbEcheances, LocalDate entreEnRelationLe, String par,
			LocalDate dateDemande, int numDemande, boolean decision, String observation, List<Garantie> garanties,
			List<PieceJointe> pieces, Compte compte, TypeCredit type, EtatDemande etat, Unite unite) {
		this.id = id;
		this.montant = montant;
		this.nbEcheances = nbEcheances;
		this.entreEnRelationLe = entreEnRelationLe;
		this.par = par;
		this.dateDemande = dateDemande;
		this.numDemande = numDemande;
		this.decision = decision;
		this.observation = observation;
		this.garanties = garanties;
		this.pieces = pieces;
		this.compte = compte;
		this.type = type;
		this.etat = etat;
		this.unite = unite;
	}

	public Credit() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public int getNbEcheances() {
		return nbEcheances;
	}

	public void setNbEcheances(int nbEcheances) {
		this.nbEcheances = nbEcheances;
	}

	public LocalDate getEntreEnRelationLe() {
		return entreEnRelationLe;
	}

	public void setEntreEnRelationLe(LocalDate entreEnRelationLe) {
		this.entreEnRelationLe = entreEnRelationLe;
	}

	public String getPar() {
		return par;
	}

	public void setPar(String par) {
		this.par = par;
	}

	public LocalDate getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(LocalDate dateDemande) {
		this.dateDemande = dateDemande;
	}

	public int getNumDemande() {
		return numDemande;
	}

	public void setNumDemande(int numDemande) {
		this.numDemande = numDemande;
	}

	public boolean isDecision() {
		return decision;
	}

	public void setDecision(boolean decision) {
		this.decision = decision;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public List<Garantie> getGaranties() {
		return garanties;
	}

	public void setGaranties(List<Garantie> garanties) {
		this.garanties = garanties;
	}

	public List<PieceJointe> getPieces() {
		return pieces;
	}

	public void setPieces(List<PieceJointe> pieces) {
		this.pieces = pieces;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public TypeCredit getType() {
		return type;
	}

	public void setType(TypeCredit type) {
		this.type = type;
	}

	public EtatDemande getEtat() {
		return etat;
	}

	public void setEtat(EtatDemande etat) {
		this.etat = etat;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}
	
	public Double calculMontantRembourse(){
		Double rembourse = this.montant + this.montant * this.type.getTauxInteret();
		this.setMontantRembourse(rembourse);
		return rembourse;
	}

	public Double getMontantRembourse() {
		return montantRembourse;
	}

	public void setMontantRembourse(Double montantRembourse) {
		this.montantRembourse = montantRembourse;
	}
}
