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
	
	
	JList listaTrabajadores = new JList<>();
	JScrollPane listaScroll = new JScrollPane(listaTrabajadores);
	DefaultListModel model = new DefaultListModel<Trabajador>();
	
	JPanel panel1=new JPanel();
	JPanel panel2=new JPanel();
	JPanel panel3=new JPanel();
	
	JLabel nombre=new JLabel("     nombre");
	JTextField nom=new JTextField();
	JLabel apellidos=new JLabel("      apellidos");
	JTextField ap=new JTextField();
	JLabel DNI=new JLabel("     DNI");
	JTextField dni=new JTextField();
	JLabel salario=new JLabel("     salario");
	JTextField sal=new JTextField();
	JLabel horario=new JLabel("     horario");
	JTextField hor=new JTextField();
	JLabel puesto=new JLabel("     puesto");
	JTextField pues=new JTextField();
	JLabel horasTrabajadas=new JLabel("     horas trabajadas");
	JTextField horT=new JTextField();
	JLabel disponibilidad=new JLabel("     disponibilidad");
	JTextField dis=new JTextField();
	
	JButton nuevo = new JButton("NUEVO");
	JButton guardar = new JButton("GUARDAR");
	JButton eliminar = new JButton("ELIMINAR");
	
	public VentanaGestionTrabajadores(){
		
		
		

		setSize(700,400);
		setTitle("Ventana de Gestión de Trabajadores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null); 
		
		add(panel1);
		add(panel2);
		add(panel3);
		
		panel1.add(nuevo);
	    panel1.add(guardar);
	    panel1.add(eliminar);
	    
	    panel2.setLayout(new GridLayout(8,2));
	    panel2.add(nombre);
	    panel2.add(nom);
	    panel2.add(apellidos);
	    panel2.add(ap);
	    panel2.add(DNI);
	    panel2.add(dni);
	    panel2.add(salario);
	    panel2.add(sal);
	    panel2.add(horario);
	    panel2.add(hor);
	    panel2.add(puesto);
	    panel2.add(pues);
	    panel2.add(horasTrabajadas);
	    panel2.add(horT);
	    panel2.add(disponibilidad);
	    panel2.add(dis);
	    
	    panel1.setBounds(0,0,700,80);
	    panel2.setBounds(0,80,700,120);
	    panel3.setBounds(100,200,400,200);
	    
		listaTrabajadores.setModel(model);
	    panel3.add(listaScroll);
		
		
	    
	    setVisible(true);
				
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaGestionTrabajadores ventana=new VentanaGestionTrabajadores();
	}

}
