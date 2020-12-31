package gestion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import clases.Producto;

public class VentanaGestionInventario extends JFrame{
	
	JPanel ventanaPanel = new JPanel();
	JPanel listaPanel = new JPanel();
	JPanel infoPanel = new JPanel();
	
	JLabel nombrejl = new JLabel("Nombre");
	JTextField nombrejt = new JTextField();
	JLabel codigojl = new JLabel("Código");
	JTextField codigojt = new JTextField();
	JLabel cantidadjl = new JLabel("Cantidad");
	JSpinner cantidad = new JSpinner();
	
	
	
	JList listaProductos = new JList<>();
	JScrollPane listaScroll = new JScrollPane(listaProductos);
	DefaultListModel model = new DefaultListModel<Producto>();
	
	
	public VentanaGestionInventario() {
		
		setLayout(null);
		setSize(900,500);
		setTitle("Gestión productos");
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    ventanaPanel.setLayout(new GridLayout(1,2));
	    
	    add(ventanaPanel);
	    
	    
	    
	    ventanaPanel.add(listaPanel);
	    ventanaPanel.add(infoPanel);

	    listaProductos.setModel(model);
    
	    listaPanel.add(listaScroll);
	    
	    infoPanel.setLayout(new GridLayout(8,2));
	   
	    
	    JPanel panelNombre = new JPanel();
	    panelNombre.setLayout(new GridLayout(1,2));
	    panelNombre.add(nombrejl);
	    panelNombre.add(nombrejt);
	    infoPanel.add(panelNombre);
	    
	    JPanel panelCodigo = new JPanel();
	    panelCodigo.setLayout(new GridLayout(1,2));
	    panelCodigo.add(codigojl);
	    panelCodigo.add(codigojt);
	    infoPanel.add(panelCodigo);
	    
	    JPanel panelSpinner = new JPanel();
	    panelSpinner.setLayout(new GridLayout(1,2));
	    panelSpinner.add(cantidadjl);
	    panelSpinner.add(cantidad);
	    infoPanel.add(panelSpinner);
	  
	    
	    setResizable(false);
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaGestionInventario ventanaInventario  = new VentanaGestionInventario();
	}

}
