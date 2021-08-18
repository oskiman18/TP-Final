<%@ page import="Modelos.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
</head>



<%  	
	Usuario user=null;
	if((Usuario)session.getAttribute("user")!=null){
	user=(Usuario)session.getAttribute("user");
	
	if(!user.getAdministrador()){
		RequestDispatcher dispatch= request.getRequestDispatcher("/homeCliente.jsp");
		dispatch.forward(request, response);
		}
	else{
		RequestDispatcher dispatch= request.getRequestDispatcher("/homeAdmin.jsp");
		dispatch.forward(request, response);
	}

	}%>
	
<body>

<div align="center">
<h1>Bienvenido al UTN Bank  </h1>


<form action = "LoginServlet" method="post" >
<div>Usuario:     <input type="text" name="txtUser" required/> </div>
<br>
<div>Contraseña: <input type="password" name="txtPass" required /> </div> 
<br>
<div><input type="submit" name="btnLogin" value="Iniciar Sesion" ></div>
<br>
</form>
</div>
</body>
</html>