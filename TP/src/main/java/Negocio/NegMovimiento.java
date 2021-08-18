package Negocio;

import java.util.ArrayList;

import Modelos.Movimientos;

public interface NegMovimiento {
	public ArrayList<Movimientos> listar(int NC);
	public boolean agregar(Movimientos m);
}
