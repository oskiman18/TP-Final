package NegocioImp;

import DAO.daoReporte;
import Modelos.Reporte;
import Negocio.NegReporte;
import daoImp.daoReporteImp;

public class NegReporteImp implements NegReporte{

	daoReporte ReportDao = new daoReporteImp();

	public Reporte listartodo() {
		
		return ReportDao.listartodo();
	}
	
	
}
