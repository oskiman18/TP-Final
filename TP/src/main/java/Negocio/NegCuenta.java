package Negocio;
import java.util.ArrayList;

import Modelos.Cuenta;

public interface NegCuenta {

	public boolean insert(Cuenta cuenta);
	public ArrayList<Cuenta> listar (String dni);
	public int cantidad(String dni);
	public float obtenerSaldo(int nc);
}
