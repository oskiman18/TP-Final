package Modelos;


public class Usuario {
	
	private	String dni;
	private String cuil;
	private	String nombre;
	private	String apellido;
	private	String genero;
	private	String direccion;
	private	String localidad;
	private String provincia;
	private	String email;
	private String telefono;
	private String telefonoAlt;
    private String usuario;
	private String contraseña;
	private boolean administrador;
	private	boolean estado;


	public Usuario()
	{
		
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getCuil() {
		return cuil;
	}


	public void setCuil(String cuil) {
		this.cuil = cuil;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}



	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}
	
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	public String getUsuario() {
		return usuario;
	}
	
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	public String getContraseña() {
		return contraseña;
	}
	
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	public boolean getAdministrador() {
		return administrador;
	}
	
	
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	
	
	public boolean getEstado() {
		return estado;
	}
	
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public String getTelefonoAlt() {
		return telefonoAlt;
	}


	public void setTelefonoAlt(String telefonoalt) {
		this.telefonoAlt = telefonoalt;
	}


}

