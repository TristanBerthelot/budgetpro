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
	 * Méthode servant à renseigner la liste des montants par catégories / postes de dépenses.
	 * 
	 * Pour chacune des catégories, on teste s'il y a une valeur renseignée dans le formulaire
	 * (données présentes dans la requête)
	 * Si la valeur est renseignée, on ajoute la catégorie + la valeur à la liste des catégories
	 * (sous forme de HashMap<String, Double> )
	 * S'il n'y a pas de valeur, on met 0
	 * @param request : la requête HTTP contenant les données renseignées par l'utilisateur
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
	 * Méthode servant à renseigner les pourcentages correspondant à chaque catégorie.
	 * On appelle pour chaque catégorie la méthode "calculPourcentage"
	 */
	public void setPourcentages() {
		for (String categorie : LISTE_CATEGORIES) {
			String pourcentage = calculerPourcentage(montants.get(categorie));
			pourcentages.put(categorie, pourcentage);
		}
	}
	
	/**
	 * Calculer montant total de l'épargne, en soustrayant les dépenses au revenu
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
	 * Vérifier si les finances sont saines,
	 * c'est à dire si les rentrées d'argent sont supérieures aux dépenses
	 * @return boolean
	 */
	public boolean financesSaines() {
		return (epargne > 0 ? true : false);
	}
	
	/**
	 * Calculer le pourcentage que représente le poste de dépense par rapport au revenu
	 * @param posteDepense le montant de la dépense
	 * @return une String représentant le pourcentage
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
	 * - Le nom de la catégorie
	 * - Le montant en euros
	 * - Le pourcentage
	 * Chacune de ces données est au format String
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
					this.montant = montants.get(categorie).toString() + "€";
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
	 * Renvoie la catégorie pour l'afficher dans la JSP
	 * @param categorie : le nom de la catégorie
	 * @return l'objet qui associe au nom le montant et le pourcentage
	 * @throws Exception : si la catégorie n'existe pas
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
		return String.valueOf(epargne) + "€";
	}
	
	public String getPourcentageEpargne() {
		return calculerPourcentage(this.epargne);
	}
	
	public String getMessage() {
		if (this.financesSaines())
			return "Vos finances sont saines. Vous arrivez à épargner " + getMontantEpargne() +
					" chaque mois, soit " + getPourcentageEpargne() + " de votre revenu.";
		else
			return "Attention ! Vous êtes sur la pente de l'endettement.\n" +
					"Vous perdez " + getMontantEpargne().substring(1) + " chaque mois.";
	}
	
}
