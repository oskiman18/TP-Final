package NegocioImp;

import java.util.ArrayList;

import DAO.daoCuenta;
import DAO.daoMovimiento;
import Modelos.Movimientos;
import Negocio.NegMovimiento;
import daoImp.daoMovimientoImp;

public class NegMovimientosImp implements NegMovimiento{

	private daoMovimiento daomov = new daoMovimientoImp();

	public ArrayList<Movimientos> listar(int NC) {
	
		return daomov.listar(NC);
	}
	
	public boolean agregar(Movimientos m) {
		
		return daomov.agregar(m);
		
	}
}
