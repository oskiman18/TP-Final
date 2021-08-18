<%@page import="Modelos.Usuario" %>
<%@page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Datos Personales </title>
</head>

<% 
	if((Usuario)session.getAttribute("user")!=null)
	{	
		user = (Usuario)session.getAttribute("user");
	}
	else { RequestDispatcher dispatch= request.getRequestDispatcher("/login.jsp");
	dispatch.forward(request, response);}
	if(user.getDni() !=null){
 %>
 
 
	<body>
	<div align="center">
	<h1> Mis datos</h1>
	<table>
		<tr>
			<td> Usuario: </td><td><%=user.getUsuario()%></td> 
		</tr>
		<tr>	
			<td> Nombre: </td><td><%=user.getNombre()%> </td>
		</tr>
		<tr>	
			<td> Apellido: </td><td><%=user.getApellido()%> </td>
		</tr>
		<tr>	
			<td> Género: </td><td><%=user.getGenero()%> </td>
			</tr>
		<tr>	
		<td>	 DNI: </td><td><%=user.getDni()%> </td></tr>
		<tr>	
		<td>	 CUIL: </td><td><%=user.getCuil()%> </td></tr>
		<tr>	
		<td>	 Localidad: </td><td><%=user.getLocalidad()%> </td></tr>
		<tr>	
		<td>	 Provincia: </td><td><%=user.getProvincia()%> </td></tr>
		<tr>	
		<td>	 Telefono: </td><td><%=user.getTelefono()%> </td></tr>
		<tr>	
			<% if (user.getTelefonoAlt() != null) {%><td> Telefono Alternativo: </td><td><%=user.getTelefonoAlt()%> </td>
			<% } else { %>
		<td>	 Telefono Alternativo: </td><td>No posee  </td><% } %></tr>
		<tr>	
		<td>	 Email: </td><td><%=user.getEmail()%></td>
		</tr>
		<tr>	  
			</tr>
	</table>
	<br>
	<%}%>
	<a href="homeCliente.jsp" class=btn>Volver</a>
	
	</div>
	</body>

</html>