import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VentanaGestionCompra extends JFrame{

	JPanel listaPanel = new JPanel();
	JPanel infoPanel = new JPanel();
	JFrame ventana = new JFrame("Ventana gestion compras");
	JList listaCompras = new JList<>();
	DefaultListModel modeloCompras;
	
	
	public VentanaGestionCompra() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
        setLocationRelativeTo(null);
        
        add(listaPanel);
		add(ventana);
		add(infoPanel);
		
		listaCompras.setModel(modeloCompras);
		JScrollPane panelLista = new JScrollPane(listaCompras);
		
		
		
		
		
		
		
	}
	
	
	
}
