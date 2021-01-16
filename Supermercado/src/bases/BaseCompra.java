package bases;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import clases.Cliente;
import clases.Compra;
import clases.Producto;

public class BaseCompra {
	
	// conexión con la base de datos
	
	private static Logger logger = null;
	private static boolean LOGGING = true;
	
	private static Connection conexion = null;
	 
	private static void log( Level level, String msg, Throwable excepcion ) {
		if (!LOGGING) return;
		if (logger==null) {  // Logger por defecto local:
			logger = Logger.getLogger( BaseCompra.class.getName() );  // Nombre del logger - el de la clase
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
			conexion = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
			log( Level.INFO, "Conectada a la base de datos ", null );
		} catch (ClassNotFoundException e) {
			System.out.println("Error al intentar cargar el driver de la Base de Datos "); 
		} catch (SQLException e) {
			System.out.println("Error al conectar a la Base de Datos");
		}
	}
	public static void  disconnect() throws DBException {
		try {
			conexion.close();
			log( Level.INFO, "Cerrada la conexion con la base de datos", null );
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexion con la Base de Datos");
		}
	}
	public static void createCompraTable() throws DBException {
		// TODO Auto-generated method stub
		try (Statement s = conexion.createStatement()) {
			s.executeUpdate("CREATE TABLE IF NOT EXISTS TablaCompra (nombreProducto VARCHAR PRIMARY KEY, dniCliente VARCHAR, precio DEC, fecha DATE)");
			log( Level.INFO, "Tabla creada correctamente", null );
		} catch (SQLException e) {
			throw new DBException("Error creando la tabla 'TablaCompra' en la BD", e);
		
	}
	
	
  }
	public static void dropProductoTable() throws DBException {
		try (Statement s = conexion.createStatement()) {
			s.executeUpdate("DROP TABLE IF EXISTS TablaCompra");
			log( Level.INFO, "Borrado la tabla correctamente", null );
		} catch (SQLException e) {
			throw new DBException("Error borrando la tabla 'TablaCompra' en la BD", e); 
		}
}
	public static void storeCo(Compra co) throws DBException {
		try (PreparedStatement ps = conexion.prepareStatement("INSERT INTO TablaCompra (nombreProducto, dniCliente, precio, fecha) VALUES (? ,?, ?, ?)");
			Statement s = conexion.createStatement()) {
			ps.setString(1, co.getNombreProducto());
			ps.setString(2, co.getDniCliente());
			ps.setDouble(3, co.getPrecio());
			ps.setString(4, co.getFecha());
			
		
			ps.executeUpdate();
			
			log( Level.INFO, "Instertado la compra correctamente", null );
		} catch (SQLException e) {
			throw new DBException("No se pudo guardar el usuario en la BD", e);
		}
	}
	public Compra getCompra(String nombreProducto) throws DBException {
		try (PreparedStatement s = conexion.prepareStatement("SELECT nombreProducto, dniCliente, precio, fecha FROM TablaCompra WHERE nombreProducto = ?")) {
			s.setString(1, nombreProducto);
			
			ResultSet rs = s.executeQuery();

			if (rs.next()) {
				Compra c=new Compra();
				c.setNombreProducto(rs.getString("nombreProducto"));
				c.setDniCliente(rs.getString("dniCliente"));
				c.setPrecio(rs.getDouble("precio"));
				c.setFecha(rs.getString("fecha"));
			
				
				return c;
			} else {
				return new Compra();
				
			}
			
		} catch (SQLException | DateTimeParseException e) {
			throw new DBException("Error obteniendo la compra con nombreCliente " + nombreProducto, e);
		}
	}
	public ArrayList<String> getNombreProducto() throws DBException, SQLException{
		 PreparedStatement ps = conexion.prepareStatement("SELECT nombreProducto FROM TablaCompra");
		 ResultSet rs = ps.executeQuery();
		 ArrayList<String> listaNombresP=new ArrayList<String>();
		 while(rs.next()) {
			 listaNombresP.add(rs.getString("nombreProducto"));
		 }
		return listaNombresP; 
		
	}
	

	public void update(Compra c) throws DBException {
		try (PreparedStatement s = conexion.prepareStatement("UPDATE Compra SET nombreProducto=?, dniCliente=?, precio=?, fecha=?  WHERE nombreProducto=?")) {
			s.setString(1, c.getNombreProducto());
			s.setString(2, c.getDniCliente());
			s.setDouble(3, c.getPrecio());
			s.setString(4, c.getFecha());
		
			
			s.executeUpdate();
			log( Level.INFO, "Actualizado la compra especificado", null );
		} catch (SQLException e) {
			throw new DBException("No se pudo guardar la compra en la BD", e);
		}
	}
	public void delete(Compra c) throws DBException {
		try (PreparedStatement s = conexion.prepareStatement("DELETE FROM TablaCompra WHERE nombreProducto=?")) {
			s.setString(1, c.getNombreProducto());
			
			s.executeUpdate();
			log( Level.INFO, "Borrado la compra correctamente", null );
		} catch (SQLException e) {
			throw new DBException("No se pudo eliminar la compra con nombreProducto " + c.getNombreProducto(), e);	}
	}

		
}