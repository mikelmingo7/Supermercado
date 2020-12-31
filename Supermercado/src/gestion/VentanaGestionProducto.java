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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import clases.Producto;

public class VentanaGestionProducto extends JFrame{
	
	JPanel listaPanel = new JPanel();
	JPanel infoPanel = new JPanel();
	JPanel acciones = new JPanel();
	
	JLabel nombrejl = new JLabel("Nombre");
	JTextField nombrejt = new JTextField();
	JLabel codigojl = new JLabel("Código");
	JTextField codigojt = new JTextField();
	JLabel seccionjl = new JLabel("Sección");
	JTextField seccionjt = new JTextField();
	JLabel marcajl = new JLabel("Marca");
	JTextField marcajt = new JTextField();
	JLabel preciojl = new JLabel("Precio");
	JLabel pesojl = new JLabel("Peso");
	JTextField pesojt = new JTextField();
	JTextField preciojt = new JTextField();
	
	
	JList listaProductos = new JList<>();
	JScrollPane listaScroll = new JScrollPane(listaProductos);
	DefaultListModel model = new DefaultListModel<Producto>();
	
	JButton nuevo = new JButton("NUEVO");
	JButton guardar = new JButton("GUARDAR");
	JButton eliminar = new JButton("ELIMINAR");
	
	public VentanaGestionProducto() {
		
		setLayout(null);
		setSize(900,500);
		setTitle("Gestión productos");
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

	    listaProductos.setModel(model);
    
	    listaPanel.add(listaScroll);
	    
	    infoPanel.setLayout(new GridLayout(8,2));
	   
	    infoPanel.add(nombrejl);
	    infoPanel.add(nombrejt);
	    infoPanel.add(codigojl);
	    infoPanel.add(codigojt);
	    infoPanel.add(seccionjl);
	    infoPanel.add(seccionjt);
	    infoPanel.add(marcajl);
	    infoPanel.add(marcajt);
	    infoPanel.add(pesojl);
	    infoPanel.add(pesojt);
	    infoPanel.add(preciojl);
	    infoPanel.add(preciojt); 	    
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
		VentanaGestionProducto ventanaProducto  = new VentanaGestionProducto();
	}

}
