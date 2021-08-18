package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Modelos.Usuario;
import Negocio.NegUsuario;
import NegocioImp.NegUsuarioImp;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      NegUsuario NU = new NegUsuarioImp();
 
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnLogin") != null) {
			Usuario user =NU.buscar((String)request.getParameter("txtUser"), (String)request.getParameter("txtPass"));
			if(user.getDni() != null) {
				
				HttpSession s = request.getSession();
				if(user.getEstado()) {
					s.setAttribute("user", user);
					
					if(user.getAdministrador()) {						
						RequestDispatcher dispatcher = request.getRequestDispatcher("/homeAdmin.jsp");
						dispatcher.forward(request, response);
						}
					
					else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("/homeCliente.jsp");
						dispatcher.forward(request, response);
						}
					}
				
				else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/userInactivo.jsp");
					dispatcher.forward(request, response);}
				}
			
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
				}
				 
		}
	}


}
		
		
	


