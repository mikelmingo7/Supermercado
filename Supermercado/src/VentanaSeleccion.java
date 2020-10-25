import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaSeleccion {

	public VentanaSeleccion(){
		JPanel panel=new JPanel();	
		JFrame ventana=new JFrame();
		ventana.setSize(500,300);
		ventana.setTitle("Ventana de Selección");
		ventana.setVisible(true);
		ventana.add(panel);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		panel.setLayout(null);
		
		JButton administrador=new JButton("Administrador");
			administrador.setBounds(60, 100, 150, 30);
			panel.add(administrador);
			
		JButton usuario=new JButton("Usuario");
			usuario.setBounds(250, 100, 150, 30);
			panel.add(usuario);	
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new VentanaSeleccion();
		
	}
}
