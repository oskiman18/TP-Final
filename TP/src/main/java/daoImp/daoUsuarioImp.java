package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.daoUsuario;
import Modelos.Usuario;

public class daoUsuarioImp implements daoUsuario{

		private static final String queryIns  = "INSERT INTO `usuarios`(`DNI`," + 
				"`CUIL`," + 
				"`nombre`," + 
				"`apellido`," + 
				"`genero`," + 
				"`direccion`," + 
				"`localidad`," + 
				"`provincia`," + 
				"`email`," + 
				"`tel`," + 
				"`telAlt`," + 
				"`usuario`," + 
				"`contraseña`," + 
				"`rango`," + 
				"`estado`)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		private static final String queryList = "Select * from usuarios";
		private static final String queryDel = "UPDATE usuarios SET estado = 0 WHERE DNI = ?";
		private static final String queryBusc = "Select * from usuarios where usuario = ? and contraseña = ?";
		private static final String queryEstado = "Select estado from usuarios where dni = ?";
		/*-----------------------------------------------*/
		
		public boolean insertar(Usuario user) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
			PreparedStatement pst;
			Connection conexion = Conexion.getConexion().getSQLConexion();
			boolean result = false;
			try{
				
				pst = conexion.prepareStatement(queryIns);
				pst.setString(1, user.getDni());
				pst.setString(2, user.getCuil());
				pst.setString(3, user.getNombre());
				pst.setString(4, user.getApellido());
				pst.setString(5, user.getGenero());
				pst.setString(6, user.getDireccion());
				pst.setString(7, user.getLocalidad());
				pst.setString(8, user.getProvincia());
				pst.setString(9, user.getEmail());
				pst.setString(10, user.getTelefono());
				pst.setString(11, user.getTelefonoAlt());
				pst.setString(12, user.getUsuario());
				pst.setString(13, user.getContraseña());
				pst.setBoolean(14, user.getAdministrador());
				pst.setBoolean(15,true);
				
				if(pst.executeUpdate() > 0){
					conexion.commit();

					result = true;
				}
			}
			catch (SQLException e) {
				
				try {
					conexion.rollback();

				} 
				catch (SQLException e1) {
				}
			
			}
			return result;

		}
		
		/*-----------------------------------------------*/
		
		public ArrayList<Usuario> listarTodo(){
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			ArrayList<Usuario> list = new ArrayList<Usuario>();
			Connection conexion = Conexion.getConexion().getSQLConexion();
			Statement st;
			try{
				conexion = Conexion.getConexion().getSQLConexion();
				st = conexion.createStatement();
				ResultSet rs = st.executeQuery(queryList);
				
				while(rs.next()){ 
					
					Usuario userRS = new Usuario();
					userRS.setDni(rs.getString(1));
					userRS.setCuil(rs.getString(2));
					userRS.setNombre(rs.getString(3));
					userRS.setApellido(rs.getString(4));
					userRS.setGenero(rs.getString(5));
					userRS.setDireccion(rs.getString(6));
					userRS.setLocalidad(rs.getString(7));
					userRS.setProvincia(rs.getString(8));
					userRS.setEmail(rs.getString(9));
					userRS.setTelefono(rs.getString(10));
					userRS.setTelefonoAlt(rs.getString(11));
					userRS.setUsuario(rs.getString(12));
					userRS.setContraseña("invisible");
					userRS.setAdministrador(rs.getBoolean(14));
					userRS.setEstado(rs.getBoolean(15));
					
					list.add(userRS);
				}
				
			}catch(Exception e){
				e.printStackTrace();}
						
			
			return list;
		}


		
		public boolean bajaLogica(String dni) {
			
			boolean result = false;
			try {
				Class.forName("com.mysql.jdbc.Driver");} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
			if(chequearEstado(dni)) {
			PreparedStatement pst;
			Connection conexion = Conexion.getConexion().getSQLConexion();
			
			try {		
				pst = conexion.prepareStatement(queryDel);
				pst.setString(1, dni);
				
				if(pst.executeUpdate() > 0){
					conexion.commit();

					result = true;
				}
			}
			catch(Exception e) {
				
				e.printStackTrace();
				}
			
			}
			return result;
		
		}

		@Override
		public Usuario buscar(String usuario, String contraseña){

			Usuario userRS = new Usuario();						
				try {
					Class.forName("com.mysql.jdbc.Driver");}
				
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			
				Connection conexion = Conexion.getConexion().getSQLConexion();
				PreparedStatement pst;
				try{
					conexion = Conexion.getConexion().getSQLConexion();
					pst = conexion.prepareStatement(queryBusc);
					pst.setString(1, usuario);
					pst.setString(2, contraseña);
					ResultSet rs = pst.executeQuery();
					while(rs.next()){ 
									
						userRS.setDni(rs.getString(1));
						userRS.setCuil(rs.getString(2));
						userRS.setNombre(rs.getString(3));
						userRS.setApellido(rs.getString(4));
						userRS.setGenero(rs.getString(5));
						userRS.setDireccion(rs.getString(6));
						userRS.setLocalidad(rs.getString(7));
						userRS.setProvincia(rs.getString(8));
						userRS.setEmail(rs.getString(9));
						userRS.setTelefono(rs.getString(10));
						userRS.setTelefonoAlt(rs.getString(11));
						userRS.setUsuario(rs.getString(12));
						userRS.setContraseña("invisible");
						userRS.setAdministrador(rs.getBoolean(14));
						userRS.setEstado(rs.getBoolean(15));					
						
					}
					
				}catch(Exception e){
					e.printStackTrace();
					}
							
				return userRS;
			
		}
		public boolean chequearEstado(String dni) {
			Boolean respuesta = false;
			Connection conexion = Conexion.getConexion().getSQLConexion();
			PreparedStatement pst;
			try{
				conexion = Conexion.getConexion().getSQLConexion();
				pst = conexion.prepareStatement(queryEstado);
				pst.setString(1, dni);
				ResultSet rs = pst.executeQuery();
				while(rs.next()){ 
					respuesta= rs.getBoolean(1);}
			}catch(Exception e){
				e.printStackTrace();
				}
			return respuesta;
		}

		public ArrayList<Usuario> listarFiltro(String cadena){
			ArrayList<Usuario>lista=new ArrayList<Usuario>();
			{
				
				try {
					Class.forName("com.mysql.jdbc.Driver");}
				
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				Connection conexion = Conexion.getConexion().getSQLConexion();
				Statement st;
				try{
					conexion = Conexion.getConexion().getSQLConexion();
					st = conexion.createStatement();
					ResultSet rs = st.executeQuery("select * from usuarios where usuario like '%"+ cadena + "%'");				
					while(rs.next()){ 						
									
						Usuario userRS = new Usuario();
						userRS.setDni(rs.getString(1));
						userRS.setCuil(rs.getString(2));
						userRS.setNombre(rs.getString(3));
						userRS.setApellido(rs.getString(4));
						userRS.setGenero(rs.getString(5));
						userRS.setDireccion(rs.getString(6));
						userRS.setLocalidad(rs.getString(7));
						userRS.setProvincia(rs.getString(8));
						userRS.setEmail(rs.getString(9));
						userRS.setTelefono(rs.getString(10));
						userRS.setTelefonoAlt(rs.getString(11));
						userRS.setUsuario(rs.getString(12));
						userRS.setContraseña("invisible");
						userRS.setAdministrador(rs.getBoolean(14));
						userRS.setEstado(rs.getBoolean(15));					
					lista.add(userRS);
					}
					
				}catch(Exception e){
					e.printStackTrace();}
							
			}
			return lista;
		}

}

