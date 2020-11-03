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
	
	public Compra() {
		super();
		this.cliente = null;
		this.productosComprados = null;
		this.precio = 0;
		this.fecha = "";
		this.descuento = false;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Producto> getProductosComprados() {
		return productosComprados;
	}

	public void setProductosComprados(ArrayList<Producto> productosComprados) {
		this.productosComprados = productosComprados;
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

	public Boolean getDescuento() {
		return descuento;
	}

	public void setDescuento(Boolean descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "Compra [cliente=" + cliente + ", productosComprados=" + productosComprados + ", precio=" + precio
				+ ", fecha=" + fecha + ", descuento=" + descuento + "]";
	}
	

	
	
}
