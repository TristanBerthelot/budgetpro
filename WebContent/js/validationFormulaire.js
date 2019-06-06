/**
 * Contrôle opéré sur les données saisies : 
 * 	Dans certains navigateurs anciens, le <input type=number> n'est pas reconnu,
 * 	par conséquent l'utilisateur peut saisir des lettres et faire planter le code côté serveur.
 * 	Ici on vérifie que le champ 'revenu' ne contient que des nombres.
 */

const form = document.getElementById('formulaire');

form.onsubmit = function(event) {
	event.preventDefault();
	const revenu = document.getElementById('revenu').childNodes[3].value;
	if (! /^\d+$/.test(revenu))
		window.alert("Saisie invalide");
	else
		form.submit();
}