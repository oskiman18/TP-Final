<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/header.jsp" %>
<%@page import="Modelos.Movimientos"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Movimientos </title>
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


<% 
	ArrayList<Movimientos> lista = null;
	int nc= 0;
	if(request.getAttribute("movimientos")!=null)
	{ 
		lista = (ArrayList<Movimientos>)request.getAttribute("movimientos");
	}
	if(request.getAttribute("ncuenta") != null){
		
		nc = Integer.parseInt((String) request.getParameter("ncuenta"));
	}
	%>
</head>
<body>
<div align="center">
<h2>Movimientos Cuenta</h2>
<a href="homeCliente.jsp" class=btn>Volver</a>
<table id="tabla" class="display" >
<thead>
<tr>
<td>Origen</td>
<td>Destino</td>
<td>Importe</td>
<td>Tipo de movimiento</td>
<td>Fecha </td>

<td>Detalle</td>

</tr>

</thead>
<%  if(lista!=null)
		for(Movimientos m : lista) 
		{
	%>
<tbody>
<tr>

<td><%=m.getNCO()%></td>
<td><%=m.getNCD() %></td>
<td><%=m.getImporte() %></td>
<% if(m.getNCO() == nc){ %>
<td style="color:red">Salida </td>
<%  } else  { %>
<td style="color:green">Entrada</td>
<%} %>
<td><%=m.getFecha() %></td>
<td><%=m.getDetalle() %></td>

<%} %>
</tbody>
</table>

</div>
</body>
</html>