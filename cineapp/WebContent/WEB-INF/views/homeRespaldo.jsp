<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- Añadir para utilizar jstl (<c:forEach> loops y condicionales) --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Añadir para utilizar jstl formato fechas (formato y i18n) --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%-- Añadir para utilizar tags de spring (<spring:url>) --%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido a Cineapp</title>

<!-- 	Crea una ruta relativa al contextpath para el acceso a los recursos -->
<spring:url value="/resources" var="urlPublic" />

<!-- Bootstrap desde web-->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" -->
<!-- 	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" -->
<!-- 	crossorigin="anonymous"> -->

<!-- 	Bootstrap desde local -->
<link rel="stylesheet"
	href="${urlPublic}/bootstrap/css/bootstrap.min.css">

</head>
<body>
	<!-- 	<h1>Lista de Peliculas</h1> -->

	<!-- 	<ol> -->
	<%-- 		<c:forEach items="${peliculas}" var="pelicula"> --%>
	<%-- 			<li>${pelicula}</li> --%>
	<%-- 		</c:forEach> --%>
	<!-- 	</ol> -->

	<div class="panel panel-default">
		<div class="panel-heading">Lista de peliculas</div>
		<div class="panel-body">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Titulo</th>
						<th>Duracion</th>
						<th>Clasificacion</th>
						<th>Genero</th>
						<th>Imagen</th>
						<th>Fecha Estreno</th>
						<th>Estatus</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${peliculas}" var="pelicula">
						<tr>
							<td>${pelicula.id}</td>
							<td>${pelicula.titulo}</td>
							<td>${pelicula.duracion}</td>
							<td>${pelicula.clasificacion}</td>
							<td>${pelicula.genero}</td>
							<td><img src="${urlPublic}/images/${pelicula.imagen}"
								width="80" height="100"></td>

							<!--Fecha con formato -->
							<td><fmt:formatDate value="${pelicula.fechaEstreno}"
									pattern="dd-MM-yyyy" /></td>

							<!--Color de estado dependiendo de valor -->
							<td><c:choose>
									<c:when test="${pelicula.estatus=='Activa'}">
										<span class="label label-success">ACTIVA</span>
									</c:when>
									<c:otherwise>
									<span class="label label-danger">INACTIVA</span>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>