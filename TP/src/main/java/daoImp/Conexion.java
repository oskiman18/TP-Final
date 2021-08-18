package daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion 
{
	public static Conexion estado;
	private Connection connection;
	String host ="jdbc:mysql://localhost:3306/" ;
	String user = "root";
 	String pass = "root";
	String dbName = "utnbank"; 



	private Conexion(){
		try{
			
			this.connection = DriverManager.getConnection(host+dbName,user,pass);
			this.connection.setAutoCommit(false);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
		
	
	
	public static Conexion getConexion()   
	{								
		if(estado == null)
		{
			estado = new Conexion();
		}
		return estado;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		estado = null;
	}
}
