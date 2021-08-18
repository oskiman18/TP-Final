<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/header.jsp" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>

</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asignar Nueva Cuenta</title>
</head>

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
	String dni = null;
	if(request.getAttribute("dni")!=null)
	{
	
		dni = (String)request.getAttribute("dni");
	}
	
	String usuario=null;
	if(request.getAttribute("nombreUser")!=null)
	{
	
		usuario = (String)request.getAttribute("nombreUser");
	}

 %>
<body>
<div align="center">
<h1>Asignar Nueva Cuenta</h1>

<form method="post" action = "CuentaServlet">

	<div> 
		<label><%="Nombre de Usuario: "+ usuario %></label>
		<input name="dniUser" value=<%=dni %> type="hidden">
	</div>
	<br>
	<div> 
		<label>Ingrese numero de CBU nuevo: </label>
		<input name="txtCBU" type="number" >
	</div>
	<br>
	<div>
		Tipo de cuenta: 
     <select name="ddlTipo">
              <option value="1">Caja de ahorro</option>
              <option value="0">Cuenta corriente</option>
  
     </select>
	</div>
	<br>
	<div>
	<input type="submit" name="btnAsignarCuenta" class=btn value="Confirmar">
   <a href="UsuarioServlet?dom=1">Volver al menú</a>
	</div>
</form>
</div>
</body>
</html>