
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TFG MANAGER</title>
</head>
<body>
<p>Sistema de gestión de TFGs</p>
	<c:if test="${user != null}">
		<c:out value="${user}" />
	</c:if>
	
	
	<!-- ûnto de entrada a la aplicación-->
	<c:if test="${not empty user and empty tfg and empty tfgs}">
	Alumno: esta es una solicitud de TFG
	<form action="/solicitud" method="post" acceptcharset="utf-8">
			<input type="hidden" name="autor" id="autor" value="${user}"/>
			<input type="text" name="titulo" id="titulo" maxLength="255"
				size="20" required placeholder="Titulo" />
			<input type="text"
				name="resumen" id="resumen" maxLength="255" required size="20"
				placeholder="resumen" />
			<input type="text" name="tutor" id="tutor"
				maxLength="255" required size="20" placeholder="tutor" />
			<input type="submit" value="Solicitud" />
		</form>
	</c:if>
	
	<!-- Si estás en estado 1 haciendo la petición del TFG -->
	<c:if test="${not empty user and not empty tfg}">
		<p>Estado del TFG:</p>
		
		<c:if test="${ tfg.estado == 1}">
			<p>Sin memoria.</p>
		</c:if>
	</c:if>
	
	<!-- Si eres profesor -->
	
<c:if test= "${not empty user and (fn:length(tfgs) != 0)}">
<p>Profesor: hay un total de <c:out value= "${(fn:length(tfgs))}" /></p>
	<table>
	<tr>
	<th>autor</th><th>titulo</th><th>resumen</th><th>tutor</th>
	<th>secretario</th><th>estado/accion</th><th>memoria</th>
	</tr>
	<c:forEach items= "${tfgs}" var="tfgi">
		<tr>
		<td><c:out value= "${tfgi.autor}" /></td>
		<td><c:out value= "${tfgi.titulo}" /></td>
		<td><c:out value= "${tfgi.resumen}" /></td>
		<td><c:out value= "${tfgi.tutor}" /></td>
	<c:choose>
		<c:when test= "${ tfgi.estado == 3}">
			<form action= "/aceptarSecretario" method="post” acceptcharset= "utf-8">
				<input type= "hidden" name="autor" value="${tfgi.autor}" />
				<td><input type= "text" name="secretario" id="secretario”
				maxLength= "255" required size="20" placeholder="tutor" /></td>
				<td><input type= "submit" value="Aceptar secretario" /></td>
			</form>
		</c:when>
		<c:when test= "${tfgi.estado == 1}">
			<form action= "/aceptarTutor" method="get" acceptcharset="utf-8">
				<input type= "hidden" name="autor" value="${tfgi.autor}" />
				<td><c:out value= "${tfgi.secretario}" /></td>
				<td><input type= "submit" value="Aceptar tutor" /></td>
				</form>
				</c:when>
				<c:otherwise>
				<td><c:out value= "${tfgi.secretario}" /></td>
				<td><c:out value= "${tfgi.estado}" /></td>
		</c:otherwise>
	</c:choose>
	<td><c:if test= "${tfgi.memoria != null}">
	<form action= "/mostrarmemoria" method="get">
		<input id= "autor" name="autor" type="hidden” value= "${tfgi.autor}" />
		<input type="submit” value= "Mostrar memoria" />
	</form>
	</c:if></td>
	</tr>
	</c:forEach>
	</table>
</c:if>

	<p>Puedes pulsar el siguiente enlace para salir
	<a href="<c:url value="${url}"/>"><c:out value="${urlLinktext}"/></a></p>

</body>
</html>