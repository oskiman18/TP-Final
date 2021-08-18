package Servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Modelos.Cuenta;
import Modelos.Usuario;
import Negocio.NegCuenta;
import NegocioImp.NegCuentaImp;

@WebServlet("/CuentaServlet")
public class CuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	NegCuenta NC = new NegCuentaImp();
	
    public CuentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirect = null, dni = request.getParameter("dni");

		if(request.getParameter("com")!=null){
			listarTodo(request,response, dni);
			switch(Integer.parseInt(request.getParameter("com"))) {
			case 1: redirect="/historial.jsp";break;
			case 2: redirect="/transferir.jsp";break;			
			}			
			
			RequestDispatcher rd = request.getRequestDispatcher(redirect);   
	        rd.forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("btnAsignarCuenta")!=null)
		{		
			asignarCuenta(request,response);			
		}
	
	}
	
	
	void asignarCuenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msj="";
		try {
			
			Cuenta cuenta = new Cuenta();		
			cuenta.setDNI(request.getParameter("dniUser"));
			cuenta.setTipo(Boolean.parseBoolean(request.getParameter("ddlTipo")));
			cuenta.setCbu(request.getParameter("txtCBU"));
			cuenta.setSaldo(10000);
			if(NC.cantidad((cuenta.getDNI())) < 3) {
				if(NC.insert(cuenta)) {
					msj = "Agregado Correctamente";
				}
				
				else {
				msj = "CBU repetido";
				}
			}			
			else {
				msj="El usuario ya posee 3 cuentas";
			}
		}
		catch (Exception e) {
			msj="Error Critico";
			
		}
		
		request.setAttribute("msj", msj);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/homeAdmin.jsp");
		dispatcher.forward(request, response);
	}
	
	void listarTodo(HttpServletRequest request, HttpServletResponse response, String dni) throws ServletException, IOException {
		
		ArrayList<Cuenta> lista= NC.listar(dni);
		
		request.setAttribute("cuentas", lista);
		
	}

}

