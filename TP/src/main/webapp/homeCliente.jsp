<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/header.jsp" %>
    
<!DOCTYPE html>
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

</style>
<head>
<meta charset="ISO-8859-1">
<title> Home </title>
</head>
<% if((Usuario)session.getAttribute("user")!=null){
	user=(Usuario)session.getAttribute("user");
	if(user.getAdministrador()){
		RequestDispatcher dispatch= request.getRequestDispatcher("/homeAdmin.jsp");
		dispatch.forward(request, response);
	}
	}
	else{
		RequestDispatcher dispatch= request.getRequestDispatcher("/login.jsp");
		dispatch.forward(request, response);
	}
	if( request.getAttribute("msj")!= null){
			%>
			<script type="text/javascript">
			alert('<%=(String) request.getAttribute("msj")%>');
			</script>
			<%}%>
		
	<body>
	<h2 align="center"> Menu Principal</h2>
		<div align="center"><br>
		<a href='CuentaServlet?com=2&dni=<%=user.getDni()%>'> Realizar Transferencia </a>
		</div> 
		<div align="center"><br>
		<a href='CuentaServlet?com=1&dni=<%=user.getDni()%>'>  Mis Cuentas </a>
		</div> 
		<div align="center"><br>
		<a href='perfil.jsp'> Mi perfil </a>
		</div>
	
	</body>

</html>