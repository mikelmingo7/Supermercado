package clases;
import java.util.ArrayList;

public class Compra {

	protected int precio;
	protected String fecha;
	
	
	public Compra(Cliente cliente, int precio, String fecha,
			Boolean descuento) {
		super();
		this.precio = precio;
		this.fecha = fecha;
	
	}
	
	public Compra() {
		super();
		this.precio = 0;
		this.fecha = "";
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
		return "Compra [precio=" + precio + ", fecha=" + fecha + "]";
	}


	
	

	
	
}
