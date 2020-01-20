<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="/css/bootstrap-4.4.1-dist/css/bootstrap.min.css" />
<title>Articoli</title>
</head>
<body>
	<a href="/home" class="btn btn-primary mt-2 ml-2 mb-2">Torna alla
		home</a>
	<br>
	<p class="bg-primary text-white ml-2 mr-2">${conferma}</p>
	<br>
	<form action="/ricerca-fatta" class="form-inline" method="POST">

		<label class="mb-2 mr-sm-2 ml-2">Codice articolo:</label> <input
			type="text" name="codiceRicerca" class="form-control mb-2 mr-sm-2"
			placeholder="Inserisci codice articolo"> <label
			class="mb-2 mr-sm-2">Descrizione:</label> <input type="text"
			name="descrizioneRicerca" class="form-control mb-2 mr-sm-2"
			placeholder="Inserisci descrizione">

		<button type="submit" class="btn btn-primary mb-2 mr-2">Filtra</button>
		<button type="submit" class="btn btn-primary mb-2"
			formaction="/articoli">Mostra tutti</button>
	</form>

	<a href="/modifica-inserisci/0/mod" class="btn btn-primary mb-2 ml-2">Inserisci
		nuovo articolo</a>
	<br>
	<h2 class="display-4 mr-2 ml-2 mt-2 bg-primary text-white">Elenco
		articoli</h2>
	<br>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">Codice Articolo:</th>
				<th scope="col">Descrizione:</th>
				<th scope="col">Quantità totale:</th>
				<th scope="col">Azioni</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${articoli}" var="art">
				<tr>
					<th scope="row">${art.codice}</th>
					<td>${art.descrizione}</td>
					<td>${art.quantitaTotale}</td>
					<td><a href="/lotti/${art.id}/show" class="btn btn-primary">Dettaglio</a>
						<a href="/modifica-inserisci/${art.id}/mod"
						class="btn btn-primary">Modifica</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>