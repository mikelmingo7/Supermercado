package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gestion.VentanaGestionCliente;
import gestion.VentanaGestionProducto;

public class VentanaPanelAdmin extends Thread{
	
	JButton empleados = new JButton("Empleados");
	JButton clientes = new JButton("Clientes");
	JButton inventario = new JButton("Inventario");
	JButton producto = new JButton("Productos");
	JButton descuento = new JButton("Descuento");
	
	
	
	public VentanaPanelAdmin() {
		
		JPanel panel1 = new JPanel();	
		JFrame ventanapaneladmin =new JFrame();
		
		ventanapaneladmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanapaneladmin.setSize(500,300);
		ventanapaneladmin.setTitle("Panel Administrador");
		panel1.setLayout(new GridLayout(5,1));
		ventanapaneladmin.add(panel1);
		ventanapaneladmin.setVisible(true);
		
		panel1.add(empleados);
		panel1.add(clientes);	
		panel1.add(inventario);
		panel1.add(producto);
		panel1.add(descuento);
		
		empleados.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 Thread threadEmpleados = new Thread();
				 threadEmpleados.start();
				
			}
		});
		
		clientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Thread threadClientes = new Thread() {
					VentanaGestionCliente v1 = new VentanaGestionCliente();
				};
				threadClientes.start();
				
			}
		});
		
		inventario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Thread threadInventario = new Thread() {
					
				};
				
				threadInventario.start();
				
			}
		});
		
		producto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Thread threadProducto = new Thread() {
					VentanaGestionProducto v2 = new VentanaGestionProducto();
				};
				threadProducto.start();
				
			}
		});
		
		descuento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Thread threadDescuento = new Thread();
				threadDescuento.start();
				
			}
		});
		
	}

	
	public static void main(String[] args) {
		VentanaPanelAdmin PanelAdmin = new VentanaPanelAdmin();
	}


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	//
}
