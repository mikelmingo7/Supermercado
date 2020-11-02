import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class VentanaGestionCompra extends JFrame{

	JPanel listaPanel = new JPanel();
	JPanel infoPanel = new JPanel();
	
	JList listaCompras = new JList<>();
	JScrollPane listaScroll = new JScrollPane(listaCompras);
	DefaultListModel model = new DefaultListModel<Compra>();
	
	JButton nuevo = new JButton("NUEVO");
	JButton guardar = new JButton("GUARDAR");
	JButton eliminar = new JButton("ELIMINAR");
	
	
	
	public VentanaGestionCompra() {
		
		setLayout(null);
		setSize(900,500);
		setTitle("Gestión compras");
	    setLocationRelativeTo(null);

	    JPanel acciones = new JPanel();


	    add(acciones);
	    add(listaPanel);
	    add(infoPanel);

	    acciones.add(nuevo);
	    acciones.add(guardar);
	    acciones.add(eliminar);
	      
	    acciones.setBounds(0,0,900,80);
	    listaPanel.setBounds(0,80,300,440);
	    infoPanel.setBounds(320,80,500,400);

	    listaCompras.setModel(model);
    
	    listaPanel.add(listaScroll);

	    setResizable(false);
	    setVisible(true);

}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaGestionCompra v  = new VentanaGestionCompra();
	}
	
}
