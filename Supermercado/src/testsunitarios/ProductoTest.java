package testsunitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import clases.Producto;

class ProductoTest {

      Producto p1 = new Producto("kiwi",1212,"1","FV",1.5,2.5,10);
      Producto p2= new Producto("naranja",412,"1","GHS",1.1,2.1,5);
      Producto p3 = new Producto("pepinillos",001,"3","Calvis",12.1,1.1,0);
  
	@Test
	public void testGetNombre1() {
		assertEquals("kiwi", p1.getNombre());

	}
	@Test
	public void testGetNombre2() {
		assertEquals("naranja", p2.getNombre());

	}
	@Test
	public void testGetNombre3() {
		assertEquals("pepinillos", p3.getNombre());

	}
	@Test
	public void testGetCodigo1() {
		assertEquals(1212, p1.getCodigo());
	}
	@Test
	public void testGetCodigo2() {
		assertEquals(412, p2.getCodigo());
	}
	@Test
	public void testGetCodigo3() {
		assertEquals(001, p3.getCodigo());
	}
	@Test
	public void testGetSeccion1() {
		assertEquals("1", p1.getSeccion()); 
	}
	@Test
	public void testGetSeccion2() {
		assertEquals("1", p2.getSeccion()); 
	}
	@Test
	public void testGetSeccion3() {
		assertEquals("3", p3.getSeccion()); 
	}
	@Test
	public void testGetMarca1() {
		assertEquals("FV", p1.getMarca());
	}
	@Test
	public void testGetMarca2() {
		assertEquals("GHS", p2.getMarca());
	}
	@Test
	public void testGetMarca3() {
		assertEquals("Calvis", p3.getMarca());
	}
	@Test
	public void testGetPeso1() {
		assertEquals(1.5, p1.getPeso());
	}
	@Test
	public void testGetPeso2() {
		assertEquals(1.1, p2.getPeso());
	}
	@Test
	public void testGetPeso3() {
		assertEquals(12.1, p3.getPeso());
	}
	@Test
	public void testGetPrecio1() {
		assertEquals(2.5, p1.getPrecio()); 

	}
	@Test
	public void testGetPrecio2() {
		assertEquals(2.1, p2.getPrecio()); 

	}
	@Test
	public void testGetPrecio3() {
		assertEquals(1.1, p3.getPrecio()); 

	}
	@Test
	public void testGetStock1() {
		assertEquals(10, p1.getStock()); 
}
	@Test
	public void testGetStock2() {
		assertEquals(5, p2.getStock()); 
}
	@Test
	public void testGetStock3() {
		assertEquals(0, p3.getStock()); 
}
}