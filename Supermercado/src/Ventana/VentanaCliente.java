package Ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import clases.Cliente;

public class VentanaCliente extends JFrame {
	JList listaClientes = new JList<>();
	JScrollPane listaScroll = new JScrollPane(listaClientes);
	
	DefaultListModel model = new DefaultListModel<Cliente>();
	


	
	
	JLabel nombre=new JLabel("     Nombre del cliente:");
	JTextField nom=new JTextField();
	JLabel apellidos=new JLabel("      Apellidos del cliente:");
	JTextField ap=new JTextField();
	JLabel DNI=new JLabel("     DNI");
	JTextField dni=new JTextField();
	JLabel socio=new JLabel("  	Socio");
	JTextField soc=new JTextField();
	
	JButton nuevo = new JButton("NUEVO");
	JButton guardar = new JButton("GUARDAR");
	JButton eliminar = new JButton("ELIMINAR");
	
	JPanel panel1=new JPanel();
	JPanel panel2=new JPanel();
	JPanel panel3=new JPanel();
	
	
		
	public VentanaCliente() {
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
	    
	    
	    panel2.setLayout(new GridLayout(5,2));
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
	    
	    
		listaClientes.setModel(model);
	    panel3.add(listaScroll);
	  

	  
	    
	    setResizable(false);
		setVisible(true);
		
}
	public static void main(String[] args) {
		 new VentanaCliente();
		}
	}

