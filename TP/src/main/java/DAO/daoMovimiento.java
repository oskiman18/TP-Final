package DAO;

import java.util.ArrayList;

import Modelos.Movimientos;

public interface daoMovimiento {

	public ArrayList<Movimientos> listar(int NC);
	public boolean agregar(Movimientos m);
	
}
