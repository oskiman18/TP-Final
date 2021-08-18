package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.daoReporte;
import Modelos.Reporte;

public class daoReporteImp implements daoReporte{
	
	public static final String listar="call sp_report()";
	
	
	
	public Reporte listartodo() {
			
		Reporte reporte = new Reporte();
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
					
					reporte.setUserA(rs.getInt(1));
					reporte.setUserI(rs.getInt(2));
					reporte.setTtransferencias(rs.getInt(3));
					reporte.setSaldoTotal(rs.getFloat(4));
					reporte.setCuentasTotales(rs.getInt(5));
					reporte.setCuentascorrientes(rs.getInt(6));
					reporte.setCajasAhorro(rs.getInt(7));
					reporte.setPMTransferencias(rs.getFloat(8));
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
			
			return reporte;
			
		}
		
	
	
	
	

}
