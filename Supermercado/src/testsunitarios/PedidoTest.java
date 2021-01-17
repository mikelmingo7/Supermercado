package testsunitarios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import clases.Cliente; 
import clases.Compra;
import clases.Pedido;
import clases.Producto;

class PedidoTest {

	
	
	Pedido p1= new Pedido(142,"patata","123456789A",10.0,"2020-10-20","Loiola-25");
	Pedido p2= new Pedido(1576,"manzana arroz lasaña","",22.40,"","");
	@Test
	public void testGetCodigoCompra1() {
		assertEquals(142, p1.getCodigoCompra()); 
	}
	@Test
	public void testGetCodigoCompra2() {
		assertEquals(1576, p2.getCodigoCompra()); 
	}
	@Test
	public void testGetNombrePorducto1() {
		assertEquals("patata", p1.getNombreProducto());  
	}
	@Test
	public void testGetNombrePorducto2() {
		assertEquals("manzana arroz lasaña", p2.getNombreProducto());  
	}
	@Test
	public void testGetDniCliente1() {
		assertEquals("123456789A", p1.getDniCliente());
	}
	@Test
	public void testGetDniCliente2() {
		assertEquals("", p2.getDniCliente());
	}
	@Test
	public void testGetPrecio1() {
		assertEquals(10.0, p1.getPrecio());
	}
	@Test
	public void testGetPrecio2() {
		assertEquals(22.40, p2.getPrecio());
	}
	@Test
	public void testGetFecha1() {
		assertEquals("2020-10-20", p1.getFecha());
	
	}
	@Test
	public void testGetFecha2() {
		assertEquals("", p2.getFecha());
	
	}
	@Test
	public void testGetDireccion1() {
		assertEquals("Loiola-25", p1.getDireccion());
	
	}
	@Test
	public void testGetDireccion2() {
		assertEquals("", p2.getDireccion());
	
	}
}
