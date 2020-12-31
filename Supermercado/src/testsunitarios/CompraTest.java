package testsunitarios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import clases.Cliente;
import clases.Compra;
import clases.Producto;

class CompraTest {

	Cliente  cl = new Cliente("mikel","andoni","123456789A",true);
	ArrayList<Producto> l1 = new ArrayList<Producto>();
	
	Compra c= new Compra(cl,l1,11,"2020-10-20",false);
	@Test
	public void testGetCliente() {
		assertEquals(cl, c.getCliente()); 
	}
	@Test
	public void testGetProductosComprados() {
		assertEquals(l1, c.getProductosComprados()); 
	}
	@Test
	public void testGetPrecio() {
		assertEquals(11, c.getPrecio());
	}
	@Test
	public void testGetDisponibilidad() {
		assertEquals("2020-10-20", c.getFecha());
	}
	@Test
	public void testGetDescuento() {
		assertEquals(false, c.getDescuento());
	}

}
