package clases;

public class Producto {

	protected String nombre;
	protected int codigo;
	protected String seccion;
	protected String marca; 
	protected double peso; 
	protected double precio;
	
	public Producto(String nombre, int codigo, String seccion, String marca, double peso, double precio) {
		super(); 
		this.nombre = nombre;
		this.codigo = codigo;
		this.seccion = seccion;
		this.marca = marca;
		this.peso = peso;
		this.precio = precio;
	}



	public String getNombre() {
		return nombre;
	}



	public int getCodigo() {
		return codigo;
	}



	public String getSeccion() {
		return seccion;
	}



	public String getMarca() {
		return marca;
	}



	public double getPeso() {
		return peso;
	}



	public double getPrecio() {
		return precio;
	}



	
	
}
