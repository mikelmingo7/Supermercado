package testsunitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import clases.Cliente;

class ClienteTest {

	   
	Cliente  c = new Cliente("mikel","andoni","123456789A","si");
	    
	@Test
	public void testGetNombre() {
		assertEquals("mikel", c.getNombre()); 
	}
	@Test
	public void testGetApellido() {
		assertEquals("andoni", c.getApellido());
	}
	@Test
	public void testGetDni() {
		assertEquals("123456789A", c.getDni());
	}
	@Test
	public void testGetSocio() {
		assertEquals(true, c.getSocio());
	}

}
