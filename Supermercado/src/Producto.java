
public class Producto {

	protected String nombre;
	protected int codigo;
	protected String seccion;
	protected String marca; 
	protected int peso; 
	protected float precio;
	
	public Producto(String nombre, int codigo, String seccion, String marca, int peso, float precio) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.seccion = seccion;
		this.marca = marca;
		this.peso = peso;
		this.precio = precio;
	}

	public Producto() {
		super();
		this.nombre = "";
		this.codigo = 0;
		this.seccion = "";
		this.marca = "";
		this.peso = 0;
		this.precio = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", seccion=" + seccion + ", marca=" + marca
				+ ", peso=" + peso + ", precio=" + precio + "]";
	}
	
	
}
