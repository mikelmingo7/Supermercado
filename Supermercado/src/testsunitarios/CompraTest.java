package testsunitarios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import clases.Cliente;
import clases.Compra;
import clases.Producto;

class CompraTest {

	
	
	Compra c= new Compra(142,"patata","123456789A",10.0,"2020-10-20");
	@Test
	public void testGetCodigoCompra() {
		assertEquals(142, c.getCodigoCompra()); 
	}
	@Test
	public void testGetNombrePorducto() {
		assertEquals("patata", c.getNombreProducto()); 
	}
	@Test
	public void testGetDniCliente() {
		assertEquals("123456789A", c.getDniCliente());
	}
	@Test
	public void testGetPrecio() {
		assertEquals(10.0, c.getPrecio());
	}
	@Test
	public void testGetFecha() {
		assertEquals("2020-10-20", c.getFecha());
	
	}
}


