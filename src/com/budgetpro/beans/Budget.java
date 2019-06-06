package com.budgetpro.beans;

public class Budget {
	private static int nbBudgets = 0;
	private int id;
	private Categorie[] categories;
	private String type;
	private int totalRevenus = 0;
	private int totalDepenses = 0;
	private int epargne = 0;
	
	public Budget(String type) {
		nbBudgets++;
		this.id = nbBudgets;
		this.type = type;
		//Ajout de catégories par défaut
	}
	
	public boolean financesSaines() {
		return (epargne >= 0 ? true : false);
	}

	public static int getNbBudgets() {
		return nbBudgets;
	}
	public int getId() {
		return id;
	}
	public Categorie[] getCategories() {
		return categories;
	}
	public String getType() {
		return type;
	}
	public int getTotalRevenus() {
		return totalRevenus;
	}
	public int getTotalDepenses() {
		return totalDepenses;
	}
	public int getEpargne() {
		return epargne;
	}
	
}
