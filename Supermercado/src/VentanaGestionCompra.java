import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VentanaGestionCompra extends JFrame{

	JPanel listaPanel = new JPanel();
	JPanel infoPanel = new JPanel();
	JList listaCompras = new JList<>();
	DefaultListModel model = new DefaultListModel<Compra>();
	
	
	public VentanaGestionCompra() {
		
		setLayout(null);
		setLocationRelativeTo(null);
        setSize(900,500);
        setTitle("Gestión compras");
        
        
        listaPanel.setVisible(true);
        infoPanel.setVisible(true);
        
        add(listaPanel);
        add(infoPanel);
        
        listaCompras.setModel(model);
        JScrollPane listaScroll = new JScrollPane(listaCompras);
        listaScroll.setPreferredSize(new Dimension(250, 350));
        listaPanel.add(listaScroll);
        
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaGestionCompra v  = new VentanaGestionCompra();
	}
	
}
