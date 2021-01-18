package clases;

public class Pedido extends Compra{
	protected String direccion;

	public Pedido(int codigoCompra, String nombreProducto, String dniCliente, Double precio, String fecha,
			String direccion) {
		super(codigoCompra, nombreProducto, dniCliente, precio, fecha);
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
		return "" + codigoCompra;
	}
	
	
	

	
	
}
