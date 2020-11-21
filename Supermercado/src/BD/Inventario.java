package BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ClasesBase.Producto;

public class Inventario {
	
	private List listaP=new ArrayList();
	private static Connection conexion = null;
	
	public static void connect(String dbPath) throws DBException {
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al intentar cargar el driver de la Base de Datos ");
		} catch (SQLException e) {
			System.out.println("Error al conectar a la Base de Datos");
		}
	}
	public static void  disconnect() throws DBException {
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexión con la Base de Datos");
		}
	}
	public static void createProductoTable() throws DBException {
		// TODO Auto-generated method stub
		try (Statement s = conexion.createStatement()) {
			s.executeUpdate("CREA TABLA SI NO EXISTSE producto (codigo INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR, seccion VARCHAR, marca VARCHAR, peso INTEGER, precio DEC)");
		} catch (SQLException e) {
			throw new DBException("Error creando la tabla 'producto' en la BD", e);
		
	}
	
	
  }
	public static void dropProductoTable() throws DBException {
		try (Statement s = conexion.createStatement()) {
			s.executeUpdate("DROP TABLE IF EXISTS producto");
		} catch (SQLException e) {
			throw new DBException("Error borrando la tabla 'user' en la BD", e);
		}
}
	public static void store(Producto p) throws DBException {
		try (PreparedStatement ps = conexion.prepareStatement("INSERT INTO user (nombre,peso,precio,marca,seccion) VALUES (?, ?, ?)");
			Statement s = conexion.createStatement()) {
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getMarca());
			ps.setString(3, p.getSeccion());
			ps.setDouble(4, p.getPeso());
			ps.setDouble(5, p.getPrecio());
			
			ps.executeUpdate();
			
			ResultSet rs = s.executeQuery("SELECT last_insert_rowid() AS id FROM producto");
			if (rs.next()) {
				int newId = rs.getInt("codigo");
				p.setCodigo(newId);
			} else {
				throw new DBException("Error generando el id autoincremental");
			}
		} catch (SQLException e) {
			throw new DBException("No se pudo guardar el usuario en la BD", e);
		}
	}
	
}
