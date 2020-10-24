import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductoTest {

	@Test
	public void testGetNombre() {
		Producto p=new Producto("patata",110,"verdura","",4,12);
		assertEquals("patata", p.getNombre());
	}

		
}
