package gestion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import bases.DBException;
import bases.Inventario;
import clases.Cliente;
import clases.Producto;

public class VentanaGestionCliente extends JFrame {
	
	Inventario inventario = new Inventario();
	JLabel nombre=new JLabel("     nombre");
	JTextField nombrejt=new JTextField();
	JLabel apellidos=new JLabel("      apellidos");
	JTextField apellidojt=new JTextField();
	JLabel DNI=new JLabel("     DNI");
	JTextField dnijt=new JTextField();
	JLabel socio=new JLabel("  	Socio");
	JTextField sociojt=new JTextField(); 
	
	JButton nuevo = new JButton("NUEVO");
	JButton guardar = new JButton("GUARDAR");
	JButton cargar = new JButton("CARGAR");
	JButton eliminar = new JButton("ELIMINAR"); 
	
	JList listaClientes = new JList<>();
	JScrollPane listaScroll = new JScrollPane(listaClientes);
	DefaultListModel modeloCliente = new DefaultListModel<Cliente>();
	
	JPanel panel1=new JPanel();
	JPanel panel2=new JPanel();
	JPanel panel3=new JPanel();
	
	
	public VentanaGestionCliente() {
		setTitle("Ventana Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 400);
		 Font fuente = new Font("Times new roman", Font.CENTER_BASELINE, 15);
		 
		 
		 JPanel pnlCentral = new JPanel();
		 pnlCentral.setBackground(Color.green);
			
		getContentPane().add(pnlCentral, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setLayout(null); 
		

		add(panel1);
		add(panel2);
		add(panel3);
		
		panel1.add(nuevo);
	    panel1.add(guardar);
	    panel1.add(eliminar);
	    panel1.add(cargar);
	    
	    panel2.setLayout(new GridLayout(2,0));
	    panel2.add(nombre);
	    panel2.add(nombrejt);
	    panel2.add(apellidos);
	    panel2.add(apellidojt);
	    panel2.add(DNI);
	    panel2.add(dnijt);
	    panel2.add(socio);
	    panel2.add(sociojt);
	    panel3.add(listaClientes);
	    panel1.setBounds(0,0,700,80);
	    panel2.setBounds(0,80,700,120);
	    panel3.setBounds(100,200,400,200);
	    
	    
	    //Botones funcionamiento
	    
	    eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Eliminar cliente de db
            	Cliente c = (Cliente) listaClientes.getSelectedValue();
            	modeloCliente.removeElement(c);
            	try {
					inventario.connect("productos.db");
					inventario.delete(c);
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });

        nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Crear cliente de db
            	
            	try {
            		
					inventario.connect("productos.db");
					inventario.createClienteTable();
					
					String nomb,dni,ap,soc;
					
					nomb=nombrejt.getText();
					ap=apellidojt.getText();
					dni=dnijt.getText();
					soc=sociojt.getText();
					
					Cliente c=new Cliente();
					
					c.setDni(dni);
					c.setNombre(nomb);
					c.setApellido(ap);
					c.setSocio(soc);
					
					inventario.storeC(c);
					
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	nombrejt.setText(null);
				apellidojt.setText(null);
				dnijt.setText(null);
				sociojt.setText(null);
            }
        });
      //Boton para cargar informacion de la BD a la tabla
	    cargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Eliminar producto de db
            	
            	modeloCliente.clear();
            	
            	try {
            		inventario.connect("productos.db");
            		ArrayList<String> dnis = inventario.getDni();
            		
            		for (int i = 0; i < dnis.size(); i++) {
            			String dni = dnis.get(i);
            			Cliente c = inventario.getCliente(dni);
            			modeloCliente.addElement(c);
						
					}
	
				} catch (DBException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	
            	
            }
        });
        
        guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Update de cliente en DB
				try {
					inventario.dropClienteTable();
					inventario.connect("productos.db");
					
					String nomb,ap,dni,soc;
					
					nomb=nombrejt.getText();
					ap=apellidojt.getText();
					dni=dnijt.getText();
					soc=sociojt.getText();
					
					Cliente c=new Cliente();
					
					c.setDni(dni);
					c.setNombre(nomb);
					c.setApellido(ap);
					c.setSocio(soc);
					
					inventario.update(c);
					
				} catch (DBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
      //Ver valores del producto seleccionado en el TextField correspondiente
	    MouseListener seleccionar = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
            	Cliente c = (Cliente) listaClientes.getSelectedValue();
            	dnijt.setText(c.getDni());
            	nombrejt.setText(c.getNombre());
            	apellidojt.setText(c.getApellido());
            	sociojt.setText(c.getSocio());
            	
            	
         }
           
            
	    
		};
		
		//Añadimos la funcion del mouselistener a la lista 
		listaClientes.addMouseListener(seleccionar);
	    
	    
		setVisible(true);
		
}
	public static void main(String[] args) {
		 new VentanaGestionCliente();
		}
	}

