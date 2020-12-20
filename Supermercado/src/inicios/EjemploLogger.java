package inicios;

import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//En este ejemplo se muestra la utilizaci�n de las classes
//de logging de Java para sacar informaci�n de traza. Se recomienda
//utilizar esta opci�n para proporcionar informaci�n del programa en vez
//de utilizar la salida directa por consola con System.out.



public class EjemploLogger {
	
	// Creamos el logger con el pasando como par�metro el nombre de la clase actual
    private static Logger logger = Logger.getLogger(EjemploLogger.class.getName());

    // Niveles de importancia para el log:
	// FINEST / FINER / FINE / CONFIG / INFO / WARNING / SEVERE
	// Por defecto se muestran en consola de error solo INFO-WARNING-SEVERE
    
    public static void main(String[] args) {
        // Cambios el nivel de salida del log para sacar los mensajes
        // FINE-CONFIG-INFO-WARNING-SEVERE
        // Aunque se puede configurar por c�digo el nivel del logger, lo usual es 
        // hacerlo en un fichero externo 
        // Logger.getLogger("").setLevel(Level.SEVERE);
        // Logger.getLogger("").getHandlers()[0].setLevel(Level.SEVERE);

        try (FileInputStream fis = new FileInputStream("ficheros/logger.properties")) {
            LogManager.getLogManager().readConfiguration(fis);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "No se pudo leer el fichero de configuraci�n del logger");
        }

        // Empieza el programa y el los mensajes de log que indican
        // lo que va ocurriendo.
        logger.info("Programa comenzado");

        // Sacamos esta informaci�n con un nivel m�s detallado
        for (int i = 0; i < 10; i++) {
            logger.log(Level.FINE, "Voy por la iteraci�n " + i);
        }

        // Vamos a intentar abrir un fichero que no existe para producir
        // un fallo y sacarlo por el logger.
        try (FileInputStream fis = new FileInputStream("noexiste.txt")) {

        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "No se ha encontrado el fichero 'noexiste.txt");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "No se ha encontrado el fichero 'noexiste.txt");
        }

        logger.info("Programa finalizado");
    }
	
}
