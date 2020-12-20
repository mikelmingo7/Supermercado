package gestion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class VentanaGestionCompra<Compra> extends JFrame{

	JPanel listaPanel = new JPanel();
	JPanel infoPanel = new JPanel();
	JPanel acciones = new JPanel();
	
	JLabel clientejl = new JLabel("Cliente");
	JTextField clientejt = new JTextField();
	JLabel preciojl = new JLabel("Precio");
	JTextField preciojt = new JTextField();
	JLabel fechajl = new JLabel("Fecha");
	JTextField fechajt = new JTextField();
	JLabel descuentojl = new JLabel("Descuento");
	JRadioButton botonDescuento = new JRadioButton("Si");
	JRadioButton botonSinDescuento = new JRadioButton("No");
	JTextField descuentojt = new JTextField();
	
	
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
	    
	    infoPanel.setLayout(new GridLayout(8,2));
	    infoPanel.add(clientejl);
	    infoPanel.add(clientejt);
	    infoPanel.add(preciojl);
	    infoPanel.add(preciojt);
	    infoPanel.add(fechajl);
	    infoPanel.add(fechajt);
	    infoPanel.add(descuentojl);
	    infoPanel.add(descuentojt);
	    infoPanel.add(botonDescuento);
	    infoPanel.add(botonSinDescuento);
	    
	    
	    //Botones funcionamiento
	    
	    eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Eliminar cliente de db
            }
        });

        nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Crear cliente de db
            }
        });
        
        guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Update de cliente en DB
				
			}
		});

	    setResizable(false);
	    setVisible(true);

}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaGestionCompra v  = new VentanaGestionCompra();
	}
	
}
