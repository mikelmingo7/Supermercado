package clases;

public class Trabajador {

		protected String nombre;
		protected String apellidos;
		protected String dni;
		protected Integer salario;
		protected String horario;
		protected String puesto;
		protected Integer horas_trabajadas;
		protected Boolean disponibilidad;
		
		public Trabajador(String nombre, String apellidos, String dni, Integer salario, String horario, String puesto,
				Integer horas_trabajadas, Boolean disponibilidad) {
			super();
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.dni = dni;
			this.salario = salario;
			this.horario = horario;
			this.puesto = puesto;
			this.horas_trabajadas = horas_trabajadas;
			this.disponibilidad = disponibilidad;
		}
		
	

		public String getNombre() {
			return nombre;
		}

		

		public String getApellidos() {
			return apellidos;
		}

	

		public String getDni() {
			return dni;
		}

	
		public Integer getSalario() {
			return salario;
		}



		public String getHorario() {
			return horario;
		}



		public String getPuesto() {
			return puesto;
		}



		public Integer getHoras_trabajadas() {
			return horas_trabajadas;
		}



		public Boolean getDisponibilidad() {
			return disponibilidad;
		}



	
		
	//
		
	

}
