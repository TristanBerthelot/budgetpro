package com.budgetpro.forms;

import java.text.DecimalFormat;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class DonneesFormulaire {
	public static String[] LISTE_CATEGORIES = {"loyer", "nourriture", "abonnements", "charges",
			"sorties", "divers"};
	private HashMap<String, Double> montants = new HashMap<String, Double>();
	private HashMap<String, String> pourcentages = new HashMap<String, String>();
	private DecimalFormat arrondi = new DecimalFormat("0.##");
	
	private double revenu = 1;
	private double epargne = 0;
	
	public DonneesFormulaire(HttpServletRequest request) {
		super();
		if (request.getParameter("revenu") != "")
			this.revenu = Double.parseDouble(request.getParameter("revenu"));
		this.setMontants(request);
		this.setEpargne();
		this.setPourcentages();
	}
	
	/**
	 * M�thode servant � renseigner la liste des montants par cat�gories / postes de d�penses.
	 * 
	 * Pour chacune des cat�gories, on teste s'il y a une valeur renseign�e dans le formulaire
	 * (donn�es pr�sentes dans la requ�te)
	 * Si la valeur est renseign�e, on ajoute la cat�gorie + la valeur � la liste des cat�gories
	 * (sous forme de HashMap<String, Double> )
	 * S'il n'y a pas de valeur, on met 0
	 * @param request : la requ�te HTTP contenant les donn�es renseign�es par l'utilisateur
	 */
	public void setMontants(HttpServletRequest request) {
		for (String categorie : LISTE_CATEGORIES) {
			if (request.getParameter(categorie) != "") {
				double valeurCategorie = Double.parseDouble(request.getParameter(categorie));
				montants.put(categorie, valeurCategorie);
			} else
				montants.put(categorie, 0.0);
		}
	}
	
	/**
	 * M�thode servant � renseigner les pourcentages correspondant � chaque cat�gorie.
	 * On appelle pour chaque cat�gorie la m�thode "calculPourcentage"
	 */
	public void setPourcentages() {
		for (String categorie : LISTE_CATEGORIES) {
			String pourcentage = calculerPourcentage(montants.get(categorie));
			pourcentages.put(categorie, pourcentage);
		}
	}
	
	/**
	 * Calculer montant total de l'�pargne, en soustrayant les d�penses au revenu
	 */
	public void setEpargne() {
		if (revenu == 1) {
			epargne = 0;
		} else {
			double depenses = 0;
			for (String categorie : LISTE_CATEGORIES) {
				depenses += montants.get(categorie);
			}
			epargne = revenu - depenses;
		}
	}
	
	/**
	 * V�rifier si les finances sont saines,
	 * c'est � dire si les rentr�es d'argent sont sup�rieures aux d�penses
	 * @return boolean
	 */
	public boolean financesSaines() {
		return (epargne > 0 ? true : false);
	}
	
	/**
	 * Calculer le pourcentage que repr�sente le poste de d�pense par rapport au revenu
	 * @param posteDepense le montant de la d�pense
	 * @return une String repr�sentant le pourcentage
	 */
	public String calculerPourcentage(double posteDepense) {
		double resultatCalcul = (posteDepense / revenu) * 100;
		String resArrondi = arrondi.format(resultatCalcul);
		if (!resArrondi.contains(","))
			return resArrondi + ",00%";
		else
			return resArrondi + "%";
	}
	
	
	/**
	 * La classe Categorie permet de renvoyer sous forme d'un objet : 
	 * - Le nom de la cat�gorie
	 * - Le montant en euros
	 * - Le pourcentage
	 * Chacune de ces donn�es est au format String
	 * @author titi2
	 *
	 */
	public class Categorie {
		private String nom;
		private String montant;
		private String pourcentage;
		public Categorie(String categorie) throws Exception {
			if (categorie == "epargne") {
				this.nom = categorie;
				this.montant = getMontantEpargne();
				this.pourcentage = getPourcentageEpargne();
			} else {
				try {
					this.nom = categorie;
					this.montant = montants.get(categorie).toString() + "�";
					this.pourcentage = pourcentages.get(categorie);
				} catch(Exception e) {
					System.out.println(e.getStackTrace());
				}
			}
		}
		public String getNom() {
			return nom;
		}
		public String getMontant() {
			return montant;
		}
		public String getPourcentage() {
			return pourcentage;
		}
	}
	
	/**
	 * Renvoie la cat�gorie pour l'afficher dans la JSP
	 * @param categorie : le nom de la cat�gorie
	 * @return l'objet qui associe au nom le montant et le pourcentage
	 * @throws Exception : si la cat�gorie n'existe pas
	 */
	public Categorie getCategorie(String categorie) throws Exception {
		return new Categorie(categorie);
	}

	/*
	 * GETTERS & SETTERS
	 */
	public double getRevenu() {
		return revenu;
	}

	public void setRevenu(double revenu) {
		this.revenu = revenu;
	}
	
	public String getMontantEpargne() {
		return String.valueOf(epargne) + "�";
	}
	
	public String getPourcentageEpargne() {
		return calculerPourcentage(this.epargne);
	}
	
	public String getMessage() {
		if (this.financesSaines())
			return "Vos finances sont saines. Vous arrivez � �pargner " + getMontantEpargne() +
					" chaque mois, soit " + getPourcentageEpargne() + " de votre revenu.";
		else
			return "Attention ! Vous �tes sur la pente de l'endettement.\n" +
					"Vous perdez " + getMontantEpargne().substring(1) + " chaque mois.";
	}
	
}
