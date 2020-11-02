import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VentanaGestionTrabajadores extends JFrame{

	public VentanaGestionTrabajadores(){
		JPanel panel=new JPanel();	
		JFrame ventana=new JFrame();
		
		JLabel nombre=new JLabel("nombre");
		JTextField nom=new JTextField();
		JLabel apellidos=new JLabel("apellidos");
		JTextField ap=new JTextField();
		JLabel DNI=new JLabel("DNI");
		JTextField dni=new JTextField();
		JLabel salario=new JLabel("salario");
		JTextField sal=new JTextField();
		JLabel horario=new JLabel("horario");
		JTextField hor=new JTextField();
		JLabel puesto=new JLabel("puesto");
		JTextField pues=new JTextField();
		JLabel horasTrabajadas=new JLabel("horas trabajadas");
		JTextField horT=new JTextField();
		JLabel disponibilidad=new JLabel("disponibilidad");
		JTextField dis=new JTextField();
		
		JButton nuevo = new JButton("NUEVO");
		JButton guardar = new JButton("GUARDAR");
		JButton eliminar = new JButton("ELIMINAR");
		
		panel.add(nuevo);
	    panel.add(guardar);
	    panel.add(eliminar);
	    
	    JList listaTrabajadores = new JList<>();
		JScrollPane listaScroll = new JScrollPane(listaTrabajadores);
		DefaultListModel model = new DefaultListModel<Trabajador>();
		listaTrabajadores.setModel(model);
	    panel.add(listaScroll);
		
		ventana.setSize(500,300);
		ventana.setTitle("Ventana de Gestión de Trabajadores");
		ventana.setVisible(true);
		ventana.add(panel);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(8,2)); //Cambiar esto
		panel.setVisible(true);
		
		panel.add(nombre);
		panel.add(nom);
		panel.add(apellidos);
		panel.add(ap);
		panel.add(DNI);
		panel.add(dni);
		panel.add(salario);
		panel.add(sal);
		panel.add(horario);
		panel.add(hor);
		panel.add(puesto);
		panel.add(pues);
		panel.add(horasTrabajadas);
		panel.add(horT);
		panel.add(disponibilidad);
		panel.add(dis);
			
				
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaGestionTrabajadores ventana=new VentanaGestionTrabajadores();
	}

}
