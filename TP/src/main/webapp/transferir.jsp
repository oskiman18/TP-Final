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
	<h2> Transferir</h2>
	<form action="MovimientosServlet"  method="post">
	
	<table>
	<tr>
		<td><label>Cuenta de Origen: </label> </td>
		<td> 
 			<select name="ddlnco"> 
 			<option value=0>Seleccione </option>
			<%if (lista!= null){
				for (Cuenta c : lista) {%>
				<option value=<%=c.getNcuenta()%> > <%=c.getNcuenta() %></option>								
				<%}  
			}%>
			</select>

			   			
		</td>
	</tr>

	<tr>
		<td><label>Cuenta Destino: </label></td>
		<td><input type="number" name="ncd"></td>
	</tr>
	<tr>
		<td><label>Monto a transferir: </label></td> 
		<td><input type="number" name="txtImporte"></td>
	</tr>
	<tr>
		<td><label>Detalle</label>
		<td><input type="text" name="txtDetalle"></td>
	</tr>
	<tr>
		<td><input type="submit" name="btnTransferir" value="Confirmar" class="btn"></td>
		<td><a href="homeAdmin.jsp" > Cancelar  </a></td>
	</tr>
	
	</table>
	</form>
	</div>                
	</body>

</html>