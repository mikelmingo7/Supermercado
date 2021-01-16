package gestion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import clases.Compra;
import clases.Producto;
import bases.BaseProducto;
import bases.DBException;


public class VentanaGestionCompra extends JFrame{

	BaseProducto bp=new BaseProducto();
	
	JPanel listaPanel = new JPanel();
	JPanel infoPanel = new JPanel();
	JPanel acciones = new JPanel(); 
	JPanel productosPanel = new JPanel(); 
	
	JLabel clientejl = new JLabel("Cliente");
	JTextField clientejt = new JTextField();
	JLabel preciojl = new JLabel("Precio");
	JTextField preciojt = new JTextField();
	JLabel fechajl = new JLabel("Fecha");
	JTextField fechajt = new JTextField();


	JLabel listaC = new JLabel("Compras");
	JList listaCompras = new JList<>();
	JScrollPane listaScroll = new JScrollPane(listaCompras);
	DefaultListModel model = new DefaultListModel<Compra>();
	
	JComboBox productosDisponibles = new JComboBox();;
	
	JLabel listaP = new JLabel("Productos comprados");
	JList listaProductos = new JList<>();
	JScrollPane listaScrollP = new JScrollPane(listaProductos);
	DefaultListModel modeloP = new DefaultListModel<Producto>();
	
	JButton nuevo = new JButton("NUEVO");
	JButton cargar = new JButton("CARGAR");
	JButton sumar = new JButton("+");
	JButton guardar = new JButton("GUARDAR");
	JButton eliminar = new JButton("ELIMINAR");
	
	
	
	public VentanaGestionCompra() {
		
		setLayout(new BorderLayout());
		setSize(900,500);
		setTitle("Gestión compras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    
	    infoPanel.setLayout(new GridLayout(6,2));
	    listaPanel.setLayout(new BorderLayout());
	    acciones.setLayout(new GridLayout(1,6));
	    productosPanel.setLayout(new BorderLayout());
	    
	    acciones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    listaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    productosPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    
	    add(acciones, BorderLayout.NORTH);
	    add(listaPanel, BorderLayout.LINE_START);
	    add(infoPanel, BorderLayout.CENTER);
	    add(productosPanel, BorderLayout.LINE_END);
	    
	    
	    try {
			bp.connect("producto.db");
			ArrayList<Integer> codigos;
			try {
				codigos = bp.getCodigo();
				for (int i = 0; i < codigos.size(); i++) {
					Integer cod = codigos.get(i);
        			Producto p = bp.getProducto(cod);
        			productosDisponibles.addItem(p);
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
		} catch (DBException e1) {
			
		}
	    
	    

	    acciones.add(nuevo);
	    acciones.add(guardar);
	    acciones.add(cargar);
	    acciones.add(eliminar);
	    acciones.add(productosDisponibles);
	    acciones.add(sumar);
	    
	    
	    productosPanel.add(listaP, BorderLayout.PAGE_START);
	    productosPanel.add(listaScrollP, BorderLayout.CENTER);

	    listaCompras.setModel(model);
    
	    listaPanel.add(listaC, BorderLayout.PAGE_START);
	    listaPanel.add(listaScroll, BorderLayout.CENTER);
	    
	    
	    infoPanel.setLayout(new GridLayout(8,2));
	    infoPanel.add(clientejl);
	    infoPanel.add(clientejt);
	    infoPanel.add(preciojl);
	    infoPanel.add(preciojt);
	    infoPanel.add(fechajl);
	    infoPanel.add(fechajt);
	    
	    
	    
	    
	    //Botones funcionamiento
	    
	    eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Eliminar compra de db
            	Compra c = (Compra) listaCompras.getSelectedValue();
            	model.removeElement(p);
            	try {
					bc.connect("compras.db");
					bc.delete(c);
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            }
        });

        nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Crear cliente de db
            	
            	try {

					bc.connect("compras.db");
					bc.createProductoTable();

					String cliente, fecha;
					
					cliente = clientejt.getText();
					fecha = preciojt.getText();
					
					Compra c = new Compra();
					
					c.setDniCliente(cliente);;
					c.setFecha(fecha);;
					
					Double precioP = 0.0;
					
					for(int i=0; i < modeloP.getSize(); i++){	
				        Producto p = (Producto) modeloP.getElementAt(i);
				        precioP = precioP + p.getPrecio();
					} 
					
					c.setPrecio(precioP);
					
					
					bc.storeP(c);
					
					
				
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				nombrejt.setText(null);
				codigojt.setText(null);
				seccionjt.setText(null);
				marcajt.setText(null);
				pesojt.setText(null);
				preciojt.setText(null);
            }
        });
        
        guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Update de cliente en DB
				
			}
		});

	    setResizable(false);
	    setVisible(true);

}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaGestionCompra v  = new VentanaGestionCompra();
	}
	
}
