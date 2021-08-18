package NegocioImp;


import java.util.ArrayList;

import DAO.daoUsuario;
import Modelos.Usuario;
import Negocio.NegUsuario;
import daoImp.daoUsuarioImp;

public class NegUsuarioImp implements NegUsuario {

	private daoUsuario Userdao = new daoUsuarioImp();
	
	
	public boolean insertar (Usuario user)
	{
		return Userdao.insertar(user);
	}


	@Override
	public ArrayList<Usuario> listar_todo() {
		return Userdao.listarTodo();
	}

	public boolean bajaLogica(String dni) {
		return Userdao.bajaLogica(dni);
	}


	@Override
	public Usuario buscar(String user, String pass) {
		return Userdao.buscar(user, pass);
	}


	@Override
	public ArrayList<Usuario> filtrar(String cadena) {
		return Userdao.listarFiltro(cadena);
	}
	
}
