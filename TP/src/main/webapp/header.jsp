<%@ page import="Modelos.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.btncerrarsesion{
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
		<%Usuario user=null;
		if((Usuario)session.getAttribute("user")!=null){
			user=(Usuario)session.getAttribute("user");%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<div>
<label>Usuario Logueado: <%=user.getApellido() +" "+ user.getNombre()%></label>
<a href='UsuarioServlet?dom=2' class=btncerrarsesion> Cerrar Sesion</a> <br>
</div>

</body><%}
		else {
			RequestDispatcher dispatch= request.getRequestDispatcher("/login.jsp");
			dispatch.forward(request, response);
		}%>
</html>