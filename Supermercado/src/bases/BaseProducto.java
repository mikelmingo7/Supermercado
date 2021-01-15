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
import clases.Producto;

public class BaseProducto {
	
	// conexión con la base de datos
	
	private static Logger logger = null;
	private static boolean LOGGING = true;
	
	private static Connection conexion = null;
	 
	private static void log( Level level, String msg, Throwable excepcion ) {
		if (!LOGGING) return;
		if (logger==null) {  // Logger por defecto local:
			logger = Logger.getLogger( BaseProducto.class.getName() );  // Nombre del logger - el de la clase
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
			System.out.println("Error al cerrar la conexi�n con la Base de Datos");
		}
	}
	public static void createProductoTable() throws DBException {
		// TODO Auto-generated method stub
		try (Statement s = conexion.createStatement()) {
			s.executeUpdate("CREATE TABLE IF NOT EXISTS Producto (codigo INTEGER PRIMARY KEY , nombre VARCHAR, seccion VARCHAR, marca VARCHAR, peso DEC, precio DEC)");
			log( Level.INFO, "Tabla creada correctamente", null );
		} catch (SQLException e) {
			throw new DBException("Error creando la tabla 'Producto' en la BD", e);
		
	}
	
	
  }
	public static void dropProductoTable() throws DBException {
		try (Statement s = conexion.createStatement()) {
			s.executeUpdate("DROP TABLE IF EXISTS Producto");
			log( Level.INFO, "Borrado la tabla correctamente", null );
		} catch (SQLException e) {
			throw new DBException("Error borrando la tabla 'user' en la BD", e); 
		}
}
	public static void storeP(Producto p) throws DBException {
		try (PreparedStatement ps = conexion.prepareStatement("INSERT INTO Producto (codigo,nombre,peso,precio,marca,seccion) VALUES (? ,?, ?, ?, ?, ?)");
			Statement s = conexion.createStatement()) {
			ps.setInt(1, p.getCodigo());
			ps.setString(2, p.getNombre());
			ps.setDouble(3, p.getPeso());
			ps.setDouble(4, p.getPrecio());
			ps.setString(5, p.getMarca());
			ps.setString(6, p.getSeccion());
			
			
			
			ps.executeUpdate();
			
			log( Level.INFO, "Instertado el producto correctamente", null );
		} catch (SQLException e) {
			throw new DBException("No se pudo guardar el usuario en la BD", e);
		}
	}
	public Producto getProducto(int codigo) throws DBException {
		try (PreparedStatement s = conexion.prepareStatement("SELECT codigo,nombre,peso,precio,marca,seccion FROM Producto WHERE codigo = ?")) {
			s.setInt(1, codigo);
			
			ResultSet rs = s.executeQuery();

			if (rs.next()) {
				Producto p = new Producto(); 
				p.setCodigo(rs.getInt("codigo"));
				p.setNombre(rs.getString("nombre"));
				p.setPeso(rs.getFloat("peso"));
				p.setPrecio(rs.getFloat("precio"));
				p.setMarca(rs.getString("marca"));
				p.setSeccion(rs.getString("seccion"));
				
				return p;
			} else {
				return new Producto();
				
			}
			
		} catch (SQLException | DateTimeParseException e) {
			throw new DBException("Error obteniendo el producto con codigo " + codigo, e);
		}
	}
	public ArrayList<Integer> getCodigo() throws DBException, SQLException{
		 PreparedStatement ps = conexion.prepareStatement("SELECT codigo FROM Producto");
		 ResultSet rs = ps.executeQuery();
		 ArrayList<Integer> listaCodigos=new ArrayList<Integer>();
		 while(rs.next()) {
			 listaCodigos.add(rs.getInt("codigo"));
		 }
		return listaCodigos; 
		
	}
	

	public void update(Producto p) throws DBException {
		try (PreparedStatement s = conexion.prepareStatement("UPDATE Producto SET nombre=?, peso=?, precio=?, marca=?, seccion=?  WHERE codigo=?")) {
			s.setString(1, p.getNombre());
			s.setDouble(2, p.getPeso());
			s.setDouble(3, p.getPrecio());
			s.setString(4, p.getMarca());
			s.setString(5, p.getSeccion());
			s.setInt(6, p.getCodigo());
			
			s.executeUpdate();
			log( Level.INFO, "Actualizado el producto especificado", null );
		} catch (SQLException e) {
			throw new DBException("No se pudo guardar el producto en la BD", e);
		}
	}
	public void delete(Producto p) throws DBException {
		try (PreparedStatement s = conexion.prepareStatement("DELETE FROM Producto WHERE codigo=?")) {
			s.setInt(1, p.getCodigo());
			
			s.executeUpdate();
			log( Level.INFO, "Borrado el producto correctamente", null );
		} catch (SQLException e) {
			throw new DBException("No se pudo eliminar el usuario con id " + p.getCodigo(), e);	}
	}

		
}