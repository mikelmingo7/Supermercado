package panel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gestion.VentanaGestionCliente;
import gestion.VentanaGestionCompra;
import gestion.VentanaGestionInventario;
import gestion.VentanaGestionPedido;
import gestion.VentanaGestionProducto;

public class VentanaPanelTrabajador extends Thread{
	
	JButton clientes = new JButton("Clientes");
	JButton inventario = new JButton("Inventario");
	JButton producto = new JButton("Productos");
	JButton pedidos = new JButton("Pedidos");
	JButton compras = new JButton("Compras");
	
	public VentanaPanelTrabajador() {
		
		JPanel panel1 = new JPanel();	
		JFrame ventanapaneltrabajador =new JFrame();
		
		ventanapaneltrabajador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanapaneltrabajador.setSize(500,300);
		ventanapaneltrabajador.setTitle("Panel Trabajador");
		panel1.setLayout(new GridLayout(5,1));
		ventanapaneltrabajador.add(panel1);
		ventanapaneltrabajador.setVisible(true);
		
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
		VentanaPanelTrabajador PanelTrabajador = new VentanaPanelTrabajador();
	}
//
}
