<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/test.css">
	<%@ include file="transverse/libsHead.html" %>
	<title>Budget pro</title>
</head>
<body>
	<%@ include file="transverse/navbar.html" %>
	
	<div class="container">
	
		<div class="row">
		
			<form id="col1" class="col-md-3">
				<div class="row">
					<div class="col-lg-12" id="revenus">
						<label for="revenu"><strong>Revenus : </strong></label>
						<input type="number" name="revenu" value="0" min="1"/>
					</div>
				</div>
				<div class="row" id="champsFormulaire">
					<div class="col-lg-12 posteDepense">
						<label for="loyer">Loyer : </label>
						<input type="number" name="loyer" value="${ 0 }" min="0"/>
					</div>
					<div class="col-lg-12 posteDepense">Nourriture</div>
					<div class="col-lg-12 posteDepense">Abonnements</div>
					<div class="col-lg-12 posteDepense">Charges</div>
					<div class="col-lg-12 posteDepense">Sorties</div>
					<div class="col-lg-12" id="divers">Divers</div>
				</div>
				<div class="row" id="validationFormulaire">
					<input type="submit" value="Valider" class="col-lg-12"/>
				</div>
			</form>
			
			<div id="col2" class="col-md-3 bloc">
				<div class="row" id="conteneurCases">
					<div class="col-lg-4 col-6 caseResultat">
						cell1
					</div>
					<div class="col-lg-4 col-6 caseResultat">
					cell2
					</div>
					<div class="col-lg-4 col-6 caseResultat">
					cell3
					</div>
					<div class="col-lg-4 col-6 caseResultat">
					cell4
					</div>
					<div class="col-lg-4 col-6 caseResultat">
					cell5
					</div>
					<div class="col-lg-4 col-6 caseResultat">
					cell6
					</div>
					<div class="col-lg-4 col-6 caseResultat">
					cell7
					</div>
					<div class="col-lg-4 col-6 caseResultat">
					cell8
					</div>
					<div class="col-lg-4 col-6 caseResultat">
					cell9
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12" id="messageBudget">
						<c:if test = "${ not empty message }">
							<div><c:out value="${ message }"/></div>
						</c:if>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-2"><br></div>
					<button class="col-lg-8" id="boutonGraphiques">Générer graphiques</button>
					<div class="col-lg-2"><br></div>
				</div>
			</div>
			
			<div id="col3" class="col-md-5 bloc">
				<div class=row>
					<div class="col-lg-12 graphique" id="graph1">Graphique 1</div>
				</div>
				<div class=row>
					<div class="col-lg-12 graphique" id="graph2">Graphique 2</div>
				</div>
			</div>
			
		</div>
		
		<div class="row">
			<div class="col-lg-12 rangee">Test</div>
		</div>
		
	</div>

	<%@ include file="transverse/libsEnd.html" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/graphiques.js"></script>
</body>
</html>