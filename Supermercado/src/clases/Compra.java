package clases;
import java.util.ArrayList;

public class Compra {

	protected Cliente cliente;
	protected ArrayList<Producto> productosComprados;
	protected int precio;
	protected String fecha;
	protected Boolean descuento;
	
	public Compra(Cliente cliente, ArrayList<Producto> productosComprados, int precio, String fecha,
			Boolean descuento) {
		super();
		this.cliente = cliente;
		this.productosComprados = productosComprados;
		this.precio = precio;
		this.fecha = fecha;
		this.descuento = descuento;
	}
	


	public Cliente getCliente() {
		return cliente;
	}



	public ArrayList<Producto> getProductosComprados() {
		return productosComprados;
	}



	public int getPrecio() {
		return precio;
	}



	public String getFecha() {
		return fecha;
	}



	public Boolean getDescuento() {
		return descuento;
	}




	

	
	
}
