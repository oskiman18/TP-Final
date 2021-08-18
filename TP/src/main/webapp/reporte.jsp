<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/header.jsp" %>
<%@page import="Modelos.Reporte"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporte</title>
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
<body>
	<% Reporte r= null;
	if((Usuario)session.getAttribute("user")!=null){
		user=(Usuario)session.getAttribute("user");
		
		if(!user.getAdministrador()){
			RequestDispatcher dispatch= request.getRequestDispatcher("/homeCliente.jsp");
			dispatch.forward(request, response);
		}
	}
	else{
		RequestDispatcher dispatch= request.getRequestDispatcher("/login.jsp");
		dispatch.forward(request, response);
	}
	if(request.getAttribute("reporte")!=null)
	{ 
		r = (Reporte)request.getAttribute("reporte");
	}%>
<div align="center">
	<h2>Reporte</h2>
	<table id=tabla>
		<thead>
			<tr>
				<td>Usuarios Activos</td>
				<td>Usuarios Inactivos</td>
				<td>Saldo total de cuentas</td>
				<td>Cuentas Totales</td>
				<td>Cuentas Corrientes</td>
				<td>Cajas de ahorro</td>
				<td>Transferencias Totales</td>
				<td>Monto Promedio de Transferencias</td>
			</tr>
		</thead>
		<tbody>
		<tr>
			<td><%=r.getUserA() %></td>
			<td><%=r.getUserI() %></td>
			<td><%=r.getSaldoTotal() %></td>
			<td><%=r.getCuentasTotales() %></td>
			<td><%=r.getCuentascorrientes() %></td>
			<td><%=r.getCajasAhorro() %></td>
			<td><%=r.getTtransferencias() %></td>
			<td><%=r.getPMTransferencias() %></td>
			
		</tr>
		
		</tbody>

</table>
	<a href="homeCliente.jsp" class=btn>Volver</a>
</div>

</body>
</html>