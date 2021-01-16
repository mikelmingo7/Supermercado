package clases;
import java.util.ArrayList;

public class Compra {
	protected ArrayList<Producto> productos;
	protected String dniCliente;
	protected int precio;
	protected String fecha;
	
	
	
	
	public Compra(ArrayList<Producto> productos, String dniCliente, int precio, String fecha) {
		super();
		this.productos = productos;
		this.dniCliente = dniCliente;
		this.precio = precio;
		this.fecha = fecha;
	}


	public Compra() {
		super();
		this.productos = null;
		this.dniCliente = "";
		this.precio = 0;
		this.fecha = "";
	}


	public ArrayList<Producto> getProductos() {
		return productos;
	}


	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}


	public String getDniCliente() {
		return dniCliente;
	}


	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
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
		return "Compra [productos=" + productos + ", dniCliente=" + dniCliente + ", precio=" + precio + ", fecha="
				+ fecha + "]";
	}
	




	


	
	

	
	
}
