package clases;

public class Cliente {
	protected String nombre;
	protected String apellido;
	protected String dni;
	protected Boolean socio;
		
	
	public Cliente(String nombre, String apellido, String dni, Boolean socio) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.socio = socio;
	}
	
	


	public String getNombre() {
		return nombre;
	}






	public String getApellido() {
		return apellido;
	}






	public String getDni() {
		return dni;
	}





	public Boolean getSocio() {
		return socio;
	}







//



}
