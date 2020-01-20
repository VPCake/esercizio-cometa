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
<title>Lotti</title>
</head>
<body>
	<a href="/home" class="btn btn-primary mt-2 ml-2">Torna alla home</a>
	<br>
	<h2 class="display-4 mr-2 ml-2 mt-2 bg-primary text-white">Elenco
		lotti</h2>
	<br>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Codice Lotto:</th>
				<th scope="col">Quantit�:</th>

			</tr>
		<tbody>
			<c:forEach items="${lotti}" var="lot">
				<tr>
					<th scope="row">${lot.codiceLotto}</th>
					<td>${lot.quantita}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>