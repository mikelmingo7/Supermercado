package gestion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JTextField;


import clases.Cliente;

public class VentanaGestionCliente extends JFrame {
	


	
	
	JLabel nombre=new JLabel("     nombre");
	JTextField nom=new JTextField();
	JLabel apellidos=new JLabel("      apellidos");
	JTextField ap=new JTextField();
	JLabel DNI=new JLabel("     DNI");
	JTextField dni=new JTextField();
	JLabel socio=new JLabel("  	Socio");
	JTextField soc=new JTextField();
	
	JButton nuevo = new JButton("NUEVO");
	JButton guardar = new JButton("GUARDAR");
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
	    
	    panel2.setLayout(new GridLayout(2,0));
	    panel2.add(nombre);
	    panel2.add(nom);
	    panel2.add(apellidos);
	    panel2.add(ap);
	    panel2.add(DNI);
	    panel2.add(dni);
	    panel2.add(socio);
	    panel2.add(soc);
	    
	    panel1.setBounds(0,0,700,80);
	    panel2.setBounds(0,80,700,120);
	    panel3.setBounds(100,200,400,200);
	    
	    
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
		 new VentanaGestionCliente();
		}
	}

