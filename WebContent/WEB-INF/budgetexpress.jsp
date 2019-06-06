<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/budgetexpress.css">
	<%@ include file="transverse/libsHead.html" %>
	<title>Budget express</title>
</head>
<body>
	<%@ include file="transverse/navbar.html" %>
	
	<div id="content" class="container">
	
		<div id="formulaireContainer">
			<form id="formulaire" action="" method="POST">
				<div id="revenu">
					<label for="revenu"><strong>Revenus : </strong></label>
					<input type="number" name="revenu" value="0" min="1"/>
				</div>
				<div class="posteDepense">
					<label for="loyer">Loyer : </label>
					<input type="number" name="loyer" value="0"/>
				</div>
				<div class="posteDepense">
					<label for="nourriture">Nourriture : </label>
					<input type="number" name="nourriture" value="0"/>
				</div>
				<div class="posteDepense">
					<label for="abonnements">Abonnements : </label>
					<input type="number" name="abonnements" value="0"/>
				</div>
				<div class="posteDepense">
					<label for="charges">Charges : </label>
					<input type="number" name="charges" value="0"/>
				</div>
				<div class="posteDepense">
					<label for="sorties">Sorties : </label>
					<input type="number" name="sorties" value="0"/>
				</div>
				<div class="posteDepense">
					<label for="divers">Divers : </label>
					<input type="number" name="divers" value="0"/>
				</div>
				<input id="validation" type="submit" value="Lancer le calcul"/>
			</form>
		</div>
		
		<div id="resultats" class="bloc">
			<div id="tableContainer">
				<table id="tableResultats">
					<tr class="rangeeResultats">
						<td class="caseResultats">
							<c:if test = "${ not empty loyer }">
								<div><c:out value="${ loyer.nom }"/></div>
								<div><c:out value="${ loyer.montant }"/></div>
								<div class="pourcentage"><c:out value="${ loyer.pourcentage }"/></div>
							</c:if>
						</td>
						<td class="caseResultats">
							<c:if test = "${ not empty nourriture }">
								<div><c:out value="${ nourriture.nom }"/></div>
								<div><c:out value="${ nourriture.montant }"/></div>
								<div class="pourcentage"><c:out value="${ nourriture.pourcentage }"/></div>
							</c:if>
						</td>
						<td class="caseResultats">
							<c:if test = "${ not empty abonnements }">
								<div><c:out value="${ abonnements.nom }"/></div>
								<div><c:out value="${ abonnements.montant }"/></div>
								<div class="pourcentage"><c:out value="${ abonnements.pourcentage }"/></div>
							</c:if>
						</td>
					</tr>
					<tr class="rangeeResultats">
						<td class="caseResultats">
							<c:if test = "${ not empty charges }">
								<div><c:out value="${ charges.nom }"/></div>
								<div><c:out value="${ charges.montant }"/></div>
								<div class="pourcentage"><c:out value="${ charges.pourcentage }"/></div>
							</c:if>
						</td>
						<td class="caseResultats">
							<c:if test = "${ not empty sorties }">
								<div><c:out value="${ sorties.nom }"/></div>
								<div><c:out value="${ sorties.montant }"/></div>
								<div class="pourcentage"><c:out value="${ sorties.pourcentage }"/></div>
							</c:if>
						</td>
						<td class="caseResultats">
							<c:if test = "${ not empty divers }">
								<div><c:out value="${ divers.nom }"/></div>
								<div><c:out value="${ divers.montant }"/></div>
								<div class="pourcentage"><c:out value="${ divers.pourcentage }"/></div>
							</c:if>
						</td>
					</tr>
					<tr class="rangeeResultats">
						<td class="caseResultats">
							<c:if test = "${ not empty epargne }">
								<div><c:out value="${ epargne.nom }"/></div>
								<div><c:out value="${ epargne.montant }"/></div>
								<div class="pourcentage"><c:out value="${ epargne.pourcentage }"/></div>
							</c:if>
						</td>
						<td class="caseResultats"></td>
						<td class="caseResultats"></td>
					</tr>
				</table>
			</div>
			<div id="message">
				<c:if test = "${ not empty message }">
					<div><c:out value="${ message }"/></div>
				</c:if>
			</div>
			<div id="bouton">
				<button id="boutonGraphiques">Générer graphiques</button>
			</div>
		</div>
		
		<div id="vuesResultats" class="bloc">
			<canvas id="graph1"></canvas>
			<hr>
			<canvas id="graph2"></canvas>
		</div>
	
	</div>
	<%@ include file="transverse/libsEnd.html" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/validationFormulaire.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/graphiques.js"></script>
</body>
</html>