package clases;
import java.util.ArrayList;

public class Compra {
	protected int codigoCompra;
	protected String nombreProducto;
	protected String dniCliente;
	protected Double precio;
	protected String fecha;
	
	
	
	
	public Compra(int codigoCompra, String nombreProducto, String dniCliente, Double precio, String fecha) {
		super();
		this.codigoCompra = codigoCompra;
		this.nombreProducto = nombreProducto;
		this.dniCliente = dniCliente;
		this.precio = precio; 
		this.fecha = fecha;
	}
	public Compra() {
		super();
		this.codigoCompra = 0;
		this.nombreProducto ="";
		this.dniCliente = "";
		this.precio = 0.0;
		this.fecha = "";
	}
	
	public int getCodigoCompra() {
		return codigoCompra;
	}
	public void setCodigoCompra(int codigoCompra) {
		this.codigoCompra = codigoCompra;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return  "" + codigoCompra;
	}
	

	
	
	
	
	



	




	


	
	

	
	
}
