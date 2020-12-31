package testsunitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import clases.Trabajador;

class TrabajadorTest {

	Trabajador t= new Trabajador("Pepe","Jimenez Ramirez","123456789A",1000,"tarde","dependiente",1,true);
	
	@Test
	public void testGetNombre() {
		assertEquals("Pepe", t.getNombre());
	}
	@Test
	public void testGetApellido() {
		assertEquals("Jimenez Ramirez", t.getApellidos());
	}
	@Test
	public void testGetDni() {
		assertEquals("123456789A", t.getDni());
	}
	@Test
	public void testGetSalario() {
		assertEquals(1000, t.getSalario()); 
	}
	@Test
	public void testGetHorario() {
		assertEquals("tarde", t.getHorario());
	}
	@Test
	public void testGetPuesto() {
		assertEquals("dependiente", t.getPuesto()); 
	}
	@Test
	public void testGetHorasTrabajadas() {
		assertEquals(1, t.getHoras_trabajadas());
	}
	@Test
	public void testGetDisponibilidad() {
		assertEquals(true, t.getDisponibilidad());
	}
}
