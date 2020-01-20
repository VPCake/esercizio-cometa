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
<title>Modifica</title>
</head>
<body>
	<a href="/home" class="btn btn-primary mt-2 ml-2 mb-2">Torna alla
		home</a>
	<br>
	<form action="/salva-articolo" method="post" class="form-inline">

		<input type="hidden" name="modificaID" value="${articolo.id}">

		<label class="mb-2 mr-sm-2 ml-2">Codice articolo:</label> <input
			type="text" name="modificaCodice" value="${articolo.codice}"
			class="form-control mb-2 mr-sm-2"> <label
			class="mb-2 mr-sm-2">Descrizione:</label><input type="text"
			name="modificaDescrizione" value="${articolo.descrizione}"
			class="form-control mb-2 mr-sm-2">
		<button type="submit" class="btn btn-primary mb-2">Applica</button>
	</form>

</body>
</html>