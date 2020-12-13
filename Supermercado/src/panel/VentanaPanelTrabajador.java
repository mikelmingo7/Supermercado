package panel;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPanelTrabajador {
	
	JButton clientes = new JButton("Clientes");
	JButton inventario = new JButton("Inventario");
	JButton producto = new JButton("Productos");
	
	public VentanaPanelTrabajador() {
		
		JPanel panel1 = new JPanel();	
		JFrame ventanapaneltrabajador =new JFrame();
		
		ventanapaneltrabajador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanapaneltrabajador.setSize(500,300);
		ventanapaneltrabajador.setTitle("Panel Trabajador");
		panel1.setLayout(new GridLayout(3,1));
		ventanapaneltrabajador.add(panel1);
		ventanapaneltrabajador.setVisible(true);
		
		panel1.add(clientes);	
		panel1.add(inventario);
		panel1.add(producto);
	}
	
	public static void main(String[] args) {
		VentanaPanelTrabajador PanelTrabajador = new VentanaPanelTrabajador();
	}

}
