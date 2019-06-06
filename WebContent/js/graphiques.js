/**
 * 
 * GESTION DES GRAPHIQUES - DATA VISUALISATION
 * 
 */
document.getElementById('boutonGraphiques').onclick = function() {
	
	var nbCases = 7;
	var cases = document.querySelectorAll('.caseResultats');
	
	if (cases[0].childNodes[1] !== undefined) {
		
		/*----------------------------
 			Récupération des données
 		----------------------------*/
		var labels = new Array(nbCases);
		var data = new Array(nbCases);
		
		for (var i = 0; i < nbCases; i++) {
			labels[i] = cases[i].childNodes[1].textContent;
			
			var dataStr = cases[i].childNodes[5].textContent.replace(',', '.');
			data[i] = parseFloat(dataStr.substring(0, dataStr.length-1));
		}
		
		/*--------------------------------------
			Réglages généraux des graphiques
		---------------------------------------*/
		Chart.defaults.global.title.display = true;
		Chart.defaults.global.title.text = 'PAS DE TITRE';
		Chart.defaults.global.elements.point.radius = 10;
		
		/*----------------------
			Premier graphique
		------------------------*/
		var configGraph1 = {
			type: 'line',
			data: {
				labels: labels,
				datasets: [{
					label: 'Dépenses',
					backgroundColor: 'rgb(181, 234, 255)',
					borderColor: 'rgba(255, 99, 132, 0.25)',
					data: data
				}]
			},
			options: {
				title: {
					text: 'PREMIER GRAPHIQUE',
				},
				elements: {
					point: {
						radius: 5,
						backgroundColor: 'rgb(0, 0, 255)'
					}
				}
			}
		};
		
		/*----------------------
			Deuxième graphique
		------------------------*/
		var configGraph2 = {
			type: 'pie',
			data: {
				datasets: [{
					data: data,
					backgroundColor: [
						'rgb(249, 237, 9)',
						'rgb(66, 244, 143)',
						'rgb(89, 66, 244)',
						'rgb(176, 244, 66)',
						'rgb(249, 9, 49)',
						'rgb(9, 249, 209)',
						'rgb(66, 134, 244)'
					]
				}],
				labels: labels
			},
			options: {
				responsive: true,
				title: {
					text: 'DEUXIEME GRAPHIQUE'
				}
			}
		};
			
		/*------------------------
		 	Exécution du code
		 -----------------------*/
		var ctx1 = document.getElementById('graph1').getContext('2d');
		var chart1 = new Chart(ctx1, configGraph1);
		var ctx2 = document.getElementById('graph2').getContext('2d');
		var chart2 = new Chart(ctx2, configGraph2);
		
	} else {
		console.log('Pas de données pour créer les graphiques');
	}
}
