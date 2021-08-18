package DAO;
import java.util.ArrayList;

import Modelos.Cuenta;


public interface daoCuenta {

	public boolean insertar(Cuenta cuenta);
	public ArrayList<Cuenta> cargarCuentas(String dni);
	public int cantidad(String dni);
	public float obtenerSaldo(int nc);
}
