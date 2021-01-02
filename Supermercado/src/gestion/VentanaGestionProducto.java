package gestion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import bases.DBException;
import bases.Inventario;
import clases.Producto;

public class VentanaGestionProducto extends JFrame{
	Inventario i=new Inventario();
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
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		

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
					i.connect("productos.db");
					String nomb,cod,sec,mar,pes, prec;
					Connection conexion=null;
					nomb=nombrejt.getText();
					cod=codigojt.getText();
					sec=seccionjt.getText();
					mar=marcajt.getText();
					pes=pesojt.getText();
					prec=preciojt.getText();
					String sql="";
					sql="INSERT INTO Producto (nombre,codigo,seccion,marca,precio) VALUES (?, ?, ?, ?, ?, ?)";
					PreparedStatement ps=conexion.prepareStatement(sql);
					ps.setString(1, nomb);
					ps.setString(2, cod);
					ps.setString(3, sec);
					ps.setString(4, mar);
					ps.setString(5, pes);
					ps.setString(6, prec);
					
					ps.executeUpdate();
				
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				nombrejt.setText(null);
				codigojt.setText(null);
				seccionjt.setText(null);
				marcajt.setText(null);
				pesojt.setText(null);
				preciojt.setText(null);
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
