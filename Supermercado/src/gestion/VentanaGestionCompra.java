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
import bases.BaseCompra;
import bases.BaseProducto;
import bases.DBException;


public class VentanaGestionCompra extends JFrame{

	BaseCompra bc = new BaseCompra();
	BaseProducto bp = new BaseProducto();
	
	JPanel listaPanel = new JPanel();
	JPanel infoPanel = new JPanel();
	JPanel acciones = new JPanel(); 
	JPanel productosPanel = new JPanel(); 
	
	JLabel clientejl = new JLabel("Cliente");
	JTextField clientejt = new JTextField();
	JLabel codigojl = new JLabel("Código");
	JTextField codigojt = new JTextField();
	JLabel preciojl = new JLabel("Precio");
	JTextField preciojt = new JTextField();
	JLabel fechajl = new JLabel("Fecha");
	JTextField fechajt = new JTextField();
	JLabel cosascompradasjl = new JLabel("Cosas compradas");
	JTextField cosascompradasjt = new JTextField();


	JLabel listaC = new JLabel("Compras");
	JList listaCompras = new JList<>();
	JScrollPane listaScroll = new JScrollPane(listaCompras);
	DefaultListModel model = new DefaultListModel<Compra>();
	
	JComboBox productosDisponibles = new JComboBox();;
	
	JLabel listaP = new JLabel("Productos comprados");
	JList listaProductos = new JList<Producto>();
	JScrollPane listaScrollP = new JScrollPane(listaProductos);
	DefaultListModel modeloP = new DefaultListModel<Producto>();
	
	JButton nuevo = new JButton("NUEVO");
	JButton cargar = new JButton("CARGAR");
	JButton sumar = new JButton("+");
	JButton restar = new JButton("-");
	JButton eliminar = new JButton("ELIMINAR");
	
	
	
	public VentanaGestionCompra() {
		
		setLayout(new BorderLayout());
		setSize(900,500);
		setTitle("Gestión compras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    
	    infoPanel.setLayout(new GridLayout(5,2));
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
	    acciones.add(cargar);
	    acciones.add(eliminar);
	    acciones.add(productosDisponibles);
	    acciones.add(sumar);
	    acciones.add(restar);
	    
	    
	    productosPanel.add(listaP, BorderLayout.PAGE_START);
	    productosPanel.add(listaScrollP, BorderLayout.CENTER);

	    listaCompras.setModel(model);
	    listaProductos.setModel(modeloP);
    
	    listaPanel.add(listaC, BorderLayout.PAGE_START);
	    listaPanel.add(listaScroll, BorderLayout.CENTER);
	    
	    
	    infoPanel.setLayout(new GridLayout(8,2));
	    infoPanel.add(codigojl);
	    infoPanel.add(codigojt);
	    infoPanel.add(clientejl);
	    infoPanel.add(clientejt);
	    infoPanel.add(preciojl);
	    infoPanel.add(preciojt);
	    infoPanel.add(fechajl);
	    infoPanel.add(fechajt);
	    infoPanel.add(cosascompradasjl);
	    infoPanel.add(cosascompradasjt);
	    
	    
	    
	    
	    //Botones funcionamiento
	    
	    eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Eliminar compra de db
            	Compra c = (Compra) listaCompras.getSelectedValue();
            	model.removeElement(c);
            	try {
					bc.connect("compra.db");
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

					bc.connect("compra.db");
					bc.createCompraTable();

					String cod, cliente, fecha;
					
					cod = codigojt.getText();
					cliente = clientejt.getText();
					fecha = fechajt.getText();
					
					Compra c = new Compra();
					
					c.setCodigoCompra(Integer.parseInt(cod));
					c.setDniCliente(cliente);
					c.setFecha(fecha);
					
					Double precioP = 0.0;
					
					for(int i=0; i < listaProductos.getModel().getSize(); i++){	
				        Producto p = (Producto) modeloP.getElementAt(i);
				        precioP = precioP + p.getPrecio();
					} 
					
					c.setPrecio(precioP);
					
					String productosDeCompra = "";
					
					for (int i = 0; i < listaProductos.getModel().getSize(); i++) {
						Producto p = (Producto) modeloP.getElementAt(i);
						productosDeCompra = productosDeCompra + " ||| " + p;
					}
					
					c.setNombreProducto(productosDeCompra);
					
					bc.storeCo(c);
					
				

				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
            	clientejt.setText(null);
				fechajt.setText(null);
				preciojt.setText(null);
				codigojt.setText(null);
				modeloP.clear();
				
				
            }
        });
        
      //Boton para cargar informacion de la BD a la tabla
	    cargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Eliminar producto de db
            	
            	model.clear();
            	
            	try {
            		bc.connect("compra.db");
            		
            		ArrayList<Integer> codigos = bc.getCodigoCompra();
            		
            		for (int i = 0; i < codigos.size(); i++) {
            			Integer codCom = codigos.get(i);
            			Compra c = bc.getCompra(codCom);
            			model.addElement(c);
						
					}
	
				} catch (DBException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	
            	
            }
        });
	    
	    sumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Sumar producto a la lista de la compra
            	Producto p = (Producto) productosDisponibles.getSelectedItem();
            	Integer stockP = p.getStock();
            	stockP = stockP - 1;
            	p.setStock(stockP);
            	try {
					bp.connect("producto.db");
					bp.update(p);
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	
            	modeloP.addElement(p);
            }
        });
	    
	    restar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Sumar producto a la lista de la compra
            	Producto p = (Producto) productosDisponibles.getSelectedItem();
            	Integer stockP = p.getStock();
            	stockP = stockP + 1;
            	p.setStock(stockP);
            	try {
					bp.connect("producto.db");
					bp.update(p);
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	modeloP.removeElement(p);
            }
        });
	    
	    //
	    
	  //Ver valores del producto seleccionado en el TextField correspondiente
	    MouseListener seleccionar = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
            	Compra c = (Compra) listaCompras.getSelectedValue();
            	clientejt.setText(c.getDniCliente());
            	codigojt.setText(""+c.getCodigoCompra());
            	fechajt.setText(c.getFecha());
            	preciojt.setText(""+c.getPrecio());
            	cosascompradasjt.setText(c.getNombreProducto());
            	
         }
           
		};
		
		MouseListener seleccionP = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				Producto p = (Producto) listaProductos.getSelectedValue();
			}
		};
		
		listaCompras.addMouseListener(seleccionP);
		listaCompras.addMouseListener(seleccionar);

	    setResizable(false);
	    setVisible(true);

}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaGestionCompra v  = new VentanaGestionCompra();
	}
	
}
