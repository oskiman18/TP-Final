<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Nuevo Prestamo </title>
</head>

	<body>
	<h3>Nuevo Prestamo</h3>
		<form action='home.jsp'> 
			<div>
				<label for='monto'>Monto del prestamo</label>
				<input name='monto' type='number' placeholder='monto'>
				
				<label for='cuotas'>Cantidad de cuotas</label>
				<input name='cuotas' type='number' placeholder='cuotas'>
			</div>
			
			<div>
				<select>
					<option value='1'>Cuenta A</option>
					<option value='2'> Cuenta B </option>
					<option value='3'> Cuenta C </option>
				</select>
			</div>
			<input type='submit' value='Pedir Prestamo'>
		</form>
	</body>
	</body>

</html>