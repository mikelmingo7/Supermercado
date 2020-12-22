package Ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaLogin  extends JFrame{
	private JPanel pnlCentral;
	private JPasswordField txtPassword;
	private JTextField txtUser;
	private JButton btnLogin;
	private JButton btnCrearUsuario;
	private static final long serialVersionUID = 0; 

			public VentanaLogin() {
		setTitle("Inicio de sesion");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		setSize(300, 300);
		
		 Font fuente = new Font("Times new roman", Font.CENTER_BASELINE, 15);
		 
		 
		 pnlCentral = new JPanel();
		 pnlCentral.setBackground(Color.GREEN);
			
		getContentPane().add(pnlCentral, BorderLayout.CENTER);
		
		pnlCentral.setLayout(null);
		/*
		 * Usuario 
		 */
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(47, 60, 61, 16);
		pnlCentral.add(lblNewLabel);

		txtUser = new JTextField();
		txtUser.setBounds(139, 60, 130, 31);
		pnlCentral.add(txtUser);
		
		/*
		 * password
		 */
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(47, 130, 82, 16);
		pnlCentral.add(lblNewLabel_1);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(139, 130, 130, 31);
		pnlCentral.add(txtPassword);
		
		/**
		 * Boton login
		 */
		btnLogin = new JButton("Entrar");
		btnLogin.setBounds(87, 195, 117, 29);
		pnlCentral.add(btnLogin);
		
	
		/*private void checkLogin() {
			String user = txtUser.getText();
			String password = new String(txtPassword.getPassword());
			boolean loginOk = false;
			
			if (user != null && user.length() > 0 && password != null && password.length() > 0) {
				/**
				 * Nos recorremos la lista de usuarios y abrimos la ventana principal si el
				 * usuario existe
				 */
				/*for (Usuario usuario : Servicio.getUsuarios()) {
					if (usuario.getNombre().equals(user) && usuario.getPassword().equals(password)) {
						VentanaPrincipal v = new VentanaPrincipal(usuario);
						v.setVisible(true);
						loginOk = true;
						break;
					}
				}*/
				/*try {
					Scanner sc = new Scanner(new File("usuarios.txt"));
					while (sc.hasNextLine()) {
						String linea = sc.nextLine();
						String[] campos = linea.split(";");
						for (int i = 0; i < campos.length; i++) {
							try {
								if (campos[i].equals(user) && campos[i+1].equals(password)) {
									Cliente u = new Cliente(campos[i], campos[i+1]);
									 VenrtanPanelAdmin v = new VenrtanPanelAdmin(u);
									v.setVisible(true);
									loginOk = true;
									break;
								}
							} catch(ArrayIndexOutOfBoundsException e) {
								dispose();
							}
						}
					}

				} catch (FileNotFoundException e1) {

				}

				if (loginOk) {
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o contraseÃ±a incorrecto.", "Login error",
							JOptionPane.OK_OPTION);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Necesita entrar con su usuario y contraseï¿½a.", "Error",
						JOptionPane.OK_OPTION);
			}
		}

		*/
		
		setVisible(true);
		
}
	public static void main(String[] args) {
	 new VentanaLogin();
	}
}
