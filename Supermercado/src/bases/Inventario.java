package bases;
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

public class Inventario {
	
	
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
			System.out.println("Error al cerrar la conexi�n con la Base de Datos");
		}
	}
	public static void createProductoTable() throws DBException {
		// TODO Auto-generated method stub
		try (Statement s = conexion.createStatement()) {
			s.executeUpdate("CREATE TABLE IF NOT EXISTS Producto (codigo INTEGER PRIMARY KEY , nombre VARCHAR, seccion VARCHAR, marca VARCHAR, peso DEC, precio DEC)");
		} catch (SQLException e) {
			throw new DBException("Error creando la tabla 'Producto' en la BD", e);
		
	}
	
	
  }
	public static void dropProductoTable() throws DBException {
		try (Statement s = conexion.createStatement()) {
			s.executeUpdate("DROP TABLE IF EXISTS Producto");
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
		 ArrayList<Integer> listaCodigos=new ArrayList<>();
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
		} catch (SQLException e) {
			throw new DBException("No se pudo guardar el producto en la BD", e);
		}
	}
	public void delete(Producto p) throws DBException {
		try (PreparedStatement s = conexion.prepareStatement("DELETE FROM Producto WHERE codigo=?")) {
			s.setInt(1, p.getCodigo());
			
			s.executeUpdate();
		} catch (SQLException e) {
			throw new DBException("No se pudo eliminar el usuario con id " + p.getCodigo(), e);	}
	}
	
	public static void createClienteTable() throws DBException {
		// TODO Auto-generated method stub
		try (Statement s = conexion.createStatement()) {
			s.executeUpdate("CREATE TABLE IF NOT EXISTS Cliente (dni VARCHAR PRIMARY KEY, nombre VARCHAR, apellido VARCHAR, socio VARCHAR)");
		} catch (SQLException e) {
			throw new DBException("Error creando la tabla 'Cliente' en la BD", e);
		}
	}
	public static void dropClienteTable() throws DBException {
		try (Statement s = conexion.createStatement()) {
			s.executeUpdate("DROP TABLE IF EXISTS Cliente");
		} catch (SQLException e) {
			throw new DBException("Error borrando la tabla 'Cliente' en la BD", e); 
		}
	}
	public static void storeC(Cliente c) throws DBException {
		try (PreparedStatement ps = conexion.prepareStatement("INSERT INTO Cliente (dni,nombre,apellido,socio) VALUES (? ,?, ?, ?)");
			Statement s = conexion.createStatement()) {
			
			ps.setString(1, c.getDni());
			ps.setString(2, c.getNombre());
			ps.setString(3, c.getApellido());
			ps.setString(4, c.getSocio());
					
		
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new DBException("No se pudo guardar el usuario en la BD", e);
		}
	}
	public Cliente getCliente(String dni) throws DBException {
		try (PreparedStatement s = conexion.prepareStatement("SELECT dni,nombre,apellido,socio FROM Cliente WHERE dni = ?")) {
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
		 PreparedStatement ps = conexion.prepareStatement("SELECT dni FROM Cliente");
		 ResultSet rs = ps.executeQuery();
		 ArrayList<String> listaDnis=new ArrayList<>();
		 while(rs.next()) {
			 listaDnis.add(rs.getString("dni"));
		 }
		return listaDnis; 
		
	}
	public void update(Cliente c) throws DBException {
		try (PreparedStatement s = conexion.prepareStatement("UPDATE Cliente SET nombre=?, apellido=?, socio=?  WHERE dni=?")) {
			s.setString(1, c.getDni());
			s.setString(2, c.getNombre());
			s.setString(3, c.getApellido());
			s.setString(4, c.getSocio());
			
			
			
			s.executeUpdate();
		} catch (SQLException e) {
			throw new DBException("No se pudo guardar el cliente en la BD", e);
		}
	}
	public void delete(Cliente c) throws DBException {
		try (PreparedStatement s = conexion.prepareStatement("DELETE FROM Cliente WHERE dni=?")) {
			s.setString(1, c.getDni());
			
			s.executeUpdate();
		} catch (SQLException e) {
			throw new DBException("No se pudo eliminar el usuario con id " + c.getDni(), e);	}
	}
	
}
