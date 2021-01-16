import java.util.ArrayList;

import bases.*;
import clases.Cliente;
import clases.Producto;
import clases.Trabajador;

public class Supermercado {

	protected String nombre;
	protected String direccion;
	protected ArrayList<Cliente> clientes;
	protected ArrayList<Trabajador> trabajadores;
	protected ArrayList<Producto> productos;
	protected ArrayList<Inventario> inventario;
	
	public Supermercado(String nombre, String direccion, ArrayList<Cliente> clientes,
			ArrayList<Trabajador> trabajadores, ArrayList<Producto> productos, ArrayList<Inventario> inventario) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.clientes = clientes;
		this.trabajadores = trabajadores;
		this.productos = productos;
		this.inventario = inventario;
	}
	
	public Supermercado() {
		super();
		this.nom-bre = "";
		this.direccion = "";
		this.clientes = null;
		this.trabajadores = null;
		this.productos = null;
		this.inventario = null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public ArrayList<Inventario> getInventario() {
		return inventario;
	}

	public void setInventario(ArrayList<Inventario> inventario) {
		this.inventario = inventario;
	}

	@Override
	public String toString() {
		return "Supermercado [nombre=" + nombre + ", direccion=" + direccion + ", clientes=" + clientes
				+ ", trabajadores=" + trabajadores + ", productos=" + productos + ", inventario=" + inventario + "]";
	}
	
	
	
}
