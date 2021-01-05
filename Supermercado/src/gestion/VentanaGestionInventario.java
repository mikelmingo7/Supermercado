package gestion;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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
		
	JPanel listaPanel = new JPanel();
	JPanel infoPanel = new JPanel();
	JPanel botonPanel = new JPanel();
	
	JLabel nombrejl = new JLabel("Nombre");
	JTextField nombrejt = new JTextField();
	JLabel codigojl = new JLabel("Código");
	JTextField codigojt = new JTextField();
	JLabel cantidadjl = new JLabel("Cantidad");
	JSpinner cantidad = new JSpinner();
	
	JButton guardar = new JButton("GUARDAR");
	
	
	JList listaProductos = new JList<>();
	JScrollPane listaScroll = new JScrollPane(listaProductos);
	DefaultListModel model = new DefaultListModel<Producto>();
	
	
	public VentanaGestionInventario() {
		
		setLayout(new GridLayout(3,1));
		setSize(900,500);
		setTitle("Gestión de Inventario");
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    
		add(listaPanel);
		add(infoPanel);
		add(botonPanel);
	    
	    
	    infoPanel.setLayout(new GridLayout(3,2));
	    listaPanel.setLayout(new GridLayout(1,1));
	    botonPanel.setLayout(new BorderLayout());
	    
	    

	    listaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    botonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    
	    botonPanel.add(guardar, BorderLayout.CENTER);
	  
	    
	    listaProductos.setModel(model);
    
	    listaPanel.add(listaScroll);
	    
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
