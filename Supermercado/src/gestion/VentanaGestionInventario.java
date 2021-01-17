package gestion;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.ArrayList;

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

import bases.BaseProducto;
import bases.DBException;
import clases.Producto;

public class VentanaGestionInventario extends JFrame{
	BaseProducto bp=new BaseProducto();
	
	JPanel listaPanel = new JPanel();
	JPanel infoPanel = new JPanel();
	JPanel botonPanel = new JPanel();
	
	JLabel nombrejl = new JLabel("Nombre");
	JTextField nombrejt = new JTextField();
	JLabel codigojl = new JLabel("Código");
	JTextField codigojt = new JTextField();
	JLabel cantidadjl = new JLabel("Cantidad");
	JTextField cantidadjt = new JTextField();
	
	JButton cargar = new JButton("CARGAR");
	JButton guardar = new JButton("GUARDAR");
	JButton exportar= new JButton("EXPORTAR");
	
	
	JList listaProductos = new JList<Producto>();
	JScrollPane listaScroll = new JScrollPane(listaProductos);
	DefaultListModel model = new DefaultListModel<Producto>();
	
	
	public VentanaGestionInventario() {
		
		setLayout(new BorderLayout());
		setSize(900,500);
		setTitle("Gestión de Inventario");
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    
	    botonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    listaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    
	    botonPanel.setLayout(new GridLayout(1,3));
	    infoPanel.setLayout(new GridLayout(3,2));
	    listaPanel.setLayout(new GridLayout(1,1));
	    
	    add(botonPanel, BorderLayout.NORTH);
	    add(listaPanel, BorderLayout.LINE_START);
	    add(infoPanel, BorderLayout.CENTER);
	    
		

	    listaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    botonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    
	    botonPanel.add(guardar);
	    botonPanel.add(cargar);
	    botonPanel.add(exportar);
	  
	    
	    listaProductos.setModel(model);
    
	    listaPanel.add(listaScroll);
	    

	    infoPanel.add(nombrejl);
	    infoPanel.add(nombrejt);
	    infoPanel.add(codigojl);
	    infoPanel.add(codigojt);
	    infoPanel.add(cantidadjl);
	    infoPanel.add(cantidadjt);

    	
    	MouseListener seleccionar = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
            	Producto p = (Producto) listaProductos.getSelectedValue();
            	nombrejt.setText(p.getNombre());
            	codigojt.setText(""+p.getCodigo());
            	cantidadjt.setText(""+p.getStock());
         }

		};
	  
    	listaProductos.addMouseListener(seleccionar);
    	
    	guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Update de cliente en DB
				
				try {
					bp.connect("producto.db");
				
					String nomb,cod,can;
					
					nomb=nombrejt.getText();
					cod=codigojt.getText();
					can=(String) cantidadjt.getText();
					
					Producto p = new Producto();
					
					p.setCodigo( Integer.parseInt(cod) );
					p.setStock(Integer.parseInt(can));
					
					bp.updateS(p);
					
					
				} catch (DBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
        
	//Boton para cargar informacion de la BD a la tabla
	cargar.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        //Eliminar producto de db
	    	
	    	model.clear();
	    	
	    	try {
	    		bp.connect("producto.db");
	    		
	    		ArrayList<Integer> codigos = bp.getCodigo();
	    		
	    		for (int i = 0; i < codigos.size(); i++) {
	    			Integer cod = codigos.get(i);
	    			Producto p = bp.getProducto(cod);
	    			model.addElement(p);
					
				}
	
			} catch (DBException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
	    	
	    	
	    }
	});
	
	//Boton para exportar la lista del inventario
	exportar.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	try {
				
	    		//Abro stream, crea el fichero si no existe
	            FileWriter fw = new FileWriter("productos.txt");
	            //Escribimos en el fichero un String y un caracter 97 (a)
	            for (int i = 0; i < model.getSize(); i++) {
					Producto p = (Producto) model.getElementAt(i);  
					fw.write(p.toString()+ "\r\n");		
				}
	            //Cierro el stream
	            fw.close();
			}

			//Si existe un problema al escribir cae aqui
			catch(Exception e1) {
				System.out.println("Error al escribir");
			}
	    }
	});
    	
	  
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaGestionInventario ventanaInventario  = new VentanaGestionInventario();
	}

}
