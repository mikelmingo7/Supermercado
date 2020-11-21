import BD.Inventario;
import ClasesBase.Producto;

public class BaseInventario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inventario i=new Inventario();
		try {
			System.out.println("Conectando a la base de datos...");
			Inventario.connect("productos.db");
			Inventario.createProductoTable();
			
			System.out.println("Introduciendo productos...");
			
			 for (int j = 1; j <=10; j++) {
				 Producto p = new Producto();
	                p.setNombre("Nombre_" + j);
	                p.setSeccion("Seccion_"+j);
	                p.setPeso(j);
	                p.setMarca("Marca_"+j);
	                p.setPrecio(j);
	                
	                Inventario.store(p);
	                
	              Inventario.dropProductoTable();
	              Inventario.disconnect();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
