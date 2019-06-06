package com.budgetpro.beans;

public class Entree {
	private static int nbEntrees = 0;
	private int id;
	//dateLog
	//dateAjout
	private int somme;
	private boolean depense;
	private String description;
	private int nbRepetitions;
	private String recurrence;
	private int nbRecurrence;
	
	public Entree(int somme, String description, boolean estDepense) {
		nbEntrees++;
		this.id = nbEntrees;
		this.somme = somme;
		this.description = description;
		this.depense = estDepense;
	}
	
	public int getId() {
		return id;
	}
	public int getSomme() {
		return somme;
	}
	public void setSomme(int somme) {
		this.somme = somme;
	}
	public boolean isDepense() {
		return depense;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNbRepetitions() {
		return nbRepetitions;
	}
	public void setNbRepetitions(int nbRepetitions) {
		this.nbRepetitions = nbRepetitions;
	}
	public String getRecurrence() {
		return recurrence;
	}
	public void setRecurrence(String recurrence) {
		this.recurrence = recurrence;
	}
	public int getNbRecurrence() {
		return nbRecurrence;
	}
	public void setNbRecurrence(int nbRecurrence) {
		this.nbRecurrence = nbRecurrence;
	}
	
	
}
