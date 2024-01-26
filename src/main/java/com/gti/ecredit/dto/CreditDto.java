package com.gti.ecredit.dto;

import java.time.LocalDate;

public class CreditDto {
	private Double montant;
    private Integer nbEcheances;
    private LocalDate entreEnRelationLe;
    private String par;
    private LocalDate dateDemande;
    private int numDemande;
    private Boolean decision;
    private String observation;
    public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Integer getNbEcheances() {
		return nbEcheances;
	}
	public void setNbEcheances(Integer nbEcheances) {
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
	public Boolean getDecision() {
		return decision;
	}
	public void setDecision(Boolean decision) {
		this.decision = decision;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public Long getCompteId() {
		return compteId;
	}
	public void setCompteId(Long compteId) {
		this.compteId = compteId;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public Long getEtatId() {
		return etatId;
	}
	public void setEtatId(Long etatId) {
		this.etatId = etatId;
	}
	public Long getUniteId() {
		return uniteId;
	}
	public void setUniteId(Long uniteId) {
		this.uniteId = uniteId;
	}
	private Long compteId;
    @Override
	public String toString() {
		return "CreditDto [montant=" + montant + ", nbEcheances=" + nbEcheances + ", entreEnRelationLe="
				+ entreEnRelationLe + ", par=" + par + ", dateDemande=" + dateDemande + ", numDemande=" + numDemande
				+ ", decision=" + decision + ", observation=" + observation + ", compteId=" + compteId + ", typeId="
				+ typeId + ", etatId=" + etatId + ", uniteId=" + uniteId + "]";
	}
	private Long typeId;
    private Long etatId;
    private Long uniteId;
}
