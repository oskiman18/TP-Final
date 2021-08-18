package daoImp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.daoMovimiento;
import Modelos.Movimientos;


public class daoMovimientoImp implements daoMovimiento {

	public static final String qListar = "select * from movimientos where nco = ? or ncd = ?";
	public static final String qAgregar= "INSERT INTO `utnbank`.`movimientos`(`fecha`,`detalle`,`importe`,`tipo`,`NCO`,`NCD`) VALUES(now(),?,?,?,?,?)";
	public static final String qRestar = "update cuenta set saldo= saldo-? where ncuenta = ?";
	public static final String qSumar = "update cuenta set saldo= saldo+? where ncuenta = ?";
	
	public ArrayList<Movimientos> listar(int NC){
		ArrayList<Movimientos> lista = new ArrayList<Movimientos>();			
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
			pst = conexion.prepareStatement(qListar);
			pst.setInt(1,NC);
			pst.setInt(2, NC);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){ 
				
			Movimientos mov = new Movimientos();
			mov.setId(rs.getInt(1));
			mov.setFecha(rs.getDate(2));
			mov.setDetalle(rs.getString(3));
			mov.setImporte(rs.getFloat(4));
			mov.setTipo(rs.getBoolean(5));
			mov.setNCO(rs.getInt(6));
			mov.setNCD(rs.getInt(7));
			
			lista.add(mov);
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
	
	public boolean agregar(Movimientos m) {
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
			
			pst = conexion.prepareStatement(qAgregar);
			pst.setString(1, m.getDetalle());
			pst.setFloat(2, m.getImporte());
			pst.setBoolean(3, m.getTipo());
			pst.setInt(4, m.getNCO());
			pst.setInt(5, m.getNCD());
			entrada(m.getNCD(),m.getImporte());
			salida(m.getNCO(),m.getImporte());
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
	
	
	public boolean entrada(int ncd, float importe) {
		
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		
		PreparedStatement pst;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try {		
			pst = conexion.prepareStatement(qSumar);
			pst.setFloat(1, importe);
			pst.setInt(2, ncd);
			
			if(pst.executeUpdate() > 0){
				conexion.commit();

				result = true;
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		
		}
		return result;
	
	}
	
	public boolean salida(int nco,float importe) {
			
			boolean result = false;
			try {
				Class.forName("com.mysql.jdbc.Driver");} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
			
			PreparedStatement pst;
			Connection conexion = Conexion.getConexion().getSQLConexion();
			
			try {		
				pst = conexion.prepareStatement(qRestar);
				pst.setFloat(1, importe);
				pst.setInt(2, nco);
				
				if(pst.executeUpdate() > 0){
					conexion.commit();

					result = true;
				}
			}
			catch(Exception e) {
				
				e.printStackTrace();
				
			
			}
			return result;
		
		
	}
	
}
