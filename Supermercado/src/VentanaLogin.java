import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaLogin  extends JFrame{
	private JPanel pnlCentral;
	private JPasswordField txtPassword;
	private JTextField txtUser;
	private JButton btnLogin;
	private JButton btnCrearUsuario;
	
public VentanaLogin() {
		setTitle("Inicio de sesion");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		setSize(300, 300);
		
		 Font fuente = new Font("Times new roman", Font.CENTER_BASELINE, 15);
		 
		 
		 pnlCentral = new JPanel();
		 pnlCentral.setBackground(Color.GREEN);
			
		getContentPane().add(pnlCentral, BorderLayout.CENTER);
		
		
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

		
		
		
		setVisible(true);
		
}
	public static void main(String[] args) {
	 new VentanaLogin();
	}
}
