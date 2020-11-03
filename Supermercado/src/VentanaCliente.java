import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaCliente extends JFrame {
	

	
	public VentanaCliente() {
		setTitle("Ventana Cliente");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		setSize(300, 300);
		
		 Font fuente = new Font("Times new roman", Font.CENTER_BASELINE, 15);
		 
		 
		 JPanel pnlCentral = new JPanel();
		 pnlCentral.setBackground(Color.green);
			
		getContentPane().add(pnlCentral, BorderLayout.CENTER);
		
		setVisible(true);
}
	public static void main(String[] args) {
		 new VentanaCliente();
		}
	}

