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
import clases.Pedido;
import clases.Producto;

public class BasePedido {
	
	// conexión con la base de datos
	
	private static Logger logger = null;
	private static boolean LOGGING = true;
	
	private static Connection conexion = null;
	 
	private static void log( Level level, String msg, Throwable excepcion ) {
		if (!LOGGING) return;
		if (logger==null) {  // Logger por defecto local:
			logger = Logger.getLogger( BasePedido.class.getName() );  // Nombre del logger - el de la clase
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
	public static void createPedidoTable() throws DBException {
		// TODO Auto-generated method stub
		try (Statement s = conexion.createStatement()) {
			s.executeUpdate("CREATE TABLE IF NOT EXISTS TablaPedido (codigoCompra INTEGER PRIMARY KEY, nombreProducto VARCHAR , dniCliente VARCHAR, precio DEC, fecha DATE, direccion VARCHAR)");
			log( Level.INFO, "Tabla creada correctamente", null );
		} catch (SQLException e) {
			throw new DBException("Error creando la tabla 'TablaPedido' en la BD", e);
		
	}
	
	
  }
	public static void dropProductoTable() throws DBException {
		try (Statement s = conexion.createStatement()) {
			s.executeUpdate("DROP TABLE IF EXISTS TablaPedido");
			log( Level.INFO, "Borrado la tabla correctamente", null );
		} catch (SQLException e) {
			throw new DBException("Error borrando la tabla 'TablaPedido' en la BD", e); 
		}
}
	public static void storeP(Pedido p) throws DBException {
		try (PreparedStatement ps = conexion.prepareStatement("INSERT INTO TablaPedido (codigoCompra, nombreProducto, dniCliente, precio, fecha, direccion) VALUES (? ,?, ?, ?, ?, ?)");
			Statement s = conexion.createStatement()) {
			ps.setInt(1, p.getCodigoCompra());
			ps.setString(2, p.getNombreProducto());
			ps.setString(3, p.getDniCliente());
			ps.setDouble(4, p.getPrecio());
			ps.setString(5, p.getFecha());
			ps.setString(5, p.getDireccion());
			
			
			
		
			ps.executeUpdate();
			
			log( Level.INFO, "Instertado el pedido correctamente", null );
		} catch (SQLException e) {
			throw new DBException("No se pudo guardar el pedido en la BD", e);
		}
	}
	public Compra getPedido(Integer codigoCompra) throws DBException {
		try (PreparedStatement s = conexion.prepareStatement("SELECT codigoCompra, nombreProducto, dniCliente, precio, fecha, direccion FROM TablaPedido WHERE codigoCompra = ?")) {
			s.setInt(1, codigoCompra);
			
			ResultSet rs = s.executeQuery();

			if (rs.next()) {
				Pedido p=new Pedido();
				p.setCodigoCompra(rs.getInt("codigoCompra"));
				p.setNombreProducto(rs.getString("nombreProducto"));
				p.setDniCliente(rs.getString("dniCliente"));
				p.setPrecio(rs.getDouble("precio"));
				p.setFecha(rs.getString("fecha"));
				p.setFecha(rs.getString("direccion"));
			
				
				return p;
			} else {
				return new Pedido(); 
				
			}
			
		} catch (SQLException | DateTimeParseException e) {
			throw new DBException("Error obteniendo la compra con codigoCompra " +codigoCompra, e);
		}
	}
	public ArrayList<Integer> getCodigoCompra() throws DBException, SQLException{
		 PreparedStatement ps = conexion.prepareStatement("SELECT codigoCompra FROM TablaPedido ");
		 ResultSet rs = ps.executeQuery();
		 ArrayList<Integer> listaCodigosP=new ArrayList<Integer>();
		 while(rs.next()) {
			 listaCodigosP.add(rs.getInt("codigoCompra"));
		 }
		return listaCodigosP; 
		
	}
	

	public void update(Pedido p) throws DBException {
		try (PreparedStatement s = conexion.prepareStatement("UPDATE TablaCompra SET codigoCompra=?,nombreProducto=?, dniCliente=?, precio=?, fecha=?  WHERE codigoCompra=?")) {
			s.setInt(1, p.getCodigoCompra());
			s.setString(2, p.getNombreProducto());
			s.setString(3, p.getDniCliente());
			s.setDouble(4, p.getPrecio());
			s.setString(5, p.getFecha());
			s.setString(6, p.getDireccion());
			
			s.executeUpdate();
			log( Level.INFO, "Actualizado el pedido especificado", null );
		} catch (SQLException e) {
			throw new DBException("No se pudo guardar la compra en la BD", e);
		}
	}
	public void delete(Pedido p) throws DBException {
		try (PreparedStatement s = conexion.prepareStatement("DELETE FROM TablaCompra WHERE codigoCompra=?")) {
			s.setInt(1, p.getCodigoCompra());
			
			s.executeUpdate();
			log( Level.INFO, "Borrado la compra correctamente", null );
		} catch (SQLException e) {
			throw new DBException("No se pudo eliminar el pedido con codigoCompra " + p.getCodigoCompra(), e);	}
	}

		
}
