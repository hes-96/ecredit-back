package com.gti.ecredit.dto;


public class PieceDto {
	private String document;
	private boolean obligatoire;
	private Long creditId;
	
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public boolean isObligatoire() {
		return obligatoire;
	}
	public void setObligatoire(boolean obligatoire) {
		this.obligatoire = obligatoire;
	}
	public Long getCreditId() {
		return creditId;
	}
	public void setCreditId(Long creditId) {
		this.creditId = creditId;
	}
	
}
