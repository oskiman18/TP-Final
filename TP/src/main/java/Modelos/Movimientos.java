package Modelos;

import java.util.Date;

public class Movimientos {
	private int id;
	private Date fecha;
	private String detalle;
	private boolean tipo;
	private int NCO;
	private int NCD;
	private float importe;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public boolean getTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	public int getNCO() {
		return NCO;
	}
	public void setNCO(int nCO) {
		NCO = nCO;
	}
	public int getNCD() {
		return NCD;
	}
	public void setNCD(int nCD) {
		NCD = nCD;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}

}
	
 


