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

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import bases.BaseCliente;
import bases.DBException;
import bases.Inventario;
import clases.Cliente;
import clases.Producto;

public class VentanaGestionCliente extends JFrame {
	BaseCliente bc=new BaseCliente();

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
	DefaultListModel<Cliente> model = new DefaultListModel<Cliente>();
	
	JPanel listaPanel = new JPanel();
	JPanel infoPanel = new JPanel(); 
	JPanel acciones = new JPanel();
	
	
	public VentanaGestionCliente() {
		setTitle("Ventana Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 400);
		Font fuente = new Font("Times new roman", Font.CENTER_BASELINE, 15);
		 
		 
		 JPanel pnlCentral = new JPanel();
		 pnlCentral.setBackground(Color.green);
			
		getContentPane().add(pnlCentral, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout()); 
		
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
		 acciones.add(guardar);
		 acciones.add(eliminar);
		 acciones.add(cargar);
		 
		 listaClientes.setModel(model);
		    
		 listaPanel.add(listaScroll);
	    
		 infoPanel.setLayout(new GridLayout(2,0));
		 infoPanel.add(nombre);
		 infoPanel.add(nombrejt);
		 infoPanel.add(apellidos);
		 infoPanel.add(apellidojt);
		 infoPanel.add(DNI);
		 infoPanel.add(dnijt);
		 infoPanel.add(socio);
	     infoPanel.add(sociojt);
	     listaPanel.add(listaScroll);
	     
	    
	    
	    //Botones funcionamiento
	    
	    eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Eliminar cliente de db
            	Cliente c = (Cliente) listaClientes.getSelectedValue();
            	model.removeElement(c);
            	try {
					bc.connect("cliente.db");
					bc.delete(c);
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
            	
					bc.connect("cliente.db");
					bc.createClienteTable();
					
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
					
					bc.storeC(c);
					
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
            	
            	model.clear();
            	
            	try {
            		bc.connect("cliente.db");
            		ArrayList<String> dnis = bc.getDni();
            		
            		for (int j = 0; j < dnis.size(); j++) {
            			String dni = dnis.get(j);
            			Cliente c = bc.getCliente(dni);
            			model.addElement(c);
						
					}
	
				} catch (DBException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	
            	
            }
        });
	  //Boton para guardar la  informacion del textfield la base de datos
        guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Update de cliente en DB
				try {
					bc.connect("cliente.db");
					
					String nomb = nombrejt.getText();
					String ap = apellidojt.getText();
					String dni = dnijt.getText();
					String soc = sociojt.getText();
					 
					Cliente c = new Cliente();
					
					c.setDni(dni);
					c.setNombre(nomb);
					c.setApellido(ap);
					c.setSocio(soc);
					
					bc.update(c);
					
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
	    
		pack();
		setResizable(true);
		setVisible(true);
		
}
	public static void main(String[] args) {
		 new VentanaGestionCliente();
		}
	}

