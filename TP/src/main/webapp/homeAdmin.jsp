<%@ page import="Modelos.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/header.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
		if( request.getAttribute("confirmacion")!= null){
			%>
			<script type="text/javascript">
			alert('<%=(String) request.getAttribute("confirmacion")%>');
			</script>
			<%}
		if(request.getAttribute("baja") != null){
			%>
			<script type="text/javascript">
			alert('<%=(String) request.getAttribute("baja")%>');
			</script>
			<%}
		if( request.getAttribute("msj")!= null){
			%>
			<script type="text/javascript">
			alert('<%=(String) request.getAttribute("msj")%>');
			</script>
			<%}
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Administrador</title>

</head>
<body>
	<h2 align="center"> Menu Principal</h2>
	<div align="center"><br>
		<a href='UsuarioServlet?pom=1'> Dar cliente de alta </a>
	</div>
	<div align="center"><br>
		<a href='UsuarioServlet?dom=1'> Listar Clientes</a>
	</div>
	<div align="center"><br>
	<a href='ReporteServlet?rom=1'> Reporte Estadistico</a>
	</div>
	<div align="center"><br>
	<a href='perfil.jsp'> Mi perfil </a>
	</div>
</body>

</html>