package gestion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import bases.BaseTrabajador;
import bases.DBException;
import clases.Producto;
import clases.Trabajador;


public class VentanaGestionTrabajadores extends JFrame{
	
	BaseTrabajador bt=new BaseTrabajador();
	JList listaTrabajadores = new JList<>();
	JScrollPane listaScroll = new JScrollPane(listaTrabajadores);
	DefaultListModel<Trabajador> model = new DefaultListModel<Trabajador>();
	
	JPanel listaPanel = new JPanel();
	JPanel infoPanel = new JPanel(); 
	JPanel acciones = new JPanel();
	
	JLabel nombre=new JLabel("Nombre");
	JTextField nom=new JTextField();
	JLabel apellidos=new JLabel("Apellidos");
	JTextField ap=new JTextField();
	JLabel DNI=new JLabel("DNI");
	JTextField dni=new JTextField();
	JLabel salario=new JLabel("Salario");
	JTextField sal=new JTextField();
	JLabel horario=new JLabel("Horario");
	JTextField hor=new JTextField();
	JLabel puesto=new JLabel("Puesto");
	JTextField pues=new JTextField();
	JLabel horasTrabajadas=new JLabel("Horas trabajadas");
	JTextField horT=new JTextField();
	JLabel disponibilidad=new JLabel("Disponibilidad");
	JTextField dis=new JTextField();
	
	JButton nuevo = new JButton("NUEVO");
	JButton cargar = new JButton("CARGAR");
	JButton guardar = new JButton("GUARDAR");
	JButton eliminar = new JButton("ELIMINAR");
	
	public VentanaGestionTrabajadores(){
		
		
		

		setSize(700,400);
		setTitle("Ventana de Gestión de Trabajadores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		infoPanel.setLayout(new GridLayout(8,2));
	    listaPanel.setLayout(new GridLayout(1,1));
	    acciones.setLayout(new GridLayout(1,4));
	    
	    acciones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    listaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    
	    add(acciones, BorderLayout.NORTH);
	    add(listaPanel, BorderLayout.LINE_START);
	    add(infoPanel, BorderLayout.CENTER);
		
	    acciones.add(nuevo);
	    acciones.add(guardar);
	    acciones.add(cargar);
	    acciones.add(eliminar);
	    
	    
	    infoPanel.add(nombre);
	    infoPanel.add(nom);
	    infoPanel.add(apellidos);
	    infoPanel.add(ap);
	    infoPanel.add(DNI);
	    infoPanel.add(dni); 
	    infoPanel.add(salario);
	    infoPanel.add(sal);
	    infoPanel.add(horario);
	    infoPanel.add(hor);
	    infoPanel.add(puesto);
	    infoPanel.add(pues);
	    infoPanel.add(horasTrabajadas);
	    infoPanel.add(horT);
	    infoPanel.add(disponibilidad);
	    infoPanel.add(dis);
	    
	    
		listaTrabajadores.setModel(model);
		listaPanel.add(listaScroll);
	    
	    
	    //Botones funcionamiento
	    
	    eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Eliminar cliente de db
            	Trabajador t = (Trabajador) listaTrabajadores.getSelectedValue();
            	model.removeElement(t);
            	try {
					bt.connect("trabajador.db");
					bt.delete(t);
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });

        nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Crear trabajador de db
            	try {

					bt.connect("trabajador.db");
					bt.createTrabajadorTable();

					String nomb,apel,dnis,sala,hora, puest, htraba, dispo;
					
					nomb = nom.getText();
					apel = ap.getText();
					dnis = dni.getText();
					sala = sal.getText();
					hora = hor.getText();
					puest = pues.getText();
					htraba = horT.getText();
					dispo = dis.getText();
					
					
					Trabajador t = new Trabajador();
					
					
					t.setNombre(nomb);
					t.setApellidos(apel);
					t.setDni(dnis);
					t.setSalario(Integer.parseInt(sala));
					t.setHorario(hora);
					t.setPuesto(puest);
					t.setHoras_trabajadas(Integer.parseInt(htraba));
					t.setDisponibilidad(dispo);					
					
					bt.storeT(t);
					
					
				
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
            	nom.setText(null);
				ap.setText(null);
				dni.setText(null);
				sal.setText(null);
				hor.setText(null);
				pues.setText(null);
				hor.setText(null);
				dis.setText(null);
				
            	
            }
        });
        
        guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Update de cliente en DB
				

				try {
					bt.connect("trabajador.db");
				
				

				String nomb,apel,dnis,sala,hora, puest, htraba, dispo;
				
				nomb = nom.getText();
				apel = ap.getText();
				dnis = dni.getText();
				sala = sal.getText();
				hora = hor.getText();
				puest = pues.getText();
				htraba = horT.getText();
				dispo = dis.getText();

				Trabajador t = new Trabajador();
				
				t.setNombre(nomb);
				t.setApellidos(apel);
				t.setDni(dnis);
				t.setSalario(Integer.parseInt(sala));
				t.setHorario(hora);
				t.setPuesto(puest);
				t.setHoras_trabajadas(Integer.parseInt(htraba));
				t.setDisponibilidad(dispo);				
				
				bt.update(t);
				
				}catch (DBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		});
        
        //Boton para cargar informacion de la BD a la tabla
	    cargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Eliminar producto de db
            	
            	model.clear();
            	
            	try {
            		bt.connect("trabajador.db");
            		ArrayList<String> dnis = bt.getDni();
            		
            		for (int i = 0; i < dnis.size(); i++) {
            			String cod = dnis.get(i);
            			Trabajador t = bt.getTrabajador(cod);
            			model.addElement(t);
						
					}
	
				} catch (DBException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	
            	
            }
        });
	    
	    //Ver valores del producto seleccionado en el TextField correspondiente
	    MouseListener seleccionar = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
            	Trabajador t = (Trabajador) listaTrabajadores.getSelectedValue();
            	nom.setText(t.getNombre());
            	ap.setText(t.getApellidos());
            	dni.setText(t.getDni());
            	sal.setText(""+t.getSalario());
            	hor.setText(t.getHorario());
            	pues.setText(t.getPuesto());
            	horT.setText(""+t.getHoras_trabajadas());
            	dis.setText(t.getDisponibilidad());
         }
		};
		
		listaTrabajadores.addMouseListener(seleccionar);
		
	    
	    setVisible(true);
				
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaGestionTrabajadores ventana=new VentanaGestionTrabajadores();
	}

}
