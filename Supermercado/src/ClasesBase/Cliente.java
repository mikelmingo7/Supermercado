package ClasesBase;

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
	
	public Cliente() {
		super();
		this.nombre = "";
		this.apellido = "";
		this.dni = "";
		this.socio = false;
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





	public String getDni() {
		return dni;
	}





	public void setDni(String dni) {
		this.dni = dni;
	}





	public Boolean getSocio() {
		return socio;
	}





	public void setSocio(Boolean socio) {
		this.socio = socio;
	}





}
