package clases;
import java.util.ArrayList;

public class Compra {
	protected String nombreProducto;
	protected String dniCliente;
	protected Double precio;
	protected String fecha;
	public Compra(String nombreProducto, String dniCliente, Double precio, String fecha) {
		super();
		this.nombreProducto = nombreProducto;
		this.dniCliente = dniCliente;
		this.precio = precio;
		this.fecha = fecha;
	}
	public Compra() {
		super();
		this.nombreProducto = "";
		this.dniCliente = "";
		this.precio = 0.0;
		this.fecha = "";
	
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
		return "Compra [nombreProducto=" + nombreProducto + ", dniCliente=" + dniCliente + ", precio=" + precio
				+ ", fecha=" + fecha + "]";
	}
	
	
	
	
	
	



	




	


	
	

	
	
}
