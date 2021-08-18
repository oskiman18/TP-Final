package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.daoProvincia;
import Modelos.Provincia;

public class daoProvinciaImp implements daoProvincia{
		public static final String listar="select * from provincias";
		
		
		
	public ArrayList<Provincia> listar(){
		ArrayList<Provincia> lista = new ArrayList<Provincia>();
	
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
			pst =conexion.prepareCall(listar);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){ 
				
				Provincia p = new Provincia();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				lista.add(p);
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
		
	};
}
