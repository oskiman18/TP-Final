package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import Modelos.Usuario;

public interface daoUsuario {
	
	public boolean insertar(Usuario cliente);
	public boolean bajaLogica(String dni);
	public Usuario buscar(String usuario, String contraseña);
	public ArrayList<Usuario> listarTodo();
	public ArrayList<Usuario> listarFiltro(String cadena);
}
