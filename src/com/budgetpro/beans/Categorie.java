package com.budgetpro.beans;

public class Categorie {
	private static int nbCategories;
	private int id;
	private String nom;
	private int montantAttendu;
	private int sommeEntrees;
	private double pourcentMontantAttendu;
	private double pourcentSommeEntrees;
	private String urlImage;
	
	public Categorie(String nom, int montantAttendu) {
		nbCategories++;
		this.id = nbCategories;
		this.nom = nom;
		this.montantAttendu = montantAttendu;
		this.sommeEntrees = 0;
	}
	
	public double calculPourcentage(int revenus, int montant) {
		return (montant / revenus) * 100;
	}

	public static int getNbCategories() {
		return nbCategories;
	}
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public int getMontantAttendu() {
		return montantAttendu;
	}
	public int getSommeEntrees() {
		return sommeEntrees;
	}
	public double getPourcentMontantAttendu() {
		return pourcentMontantAttendu;
	}
	public double getPourcentSommeEntrees() {
		return pourcentSommeEntrees;
	}
	public String getUrlImage() {
		return urlImage;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setMontantAttendu(int montantAttendu) {
		this.montantAttendu = montantAttendu;
	}
	public void setSommeEntrees(int sommeEntrees) {
		this.sommeEntrees = sommeEntrees;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
	
	
	
}
