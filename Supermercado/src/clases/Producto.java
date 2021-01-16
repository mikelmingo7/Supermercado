package clases;

public class Producto {

	protected String nombre;
	protected int codigo;
	protected String seccion;
	protected String marca; 
	protected double peso; 
	protected double precio;
	protected int stock;
	
	

	public Producto(String nombre, int codigo, String seccion, String marca, double peso, double precio, int stock) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.seccion = seccion;
		this.marca = marca;
		this.peso = peso;
		this.precio = precio;
		this.stock = stock;
	}
	public Producto() {
		super();
		this.nombre = "";
		this.codigo = 0;
		this.seccion = "";
		this.marca = "";
		this.peso = 0.0;
		this.precio = 0.0;
		this.stock = 0;
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
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", seccion=" + seccion + ", marca=" + marca
				+ ", peso=" + peso + ", precio=" + precio + ", stock=" + stock + "]";
	}
	

	
	
}
