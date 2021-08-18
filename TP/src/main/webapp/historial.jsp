<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/header.jsp" %>
<%@page import="Modelos.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Mis Cuentas </title>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#tabla').DataTable();
	});
</script>
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
	<h2> Mis Cuentas </h2>
	
		<table style="border: black 2px solid; "rules="all" class="display" id="tabla">
<thead>
<tr>
<td> Numero de Cuenta </td>
<td> CBU </td>
<td> Fecha de Creacion </td>
<td> Tipo </td>
<td> Saldo </td>
<td></td>
</tr>
</thead>
<tbody>
    <%  if(lista!=null)
		for(Cuenta c : lista) 
		{
	%>
<tr>
<form action="MovimientosServlet" method="post">


<td ><%=c.getNcuenta()%> <input type="hidden" name="ncuenta" value=<%=c.getNcuenta() %>></td>
<td><%=c.getCbu()%> </td>
<td><%=c.getFecha()%></td>
<% if(c.getTipo()){ %>
<td>Cuenta corriente</td>
<%} else { %>
<td>Caja de Ahorro</td>
<%} %>
<td><%=c.getSaldo()%></td>

<td> <input type="submit" name="btnMovimientos" class=btn value="Ver Movimientos"></td>

</form>
</tr>

<%  } %>

</tbody>
</table>

	</div>
	</body>

</html>