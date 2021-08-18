package Negocio;

import java.util.ArrayList;

import Modelos.Usuario;


public interface NegUsuario {
	public boolean insertar(Usuario user);
	public ArrayList<Usuario> listar_todo();
	public boolean bajaLogica(String dni);
	public Usuario buscar(String user, String pass);
	public ArrayList<Usuario> filtrar(String cadena);
}
