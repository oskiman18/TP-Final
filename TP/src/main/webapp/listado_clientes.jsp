<%@page import="java.util.ArrayList"%>
<%@page import="Modelos.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes</title>

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

<% 
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
	ArrayList<Usuario> lista = null;
	if(request.getAttribute("lista")!=null)
	{ 
		lista = (ArrayList<Usuario>)request.getAttribute("lista");
	}
	
	%>
<div align="center">
	<h2>Lista de Usuarios Actuales</h2>
	
	<div align="center">
		<a href="registro.jsp"> Agregar Usuario Nuevo</a>
			<a href="homeCliente.jsp" class=btn>Volver</a>
		
	</div>
	<br>
	
<table style="border: black 2px solid; "rules="all" class="display" id="tabla">
<thead>
<tr>
<td> DNI </td>
<td> Apellido </td>
<td> Nombre </td>
<td> CUIL </td>
<td> Email </td>
<td> Telefono </td>
<td> Usuario </td>
<td> Rango </td>
<td> Estado </td>
<td></td>
<td></td>
</tr>
</thead>
<tbody>
    <%  if(lista!=null)
		for(Usuario u : lista) 
		{
	%>
<tr>
<form action="UsuarioServlet" method="post">
<td ><%=u.getDni()%> <input type="hidden" name="dniUsuario" value=<%=u.getDni() %>></td>
<td><%=u.getApellido()%> </td>
<td><%=u.getNombre()%></td>
<td><%=u.getCuil()%></td>
<td><%=u.getEmail()%></td>
<td><%=u.getTelefono()%></td>
<td><%=u.getUsuario()%><input type="hidden" name="nombreUsuario" value=<%=u.getUsuario() %>></td>

<%if(u.getAdministrador()) {%>
<td style=" color:blue"> Administrador</td><%} else { %> 
<td> Cliente</td> 
<%} if(u.getEstado()){%>
<td style=" color:green"> Activo</td>
<% } else { %>
<td style=" color:red"> Inactivo</td>
<% } %>
<td> <input type="submit" name="btnAsignar" class=btn value="Asignar Cuenta"></td>
<td> <input type="submit" name="btnBaja" class=btn value="Dar de Baja" ></td>

</form>
</tr>

<%  } %>

</tbody>
</table>

</div>
</body>
</html>