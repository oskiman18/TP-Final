package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelos.Movimientos;
import Negocio.NegCuenta;
import Negocio.NegMovimiento;
import NegocioImp.NegCuentaImp;
import NegocioImp.NegMovimientosImp;

@WebServlet("/MovimientosServlet")
public class MovimientosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	NegMovimiento NM = new NegMovimientosImp();
	NegCuenta NC = new NegCuentaImp();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("btnMovimientos") != null) {
			
			ArrayList<Movimientos> lista = new ArrayList<Movimientos>();
			int nc = Integer.parseInt((String) request.getParameter("ncuenta"));
			lista = NM.listar(nc);
			request.setAttribute("ncuenta", nc);
			request.setAttribute("movimientos", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/movimientos.jsp");   
	        rd.forward(request, response);
	        }
		
		if(request.getParameter("btnTransferir") != null) {

			Movimientos m = new Movimientos();
			String mensaje="";
			float saldo = NC.obtenerSaldo(Integer.parseInt(request.getParameter("ddlnco")));
			try {
				m.setDetalle(request.getParameter("txtDetalle"));
				m.setImporte(Float.parseFloat(request.getParameter("txtImporte")));
				m.setNCD(Integer.parseInt(request.getParameter("ncd")));
				m.setNCO(Integer.parseInt(request.getParameter("ddlnco")));
				if(m.getImporte() < saldo) {
					if(NM.agregar(m)) {
						mensaje="Transferencia Exitosa";
					}
				}
				else {
					mensaje="El monto es Mayor al saldo";
				}
			
				
			}
			
			catch (Exception e)
			{
				mensaje="error";
			}
			request.setAttribute("msj", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher("/homeCliente.jsp");   
	        rd.forward(request, response);
			
		}
	}	
}
