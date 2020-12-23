package bases;


/*Clase que permite escribir en un archivo de texto*/

//Importamos clases que se usaran
import java.io.File;
import java.io.FileWriter;
import bases.Inventario;
import clases.Producto;

public class ExportarInventario {

	public static void main(String []args) {		
		
		try {
			
			Producto p = new Producto();
			Inventario invent = new Inventario();
			File archivo = new File("texto.txt");
			FileWriter escribir = new FileWriter(archivo,true);
			for (int i = 0; i < args.length; i++) {
				escribir.write(invent.getProducto(i).toString());		
			}
			escribir.close();
		}

		//Si existe un problema al escribir cae aqui
		catch(Exception e) {
			System.out.println("Error al escribir");
		}
	}
}
