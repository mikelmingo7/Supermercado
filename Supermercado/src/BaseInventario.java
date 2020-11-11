
public class BaseInventario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inventario i=new Inventario();
		try {
			System.out.println("Conectando a la base de datos...");
			Inventario.connect("productos.db");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
