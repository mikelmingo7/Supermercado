package testsunitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import clases.Trabajador;

class TrabajadorTest {

	Trabajador t1= new Trabajador("Pepe","Jimenez Ramirez","123456789A",1500,"tarde","dependiente",1,"Si");
	Trabajador t2= new Trabajador("Carlos","Laucirica Bengoa","21234518S",1800,"","",10,"No");
	
	@Test
	public void testGetNombre1() {
		assertEquals("Pepe", t1.getNombre());
	}
	@Test
	public void testGetNombre2() {
		assertEquals("Carlos", t2.getNombre());
	}
	
	@Test
	public void testGetApellidos1() {
		assertEquals("Jimenez Ramirez", t1.getApellidos());
	}
	@Test
	public void testGetApellidos2() {
		assertEquals("Laucirica Bengoa", t2.getApellidos());
	}
	@Test
	public void testGetDni1() {
		assertEquals("123456789A", t1.getDni());
	}
	@Test
	public void testGetDni2() {
		assertEquals("21234518S", t2.getDni());
	}
	@Test
	public void testGetSalario1() {
		assertEquals(1500, t1.getSalario()); 
	}
	@Test
	public void testGetSalario2() {
		assertEquals(1800, t2.getSalario()); 
	}
	@Test
	public void testGetHorario1() {
		assertEquals("tarde", t1.getHorario());
	}
	@Test
	public void testGetHorario2() {
		assertEquals("", t2.getHorario());
	}
	@Test
	public void testGetPuesto1() {
		assertEquals("dependiente", t1.getPuesto()); 
	}
	@Test
	public void testGetPuesto2() {
		assertEquals("", t2.getPuesto()); 
	}
	@Test
	public void testGetHorasTrabajadas1() {
		assertEquals(1, t1.getHoras_trabajadas());
	}
	@Test
	public void testGetHorasTrabajadas2() {
		assertEquals(10, t2.getHoras_trabajadas());
	}
	@Test
	public void testGetDisponibilidad1() {
		assertEquals("Si", t1.getDisponibilidad());
	}
	@Test
	public void testGetDisponibilidad2() {
		assertEquals("No", t2.getDisponibilidad());
	}
}
