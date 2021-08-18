package NegocioImp;

import java.util.ArrayList;

import DAO.daoCuenta;
import Modelos.Cuenta;
import Negocio.NegCuenta;
import daoImp.daoCuentaImp;

public class NegCuentaImp implements NegCuenta{

	private daoCuenta daocuenta = new daoCuentaImp();

	
	public boolean insert(Cuenta cuenta) {
	
		return daocuenta.insertar(cuenta);
	}


	@Override
	public ArrayList<Cuenta> listar(String dni) {
		return daocuenta.cargarCuentas(dni);
	}


	@Override
	public int cantidad(String dni) {
		return daocuenta.cantidad(dni);
	}
	
	public float obtenerSaldo(int nc) {
		return daocuenta.obtenerSaldo(nc);
	}
	
}
