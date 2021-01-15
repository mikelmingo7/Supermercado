package clases;

public class Trabajador {

		protected String nombre;
		protected String apellidos;
		protected String dni;
		protected Integer salario;
		protected String horario;
		protected String puesto;
		protected Integer horas_trabajadas;
		protected String disponibilidad;
		
		public Trabajador(String nombre, String apellidos, String dni, Integer salario, String horario, String puesto,
				Integer horas_trabajadas, String disponibilidad) {
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
		
		public Trabajador() {
			super();
			this.nombre = "";
			this.apellidos = "";
			this.dni = "";
			this.salario = 0;
			this.horario = "";
			this.puesto = "";
			this.horas_trabajadas = 0;
			this.disponibilidad = "";
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public Integer getSalario() {
			return salario;
		}

		public void setSalario(Integer salario) {
			this.salario = salario;
		}

		public String getHorario() {
			return horario;
		}

		public void setHorario(String horario) {
			this.horario = horario;
		}

		public String getPuesto() {
			return puesto;
		}

		public void setPuesto(String puesto) {
			this.puesto = puesto;
		}

		public Integer getHoras_trabajadas() {
			return horas_trabajadas;
		}

		public void setHoras_trabajadas(Integer horas_trabajadas) {
			this.horas_trabajadas = horas_trabajadas;
		}

		public String getDisponibilidad() {
			return disponibilidad;
		}

		public void setDisponibilidad(String disponibilidad) {
			this.disponibilidad = disponibilidad;
		}

		@Override
		public String toString() {
			return "Trabajador [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", salario=" + salario
					+ ", horario=" + horario + ", puesto=" + puesto + ", horas_trabajadas=" + horas_trabajadas
					+ ", disponibilidad=" + disponibilidad + "]";
		}
		
	//
		
	

}
