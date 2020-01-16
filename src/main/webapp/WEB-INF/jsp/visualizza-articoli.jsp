<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Articoli</title>
</head>
<body>
	<c:forEach items="${articoli}" var="art">
		<div>${art.CodiceLotto}- ${art.IdArticolo}</div>
	</c:forEach>
	<div>${quantita}</div>
</body>
</html>