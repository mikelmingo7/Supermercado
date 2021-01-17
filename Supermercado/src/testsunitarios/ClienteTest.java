package testsunitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import clases.Cliente;

class ClienteTest {

	   
	Cliente  c1 = new Cliente("mikel","andoni","123456789A","si");
	Cliente  c2= new Cliente("","","","no");
	
	    
	@Test
	public void testGetNombre1() {
		assertEquals("mikel", c1.getNombre());
		
	}
	@Test
	public void testGetNombre2() {
		assertEquals("", c2.getNombre());
		
	}
	@Test
	public void testGetApellido1() {
		assertEquals("andoni", c1.getApellido());
	}
	@Test
	public void testGetApellido2() {
		assertEquals("", c2.getApellido());
	}
	@Test
	public void testGetDni1() {
		assertEquals("123456789A", c1.getDni());
	}
	@Test
	public void testGetDni2() {
		assertEquals("", c2.getDni());
	}

	@Test
	public void testGetSocio1() {
		assertEquals("si", c1.getSocio());
	}
	@Test
	public void testGetSocio2() {
		assertEquals("no", c2.getSocio()); 
	}

}
