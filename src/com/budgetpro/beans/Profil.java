package com.budgetpro.beans;

public class Profil {
	private static int nbProfils = 0;
	private int id;
	private String nom;
	private String adresseMail;
	private String motDePasse;
	private int nbConnexions;
	
	public Profil(String nom, String adresseMail, String motDePasse) {
		nbProfils++;
		this.id = nbProfils;
		this.nom = nom;
		this.adresseMail = adresseMail;
		this.motDePasse = motDePasse;
		this.nbConnexions = 1;
	}

	public static int getNbProfils() {
		return nbProfils;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getNbConnexions() {
		return nbConnexions;
	}
	
	
}
