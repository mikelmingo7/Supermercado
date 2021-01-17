package testsunitarios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import clases.Cliente;
import clases.Compra;
import clases.Producto;

class CompraTest {

	
	
	Compra co1= new Compra(142,"patata","123456789A",10.0,"2020-10-20"); 
	Compra co2= new Compra(121,"tomate platano carne","",5.0,""); 
	@Test
	public void testGetCodigoCompra() {
		assertEquals(142, co1.getCodigoCompra()); 
	}
	@Test
	public void testGetCodigoCompra2() {
		assertEquals(121, co2.getCodigoCompra()); 
	}
	@Test
	public void testGetNombreProducto1() {
		assertEquals("patata", co1.getNombreProducto()); 
	}
	@Test
	public void testGetNombreProducto2() {
		assertEquals("tomate platano carne", co2.getNombreProducto()); 
	}
	@Test
	public void testGetDniCliente1() {
		assertEquals("123456789A", co1.getDniCliente());
	}
	@Test
	public void testGetDniCliente2() {
		assertEquals("", co2.getDniCliente());
	}
	@Test
	public void testGetPrecio1() {
		assertEquals(10.0, co1.getPrecio());
	}
	@Test
	public void testGetPrecio2() {
		assertEquals(5.0, co2.getPrecio());
	}
	@Test
	public void testGetFecha1() {
		assertEquals("2020-10-20", co1.getFecha());
	
	}
	@Test
	public void testGetFecha2() {
		assertEquals("", co2.getFecha());
	
	}
}


