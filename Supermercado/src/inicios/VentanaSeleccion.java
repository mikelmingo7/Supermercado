package inicios;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaSeleccion extends JFrame{

	public VentanaSeleccion() {
		JPanel panel=new JPanel();	
		setSize(600,300);
		setTitle("Ventana de Seleccion");
		setVisible(true);
		add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel.setBackground(new Color(117, 162, 214));
		
		panel.setLayout(null);
		
		JButton administrador=new JButton("Administrador");
			administrador.setBounds(40, 100, 150, 30);
			panel.add(administrador);
		
		administrador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaLogin("admin");
				dispose();
				
			}
		});	
		
		JButton usuario=new JButton("Usuario");
			usuario.setBounds(210, 100, 150, 30);
			panel.add(usuario);	

		usuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaLogin("cliente");
				dispose();
				
			}
		});

		JButton trabajador = new JButton("Trabajador");
		trabajador.setBounds(390, 100, 150, 30);
		panel.add(trabajador);	

		trabajador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaLogin("trabajador");
				
			}
		});
		
		}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new VentanaSeleccion();
		
	}
}
