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
import gestion.VentanaGestionCompra;
import gestion.VentanaGestionInventario;
import gestion.VentanaGestionPedido;
import gestion.VentanaGestionProducto;
import gestion.VentanaGestionTrabajadores;


public class VentanaPanelAdmin extends Thread{
	
	JButton empleados = new JButton("Trabajadores");
	JButton clientes = new JButton("Clientes");
	JButton inventario = new JButton("Inventario");
	JButton producto = new JButton("Productos");
	JButton pedidos = new JButton("Pedidos");
	JButton compras = new JButton("Compras");
	
	
	
	public VentanaPanelAdmin() {
		
		JPanel panel1 = new JPanel();	
		JFrame ventanapaneladmin =new JFrame();
		
		ventanapaneladmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanapaneladmin.setSize(500,300);
		ventanapaneladmin.setTitle("Panel Administrador");
		panel1.setLayout(new GridLayout(6,1));
		ventanapaneladmin.add(panel1);
		ventanapaneladmin.setVisible(true);
		
		panel1.add(empleados);
		panel1.add(clientes);	
		panel1.add(inventario);
		panel1.add(producto);
		panel1.add(pedidos);
		panel1.add(compras);
		
		compras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Thread threadClientes = new Thread() {
					VentanaGestionCompra v1 = new VentanaGestionCompra();
				};
				threadClientes.start();
				
			}
		});
	
	pedidos.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Thread threadClientes = new Thread() {
				VentanaGestionPedido v1 = new VentanaGestionPedido();
			};
			threadClientes.start();
			
		}
	});
		
		empleados.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 Thread threadEmpleados = new Thread() {
					VentanaGestionTrabajadores vt= new VentanaGestionTrabajadores(); 
				 };
				 
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
					VentanaGestionInventario vi = new VentanaGestionInventario();
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
		
		
	}

	
	public static void main(String[] args) {
		VentanaPanelAdmin PanelAdmin = new VentanaPanelAdmin();
	}


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	//
}
