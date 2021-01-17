package testsunitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import clases.Producto;

class ProductoTest {

      Producto p = new Producto("patata",1212,"1","2",12.1,1.1,10);
  
	@Test
	public void testGetNombre() {
		assertEquals("patata", p.getNombre());

	}
	@Test
	public void testGetCodigo() {
		assertEquals(1212, p.getCodigo());
	}
	@Test
	public void testGetSeccion() {
		assertEquals("1", p.getSeccion()); 
	}
	@Test
	public void testGetMarca() {
		assertEquals("2", p.getMarca());
	}
	@Test
	public void testGetPeso() {
		assertEquals(12.1, p.getPeso());
	}
	@Test
	public void testGetPrecio() {
		assertEquals(1.1, p.getPrecio()); 

	}
	@Test
	public void testGetStock() {
		assertEquals(10, p.getStock()); 
}
}