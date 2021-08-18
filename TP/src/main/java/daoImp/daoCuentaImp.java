package daoImp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.daoCuenta;
import daoImp.Conexion;
import Modelos.Cuenta;
import Modelos.Usuario;

public class daoCuentaImp implements daoCuenta{

	
		private static final String insert = "INSERT INTO cuenta (cliente,  cbu, creacion, tipo, saldo) VALUES (?,?, now(),?,?)";
		private static final String listar="Select * from cuenta where cliente = ?";
		private static final String contar="select count(cliente) from cuenta where cliente = ?";
		private static final String saldo ="select saldo from cuenta where ncuenta =?";
		
		
		
		
		public boolean insertar(Cuenta cuenta) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
			PreparedStatement pst;
			Connection conexion = Conexion.getConexion().getSQLConexion();
			boolean result = false;
			
			try
			{			
				pst = conexion.prepareStatement(insert);
				pst.setString(1, cuenta.getDNI());
				pst.setString(2, cuenta.getCbu());
				pst.setBoolean(3, cuenta.getTipo());
				pst.setFloat(4, 10000);
				
				if(pst.executeUpdate() > 0){
					conexion.commit();
					result = true;
				}
			}
			
			catch(SQLException e)
			{

				try {
					conexion.rollback();
	
				} 
				catch (SQLException e1) {
				}
			}
		
			return result;
			
			
		}	
		
		
		public ArrayList<Cuenta> cargarCuentas(String dni){
			ArrayList<Cuenta> lista = new ArrayList<Cuenta>();			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();
			}		
			PreparedStatement pst;
			Connection conexion = Conexion.getConexion().getSQLConexion();			
			try
			{	
				pst = conexion.prepareStatement(listar);
				pst.setString(1,dni);
				ResultSet rs = pst.executeQuery();
				while(rs.next()){ 
					
					Cuenta cuenta = new Cuenta();
					cuenta.setDNI(rs.getString(1));
					cuenta.setTipo(rs.getBoolean(2));
					cuenta.setFecha(rs.getDate(3));
					cuenta.setNcuenta(rs.getInt(4));
					cuenta.setCbu(rs.getString(5));
					cuenta.setSaldo(rs.getFloat(6));					
					lista.add(cuenta);
				}
			
			}
			
			catch(SQLException e)
			{

				try {
					conexion.rollback();
	
				} 
				catch (SQLException e1) {
				}
			}
			
			return lista;
			
		}
		
	public int cantidad(String dni){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		ResultSet rs;
		int cantidad = 0;
		PreparedStatement pst;
		Connection conexion = Conexion.getConexion().getSQLConexion();		
		try {
			pst = conexion.prepareStatement(contar);
			pst.setString(1, dni);
			rs = pst.executeQuery();

			if (rs.next()) {
				cantidad = rs.getInt(1);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return cantidad;
	}
	public float obtenerSaldo(int nc) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		ResultSet rs;
		float cantidad = 0;
		PreparedStatement pst;
		Connection conexion = Conexion.getConexion().getSQLConexion();		
		try {
			pst = conexion.prepareStatement(saldo);
			pst.setInt(1, nc);
			rs = pst.executeQuery();

			if (rs.next()) {
				cantidad = rs.getFloat(1);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return cantidad;
	}
		
}


