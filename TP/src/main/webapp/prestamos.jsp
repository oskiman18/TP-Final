<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/header.jsp" %>
<%@page import="Modelos.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Transferencia </title>
</head>
<% 
	ArrayList<Cuenta> lista = null;
	if(request.getAttribute("cuentas")!=null)
	{ 
		lista = (ArrayList<Cuenta>)request.getAttribute("cuentas");
	}
	
	%>
	<body>
	<div align="center">
	
	<form action="MovimientoServlet"  method="post">
	
	<table>
	<tr>
		<td><label>Cuenta de Origen:</label> 
			<select>
			<%for (Cuenta c : lista) {%>
			<option><%=c.getNcuenta() %></option>
			<%} %>
			</select>
		</td>
	</tr>
	<tr>
		<td><label>Cuenta Destino:</label> 
			<input type="number">
		</td>
	</tr>
	<tr>
		<td><label>Monto a transferir:</label> 
			<input type="number">
		</td>
	</tr>
	
	
	</table>
	
	
	
	
	
	
	
	
	
	</form>
	
	
	
	
	
	
	
	
	
	
	
	
	</div>
	
	
	
	</body>

</html>