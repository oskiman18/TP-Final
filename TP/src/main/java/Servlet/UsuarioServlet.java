package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelos.Usuario;
import Negocio.NegProvincia;
import Negocio.NegUsuario;
import NegocioImp.NegProvinciaImp;
import NegocioImp.NegUsuarioImp;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	NegUsuario NU = new NegUsuarioImp();
	NegProvincia NP = new NegProvinciaImp();
	RequestDispatcher dispatcher;

	
    public UsuarioServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("dom")!=null){
			switch(Integer.parseInt(request.getParameter("dom"))) {
			case 1: listarTodo(request,response);break;
			case 2: cerrarSesion(request,response);break;			
			}			
		}
		if(request.getParameter("pom") != null) {
			
			request.setAttribute("provincias", NP.listar());
			dispatcher = request.getRequestDispatcher("/registro.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
			guardarNuevo(request,response);
			
			if (request.getParameter("btnAsignar")!=null){
				request.setAttribute("dni",request.getParameter("dniUsuario"));
				request.setAttribute("nombreUser", request.getParameter("nombreUsuario"));
				dispatcher = request.getRequestDispatcher("/asignar_cuenta.jsp");
				dispatcher.forward(request, response);}
		
			if(request.getParameter("btnBaja")!=null) {
				if(NU.bajaLogica(request.getParameter("dniUsuario"))) {
				request.setAttribute("baja", "Cliente dado de Baja");}
				else {request.setAttribute("baja", "El cliente ya esta dado de baja");}
				dispatcher = request.getRequestDispatcher("/homeAdmin.jsp");
				dispatcher.forward(request, response);
			}


	}
	
	void guardarNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("btnRegistrar")!=null){
			Usuario user = new Usuario();
					
			int adm, verificacion;
			String contra, mail, mensaje="";
			try {
			user.setDni(request.getParameter("txtDni"));
			user.setCuil(request.getParameter("txtCuil"));
			user.setNombre(request.getParameter("txtNombre"));
			user.setApellido(request.getParameter("txtApellido"));
			user.setGenero(request.getParameter("ddlGenero").toString());
			user.setDireccion(request.getParameter("txtDireccion"));
			user.setLocalidad(request.getParameter("txtLocalidad"));
			user.setProvincia(request.getParameter("ddlProvincia").toString());
			user.setEmail(request.getParameter("txtCorreo"));
			mail = request.getParameter("txtCorreo2");
			user.setTelefono(request.getParameter("txtTel"));
			user.setTelefonoAlt(request.getParameter("txtTelAlt"));
			user.setUsuario(request.getParameter("txtUsuario"));
			user.setContraseña(request.getParameter("txtContraseña"));
			contra = (String)request.getParameter("txtContraseñaConfirmar");
			adm = Integer.parseInt(request.getParameter("ddlAdm"));
			switch(adm) {
				case 0 : user.setAdministrador(false);break;
				case 1 : user.setAdministrador(true);break;}
			user.setEstado(true);
			verificacion = verificarDatos(user,contra,mail);
			
			if(verificacion != 0) {
				switch(verificacion) {
				
				case 1: mensaje="Las contraseñas no coinciden"; break;
				case 2: mensaje="DNI Invalido"; break;
				case 3: mensaje="Cuil Invalido"; break;
				case 4: mensaje="Los correos no coinciden"; break;
				}
				request.setAttribute("mensaje", mensaje);
				request.setAttribute("provincias", NP.listar());
				dispatcher = request.getRequestDispatcher("/registro.jsp");
				dispatcher.forward(request, response);
				
			}
			else {
				request.setAttribute("mensaje", mensaje);
				String confirmacion;
				if(NU.insertar(user)) {
					confirmacion="Usuario agregado con exito";
					request.setAttribute("confirmacion", confirmacion);
					dispatcher = request.getRequestDispatcher("/homeAdmin.jsp");
					dispatcher.forward(request, response);
					}
				else {
					request.setAttribute("provincias", NP.listar());
					confirmacion="Datos ya existentes en la base de datos";
					request.setAttribute("mensaje", confirmacion);
					dispatcher = request.getRequestDispatcher("/registro.jsp");
					dispatcher.forward(request, response);
				}
				
				
			}
			
				}
		catch  (Exception e) {
			
			dispatcher = request.getRequestDispatcher("/registro.jsp");
			dispatcher.forward(request, response);
			
							}
		}
		
	}
	void listarTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
			ArrayList<Usuario> lista= NU.listar_todo();
			
			request.setAttribute("lista", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/listado_clientes.jsp");   
	        rd.forward(request, response);
		
	}
	
	


	int verificarDatos(Usuario user, String con, String mail) {
		
		if(user.getContraseña().compareTo(con) != 0) {
			return 1;
		}
		if(user.getDni().length()!= 8) {
			return 2;
		}
		if(user.getCuil().length()!= 11) {
			return 3;
		}
		if(user.getEmail().compareTo(mail) != 0) {
			
			return 4;
		}
		if(user.getProvincia().compareTo("Seleccione") == 0) {
			return 2;
		}
		
		return 0;
		
	}
	
	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getSession().removeAttribute("user");
		dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);

		
	}



}