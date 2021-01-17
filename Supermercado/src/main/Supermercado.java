package main;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import bases.*;
import clases.Cliente;
import clases.Producto;
import clases.Trabajador;
import inicios.VentanaSeleccion;

public class Supermercado {

	private static final Logger LOGGER = Logger.getLogger(Supermercado.class.getName());
	private static VentanaSeleccion vs;

	protected String nombre;
	protected String direccion;
	protected ArrayList<Cliente> clientes;
	protected ArrayList<Trabajador> trabajadores;
	protected ArrayList<Producto> productos;
	
	public Supermercado(String nombre, String direccion, ArrayList<Cliente> clientes,
			ArrayList<Trabajador> trabajadores, ArrayList<Producto> productos) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.clientes = clientes;
		this.trabajadores = trabajadores;
		this.productos = productos;
	}
	
	public Supermercado() {
		super();
		this.nombre = "";
		this.direccion = "";
		this.clientes = null;
		this.trabajadores = null;
		this.productos = null;
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

	@Override
	public String toString() {
		return "Supermercado [nombre=" + nombre + ", direccion=" + direccion + ", clientes=" + clientes
				+ ", trabajadores=" + trabajadores + ", productos =" + productos + "]";
	}





	public static void main(String[] args) {
		
	try {
			FileHandler fH = new FileHandler("MyLogFile.log", 8096, 1, false);
			for (Handler handler : LOGGER.getHandlers()) {
				LOGGER.removeHandler(handler);
			}
			SimpleFormatter formatter = new SimpleFormatter();  
			fH.setFormatter(formatter);
			LOGGER.addHandler(fH);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	vs = new VentanaSeleccion(LOGGER);




	}
}
