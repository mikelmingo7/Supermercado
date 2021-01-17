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
import clases.Pedido;
import clases.Producto;

import bases.BasePedido;
import bases.BaseProducto;
import bases.DBException;


public class VentanaGestionPedido extends JFrame{

	BasePedido bpe = new BasePedido();
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
	JLabel direccionjl = new JLabel("Direccion");
	JTextField direccionjt = new JTextField();

	JLabel listaP = new JLabel("Pedidos");
	JList listaPedidos = new JList<>();
	JScrollPane listaScroll = new JScrollPane(listaPedidos);
	DefaultListModel model = new DefaultListModel<Compra>();
	
	JComboBox productosDisponibles = new JComboBox();;
	
	JLabel listaPC = new JLabel("Productos comprados");
	JList listaProductos = new JList<Producto>();
	JScrollPane listaScrollP = new JScrollPane(listaProductos);
	DefaultListModel modeloP = new DefaultListModel<Producto>();
	
	JButton nuevo = new JButton("NUEVO");
	JButton cargar = new JButton("CARGAR");
	JButton sumar = new JButton("+");
	JButton restar = new JButton("-");
	JButton eliminar = new JButton("ELIMINAR");
	
	
	
	public VentanaGestionPedido() {
		
		setLayout(new BorderLayout());
		setSize(900,500);
		setTitle("Gestión Pedidos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	    acciones.add(cargar);
	    acciones.add(eliminar);
	    acciones.add(productosDisponibles);
	    acciones.add(sumar);
	    acciones.add(restar);
	    
	    
	    productosPanel.add(listaP, BorderLayout.PAGE_START);
	    productosPanel.add(listaScrollP, BorderLayout.CENTER);

	    listaPedidos.setModel(model);
	    listaProductos.setModel(modeloP);
    
	    listaPanel.add(listaP, BorderLayout.PAGE_START);
	    listaPanel.add(listaScroll, BorderLayout.CENTER);
	    
	    
	    infoPanel.setLayout(new GridLayout(10,2));
	    infoPanel.add(codigojl);
	    infoPanel.add(codigojt);
	    infoPanel.add(clientejl);
	    infoPanel.add(clientejt);
	    infoPanel.add(preciojl);
	    infoPanel.add(preciojt);
	    infoPanel.add(fechajl);
	    infoPanel.add(fechajt);
	    infoPanel.add(direccionjl);
	    infoPanel.add(direccionjt);
	    
	    
	    
	    
	    
	    //Botones funcionamiento
	    
	    eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Eliminar compra de db
            	Pedido p = (Pedido) listaPedidos.getSelectedValue();
            	model.removeElement(p);
            	try {
					bpe.connect("pedido.db");
					bpe.delete(p);
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

					bpe.connect("pedido.db");
					bpe.createPedidoTable();

					String cod, cliente, fecha, dir;
					
					cod = codigojt.getText();
					cliente = clientejt.getText();
					fecha = fechajt.getText();
					dir=direccionjt.getText();
					
					Pedido p = new Pedido();
					
					p.setCodigoCompra(Integer.parseInt(cod));
					p.setDniCliente(cliente);
					p.setFecha(fecha);
					p.setDireccion(dir);
					
					Double precioP = 0.0;
					
					for(int i=0; i < listaProductos.getModel().getSize(); i++){	
				        Producto pr = (Producto) modeloP.getElementAt(i);
				        precioP = precioP + pr.getPrecio();
					} 
					
					p.setPrecio(precioP);
					
					String productosDeCompra = "";
					
					for (int i = 0; i < listaProductos.getModel().getSize(); i++) {
						Producto pr = (Producto) modeloP.getElementAt(i);
						productosDeCompra = productosDeCompra + ";" + pr;
					}
					
					p.setNombreProducto(productosDeCompra);
					
					bpe.storeP(p);
				

				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
            	clientejt.setText(null);
				fechajt.setText(null);
				preciojt.setText(null);
				codigojt.setText(null);
				direccionjt.setText(null);
				
            }
        });
        
      //Boton para cargar informacion de la BD a la tabla
	    cargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Eliminar producto de db
            	
            	model.clear();
            	
            	try {
            		bpe.connect("pedido.db");
            		
            		ArrayList<Integer> codigos = bpe.getCodigoCompra();
            		
            		for (int i = 0; i < codigos.size(); i++) {
            			Integer codCom = codigos.get(i);
            			Pedido p = (Pedido) bpe.getPedido(codCom);
            			model.addElement(p);
						
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
            	modeloP.addElement(p);
            }
        });
	    
	    restar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Sumar producto a la lista de la compra
            	Producto p = (Producto) productosDisponibles.getSelectedItem();
            	modeloP.removeElement(p);
            }
        });
	    
	    //
	    
	  //Ver valores del producto seleccionado en el TextField correspondiente
	    MouseListener seleccionar = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
            	Pedido p = (Pedido) listaPedidos.getSelectedValue();
            	clientejt.setText(p.getDniCliente());
            	codigojt.setText(""+p.getCodigoCompra());
            	fechajt.setText(p.getFecha());
            	preciojt.setText(""+p.getPrecio());
            	direccionjt.setText(p.getDireccion());
            	
         }
           
		};
		
		MouseListener seleccionP = new MouseAdapter() {
			public void mouseClicked(MouseEvent mouseEvent) {
				Producto p = (Producto) listaProductos.getSelectedValue();
			}
		};
		
		listaPedidos.addMouseListener(seleccionP);
		listaPedidos.addMouseListener(seleccionar);

	    setResizable(false);
	    setVisible(true);

}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaGestionPedido v  = new VentanaGestionPedido();
	}
	
}