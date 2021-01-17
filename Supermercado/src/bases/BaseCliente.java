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

import clases.Cliente;

public class BaseCliente {
private static Connection con = null;
	 
	
private static Logger logger = null;
private static boolean LOGGING = true;	

private static void log( Level level, String msg, Throwable excepcion ) {
	if (!LOGGING) return;
	if (logger==null) {  // Logger por defecto local:
		logger = Logger.getLogger( BaseCliente.class.getName() );  // Nombre del logger - el de la clase
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
			System.out.println("Error al cerrar la conexi�n con la Base de Datos");
		}
	}
	public static void createClienteTable() throws DBException {
		// TODO Auto-generated method stub
		try (Statement s = con.createStatement()) {
			s.executeUpdate("CREATE TABLE IF NOT EXISTS TablaCliente (dni VARCHAR PRIMARY KEY, nombre VARCHAR, apellido VARCHAR, socio VARCHAR)");
		} catch (SQLException e) {
			throw new DBException("Error creando la tabla 'Cliente' en la BD", e);
		}
	}
	public static void dropClienteTable() throws DBException {
		try (Statement s = con.createStatement()) {
			s.executeUpdate("DROP TABLE IF EXISTS Cliente");
			log( Level.INFO, "Borrado la tabla correctamente", null );
		} catch (SQLException e) {  
			throw new DBException("Error borrando la tabla 'Cliente' en la BD", e); 
		}
	}
	public static void storeC(Cliente c) throws DBException {
		try (PreparedStatement ps = con.prepareStatement("INSERT INTO TablaCliente (dni,nombre,apellido,socio) VALUES (? ,?, ?, ?)");
			Statement s = con.createStatement()) {
			
			ps.setString(1, c.getDni());
			ps.setString(2, c.getNombre());
			ps.setString(3, c.getApellido());
			ps.setString(4, c.getSocio());
					
		
			ps.executeUpdate();
			
			log( Level.INFO, "Instertado el cliente correctamente", null );
			
		} catch (SQLException e) {
			throw new DBException("No se pudo guardar el usuario en la BD", e);
		}
	}
	public Cliente getCliente(String dni) throws DBException {
		try (PreparedStatement s = con.prepareStatement("SELECT dni,nombre,apellido,socio FROM TablaCliente WHERE dni = ?")) {
			s.setString(1, dni);
			
			ResultSet rs = s.executeQuery();

			if (rs.next()) {
				Cliente c = new Cliente(); 
				c.setDni(rs.getString("dni"));
				c.setNombre(rs.getString("nombre"));
				c.setApellido(rs.getString("apellido"));
				c.setSocio(rs.getString("socio"));
				
				return c;
			} else {
				return new Cliente();
			}
		} catch (SQLException | DateTimeParseException e) {
			throw new DBException("Error obteniendo el cliente con dni " + dni, e);
		}
	}
	public ArrayList<String> getDni() throws DBException, SQLException{
		 PreparedStatement ps = con.prepareStatement("SELECT dni FROM TablaCliente");
		 ResultSet rs = ps.executeQuery();
		 ArrayList<String> listaDnis=new ArrayList<String>();
		 while(rs.next()) {
			 listaDnis.add(rs.getString("dni"));
		 }
		return listaDnis; 
		
	}
	public void update(Cliente c) throws DBException {
		try (PreparedStatement s = con.prepareStatement("UPDATE TablaCliente SET  nombre=?, apellido=?, socio=?  WHERE dni=?")) {
			s.setString(1, c.getDni());
			s.setString(2, c.getNombre());
			s.setString(3, c.getApellido());
			s.setString(4, c.getSocio());
			
			
			
			s.executeUpdate();
			log( Level.INFO, "Actualizado el cliente correctamente", null );
		} catch (SQLException e) {
			throw new DBException("No se pudo guardar el cliente en la BD", e);
		}
	}
	public void delete(Cliente c) throws DBException {
		try (PreparedStatement s = con.prepareStatement("DELETE FROM TablaCliente WHERE dni=?")) {
			s.setString(1, c.getDni());
			
			s.executeUpdate();
			log( Level.INFO, "Borrado el cliente correctamente", null );
		} catch (SQLException e) {
			throw new DBException("No se pudo eliminar el usuario con id " + c.getDni(), e);	}
	}
}
