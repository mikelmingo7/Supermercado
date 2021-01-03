import bases.DBException;
import bases.Inventario;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inventario i=new Inventario();
		try {
			i.connect("productos.db");
			i.createProductoTable();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
