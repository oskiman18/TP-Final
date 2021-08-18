<%@ page import="Modelos.Usuario"%>
<%@ page import="Modelos.Provincia"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
a {
	text-decoration: none;
	border: 1px solid;
	border-color: rgb(133, 133, 133);
	background-color: internal-light-dark; 
	color: black;
	font: 400 13.3333px Arial;
	border-style: outset;	
	text-align:center;
	border-width:2px;
	box-sizing:border-box;
	padding: 1px 6px;
}
.btn{
	text-decoration: none;
	border: 1px solid;
	border-color: rgb(133, 133, 133);
	background-color: internal-light-dark; 
	color: black;
	font: 400 13.3333px Arial;
	border-style: outset;	
	text-align:center;
	border-width:2px;
	box-sizing:border-box;
	padding: 1px 6px;
	cursor: pointer;
}
</style>

<% 
		String message = "";
		if(request.getAttribute("mensaje") != null){
			message = (String)request.getAttribute("mensaje");
		}
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
		ArrayList<Provincia> lista = null;
		if(request.getAttribute("provincias") != null){
			lista=((ArrayList<Provincia>)request.getAttribute("provincias"));
			
		}
		
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo Cliente</title>
</head>


<body>
<div align="center">
<h1> Ingrese los datos del nuevo cliente</h1>
  	<label style="color:red"><%=message %></label>
	<form method="post" action="UsuarioServlet">
	<table>
	<tr>
			<td><label>DNI:</label></td>		
			<td><input type="number" name="txtDni" required /></td>
	</tr>
	<tr>
			<td><label>CUIL:</label></td>
			<td><input type="number" name="txtCuil" required/></td>
	</tr>
	<tr>
			<td><label>Nombre:</label></td>
			<td><input type="text" name="txtNombre" required/></td>
	</tr>
	<tr>
			<td><label>Apellido:</label></td>
			<td><input type="text" name="txtApellido" required/></td>
	</tr>
	<tr>
			<td><label>Sexo:</label></td>
		<td>	<select name="ddlGenero">
				<option>Seleccione</option>
				<option>Masculino</option>
				<option>Femenino</option>
			</select></td>
	</tr>
	<tr>
			<td><label>Direccion:</label></td>
		<td>	<input type="text" name="txtDireccion" required/></td>
	</tr>
	<tr>
			<td><label>Localidad:</label></td>
			<td><input type="text" name="txtLocalidad" required/></td>
	</tr>
	<tr>
			<td><label>Provincia:</label></td>
			<td><select name="ddlProvincia">
					<option>Seleccione</option>
					<% if (lista!= null){for(Provincia p : lista){ %> 
					<option><%=p.getNombre() %>
					</option>
					<% } 
					}%> 
				</select></td>
	<tr>
			<td><label>Correo Electronico:</label></td>
			<td><input type="email" name="txtCorreo" required/></td>
	</tr>
	<tr>
			<td><label>Repita Correo:</label></td>
			<td><input type="email" name="txtCorreo2" required/></td>
	</tr>
	<tr>
			<td><label>Telefono:</label></td>
			<td><input type="number" name="txtTel" required/></td>
	</tr>
	<tr>
			<td><label>Telefono Alternativo:</label></td>
			<td><input type="number" name="txtTelAlt"/></td>
	</tr>
	
	<tr>
			<td><label>Nombre de Usuario:</label></td>
			<td><input type="text" name="txtUsuario" required/></td>
	</tr>
	<tr>
			<td><label>Contraseña Usuario:</label></td>
			<td><input type="password" name="txtContraseña" required/></td>
	</tr>
	
	<tr>
			<td><label>Confirmar Contraseña:</label></td>
			<td><input type="password" name="txtContraseñaConfirmar" required/></td>
	</tr>
	<tr>
			<td><label>¿Administrador?</label></td>
			<td><select name="ddlAdm">
				<option value = 0>Cliente</option>
				<option value = 1>Administrador</option>
			</select></td>
	</tr>
	<tr>
			<td><input type="submit" class=btn name="btnRegistrar" value="Registrar Usuario""/></td>
			<td><a href="homeAdmin.jsp" > Cancelar  </a></td>
	</tr>
	</table>

  </form>
</div>
</body>
</html>