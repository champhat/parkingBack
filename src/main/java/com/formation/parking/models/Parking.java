package com.formation.parking.models;

public class Parking {

	private int identifiant;
	private String nom;
	private int nbrePlaceDispo;
	private int nbrePlaceTotal;
	private String statut;
	private String heureMaj;
	
	
	public Parking() {
		super();
	}


	
	public int getIdentifiant() {
		return identifiant;
	}



	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}



	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getNbrePlaceDispo() {
		return nbrePlaceDispo;
	}


	public void setNbrePlaceDispo(int nbrePlaceDispo) {
		this.nbrePlaceDispo = nbrePlaceDispo;
	}


	public int getNbrePlaceTotal() {
		return nbrePlaceTotal;
	}


	public void setNbrePlaceTotal(int nbrePlaceTotal) {
		this.nbrePlaceTotal = nbrePlaceTotal;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public String getHeureMaj() {
		return heureMaj;
	}


	public void setHeureMaj(String heureMaj) {
		this.heureMaj = heureMaj;
	}
	

}
