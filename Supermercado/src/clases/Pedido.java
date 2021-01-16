package clases;

public class Pedido extends Compra{
	protected String direccion;

	public Pedido(String nombreProducto, String dniCliente, Double precio, String fecha, String direccion) {
		super(nombreProducto, dniCliente, precio, fecha);
		this.direccion = direccion;
	}
	public Pedido() {
		super();
		this.direccion = "";
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Pedido [direccion=" + direccion + ", nombreProducto=" + nombreProducto + ", dniCliente=" + dniCliente
				+ ", precio=" + precio + ", fecha=" + fecha + "]";
	}
	
}
