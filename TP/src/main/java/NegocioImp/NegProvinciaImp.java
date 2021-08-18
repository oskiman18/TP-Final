package NegocioImp;

import java.util.ArrayList;

import DAO.daoProvincia;
import Modelos.Provincia;
import Negocio.NegProvincia;
import daoImp.daoProvinciaImp;

public class NegProvinciaImp implements NegProvincia{

	daoProvincia daop = new daoProvinciaImp();

	
	public ArrayList<Provincia> listar() {
		return daop.listar();
	}
	
	
}
