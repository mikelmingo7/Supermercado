package clases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ClienteTest {

	private Cliente c;
	
	 @Before
	    public void setUp() {
	        c = new Cliente("Pepe","Jimenez","123456789A",true);
	    }
	@Test
	public void testGetNombre() {
		assertEquals("Pepe", c.getNombre());
	}
	@Test
	public void testGetApellido() {
		assertEquals("Jimenez", c.getApellido());
	}

}
