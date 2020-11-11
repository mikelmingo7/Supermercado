import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
	
	private List listaP=new ArrayList();
	private static Connection conexion=null;
	private Statement s=null;
	
	public static void connect(String dbPath) {
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al intentar cargar el driver de la Base de Datos ");
		} catch (SQLException e) {
			System.out.println("Error al conectar a la Base de Datos");
		}
	}
	public void disconnect() {
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexión con la Base de Datos");
		}
	}
	public static void createInventarioTable() {
		// TODO Auto-generated method stub
		
	}
	
	
}
