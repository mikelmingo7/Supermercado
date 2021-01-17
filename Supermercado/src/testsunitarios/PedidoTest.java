package testsunitarios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import clases.Cliente;
import clases.Compra;
import clases.Pedido;
import clases.Producto;

class PedidoTest {

	
	
	Pedido p= new Pedido(142,"patata","123456789A",10.0,"2020-10-20","Loiola-25");
	@Test
	public void testGetCodigoCompra() {
		assertEquals(142, p.getCodigoCompra()); 
	}
	@Test
	public void testGetNombrePorducto() {
		assertEquals("patata", p.getNombreProducto()); 
	}
	@Test
	public void testGetDniCliente() {
		assertEquals("123456789A", p.getDniCliente());
	}
	@Test
	public void testGetPrecio() {
		assertEquals(10.0, p.getPrecio());
	}
	@Test
	public void testGetFecha() {
		assertEquals("2020-10-20", p.getFecha());
	
	}
	@Test
	public void testGetDireccion() {
		assertEquals("Loiola-25", p.getDireccion());
	
	}
}
