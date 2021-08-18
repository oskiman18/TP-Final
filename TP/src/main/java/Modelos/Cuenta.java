package Modelos;

import java.time.LocalDate;
import java.util.Date;

public class Cuenta {

		private int Ncuenta;
		private String DNI;
		private String CBU;
		private Date fecha;
		private boolean tipo;
		private float saldo;
		
		public Cuenta()
		{
			
		}

		public String getDNI() {
			return DNI;
		}

		public void setDNI(String dni) {
			this.DNI = dni;
		}


		public String getCbu() {
			return CBU;
		}

		public void setCbu(String cbu) {
			this.CBU = cbu;
		}

		public Boolean getTipo() {
			return tipo;
		}

		public void setTipo(Boolean tipo) {
			this.tipo = tipo;
		}

		public float getSaldo() {
			return saldo;
		}

		public void setSaldo(float saldo) {
			this.saldo = saldo;
		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}

		public int getNcuenta() {
			return Ncuenta;
		}

		public void setNcuenta(int ncuenta) {
			Ncuenta = ncuenta;
		}
		
}


