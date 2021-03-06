package bases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import clases.Trabajador;

public class BaseTrabajador {
private static Connection con = null;
	 
	
private static Logger logger = null;
private static boolean LOGGING = true;	

private static void log( Level level, String msg, Throwable excepcion ) {
	if (!LOGGING) return;
	if (logger==null) {  // Logger por defecto local:
		logger = Logger.getLogger( BaseTrabajador.class.getName() );  // Nombre del logger - el de la clase
		logger.setLevel( Level.ALL );  // Loguea todos los niveles
	}
	if (excepcion==null)
		logger.log( level, msg );
	else 
		logger.log( level, msg, excepcion );
}
	
	public static void connect(String dbPath) throws DBException {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:" + dbPath); 
			log( Level.INFO, "Conectada a la base de datos ", null );
		} catch (ClassNotFoundException e) {
			System.out.println("Error al intentar cargar el driver de la Base de Datos "); 
		} catch (SQLException e) {
			System.out.println("Error al conectar a la Base de Datos");
		}
	}
	public static void  disconnect() throws DBException {
		try {
			con.close();
			log( Level.INFO, "Cerrada la conexion con la base de datos", null );
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexion con la Base de Datos");
		}
	}
	public static void createTrabajadorTable() throws DBException {
		// TODO Auto-generated method stub
		try (Statement s = con.createStatement()) {
			s.executeUpdate("CREATE TABLE IF NOT EXISTS TablaTrabajador (dni VARCHAR PRIMARY KEY, nombre VARCHAR, apellidos VARCHAR, salario INTEGER, horario STRING, puesto STRING, horas_trabajadas INTEGER, disponibilidad STRING )");
		} catch (SQLException e) {
			throw new DBException("Error creando la tabla 'TablaTrabajador' en la BD", e);
		}
	}
	public static void dropTrabajadorTable() throws DBException {
		try (Statement s = con.createStatement()) {
			s.executeUpdate("DROP TABLE IF EXISTS TabalaTrabajador");
			log( Level.INFO, "Borrado la tabla correctamente", null );
		} catch (SQLException e) {
			throw new DBException("Error borrando la tabla 'TablaTrabajador' en la BD", e); 
		}
	}
	public static void storeT(Trabajador t) throws DBException {
		try (PreparedStatement ps = con.prepareStatement("INSERT INTO TablaTrabajador (dni,nombre,apellidos,salario,horario,puesto,horas_trabajadas,disponibilidad) VALUES (? ,?, ?, ?, ?, ?, ?, ?)");
			Statement s = con.createStatement()) {
			
			ps.setString(1, t.getDni());
			ps.setString(2, t.getNombre());
			ps.setString(3, t.getApellidos());
			ps.setInt(4, t.getSalario());
			ps.setString(5, t.getHorario());
			ps.setString(6, t.getPuesto());
			ps.setInt(7,t.getHoras_trabajadas());
			ps.setString(8, t.getDisponibilidad());
			
			
			;
					
		
			ps.executeUpdate();
			
			log( Level.INFO, "Instertado el trabajador correctamente", null );
			
		} catch (SQLException e) {
			throw new DBException("No se pudo guardar el trabajador en la BD", e);
		}
	}
	public Trabajador getTrabajador(String dni) throws DBException {
		try (PreparedStatement s = con.prepareStatement("SELECT dni, nombre, apellidos, salario, horario, puesto, horas_trabajadas, disponibilidad FROM TablaTrabajador WHERE dni = ?")) {
			s.setString(1, dni);
			
			ResultSet rs = s.executeQuery();

			if (rs.next()) {
				Trabajador t=new Trabajador();
				t.setDni(rs.getString("dni"));
				t.setNombre(rs.getString("nombre"));
				t.setApellidos(rs.getString("apellidos"));
				t.setSalario(rs.getInt("salario"));
				t.setHorario(rs.getString("horario"));
				t.setPuesto(rs.getString("puesto"));
				t.setHoras_trabajadas(rs.getInt("horas_trabajadas"));
				t.setDisponibilidad(rs.getString("disponibilidad"));
				
				return t; 
			} else {
				return new Trabajador();
			}
		} catch (SQLException | DateTimeParseException e) {
			throw new DBException("Error obteniendo el trabajador con dni " + dni, e);
		}
	}
	public ArrayList<String> getDni() throws DBException, SQLException{
		 PreparedStatement ps = con.prepareStatement("SELECT dni FROM TablaTrabajador");
		 ResultSet rs = ps.executeQuery();
		 ArrayList<String> listaDnis=new ArrayList<String>();
		 while(rs.next()) {
			 listaDnis.add(rs.getString("dni"));
		 }
		return listaDnis; 
		
	}
	public void update(Trabajador t) throws DBException {
		try (PreparedStatement s = con.prepareStatement("UPDATE TablaTrabajador SET nombre=?, apellidos=?, salario=?, horario=?, puesto=?, horas_trabajadas=?, disponibilidad=?  WHERE dni=?")) {
			
			s.setString(1, t.getNombre());
			s.setString(2, t.getApellidos());
			s.setInt(3, t.getSalario());
			s.setString(4, t.getHorario());
			s.setString(5, t.getPuesto());
			s.setInt(6, t.getHoras_trabajadas());
			s.setString(7, t.getDisponibilidad());
			s.setString(8, t.getDni());
			
			s.executeUpdate();
			log( Level.INFO, "Actualizado el trabajador correctamente", null );
		} catch (SQLException e) {
			throw new DBException("No se pudo actualizar el trabajador en la BD", e);
		}
	}
	public void delete(Trabajador t) throws DBException {
		try (PreparedStatement s = con.prepareStatement("DELETE FROM TablaTrabajador WHERE dni=?")) {
			s.setString(1, t.getDni());
			
			s.executeUpdate();
			log( Level.INFO, "Borrado el trabajador correctamente", null );
		} catch (SQLException e) {
			throw new DBException("No se pudo eliminar el trabajador con id " + t.getDni(), e);	}
	}
}
