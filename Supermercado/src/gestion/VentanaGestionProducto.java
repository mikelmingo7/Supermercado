package gestion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.sql.Connection;
import bases.DBException;
import bases.Inventario;
import clases.Producto;

public class VentanaGestionProducto extends JFrame{
	
	Inventario inventario = new Inventario();
	
	private List listaP=new ArrayList();

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
	JButton cargar = new JButton("CARGAR");
	JButton guardar = new JButton("GUARDAR");
	JButton eliminar = new JButton("ELIMINAR");
	
	public VentanaGestionProducto() {
		
		setLayout(new BorderLayout());
		setSize(900,500);
		setTitle("Gestión productos");
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (Exception e) {}
	    
	    infoPanel.setLayout(new GridLayout(6,2));
	    listaPanel.setLayout(new GridLayout(1,1));
	    acciones.setLayout(new GridLayout(1,4));
	    
	    acciones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    listaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    
	    add(acciones, BorderLayout.NORTH);
	    add(listaPanel, BorderLayout.LINE_START);
	    add(infoPanel, BorderLayout.CENTER);
	    
	    

	    acciones.add(nuevo);
	    acciones.add(cargar);
	    acciones.add(guardar);
	    acciones.add(eliminar);
	    
	    
	      
	    

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
                //Eliminar producto de db
            	
            	
            }
        });

        nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Crear producto de db
            	
            	
            }
        });
        
        guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Update de cliente en DB
				
				try {
					
					inventario.connect("productos.db");
					inventario.createProductoTable();

					String nomb,cod,sec,mar,pes, prec;
					
					nomb=nombrejt.getText();
					cod=codigojt.getText();
					sec=seccionjt.getText();
					mar=marcajt.getText();
					pes=pesojt.getText();
					prec=preciojt.getText();
					
					Producto p = new Producto();
					
					p.setCodigo( Integer.parseInt(cod) );
					p.setNombre(nomb);
					p.setPeso(Double.parseDouble(cod));
					p.setPrecio(Double.parseDouble(prec));
					p.setMarca(mar);
					p.setSeccion(sec);
					
					
					inventario.store(p);
					
					
				
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				nombrejt.setText(null);
				codigojt.setText(null);
				seccionjt.setText(null);
				marcajt.setText(null);
				pesojt.setText(null);
				preciojt.setText(null);
			}
		});
        
	    cargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Eliminar producto de db
            	
            	try {
            		inventario.connect("productos.db");
            		
            		
					
            	
            			
				System.out.println(inventario.getCodigo());
				
					
					
				} catch (DBException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            }
        });
	    
	    pack();
	    setResizable(true);
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaGestionProducto ventanaProducto  = new VentanaGestionProducto();
	}

}
