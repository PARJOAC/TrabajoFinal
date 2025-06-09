package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorCajero;
import controlador.ControladorTema;
import util.Logotipo;

import java.awt.*;
import java.io.Serializable;

/**
 * Vista principal del cajero. Muestra dos tablas (productos y carrito) y
 * permite realizar una compra.
 */
public class VistaCajeros extends JFrame implements Serializable {

	private static final long serialVersionUID = 2352856676015466747L;

	private final JTabbedPane pestanas;
	private JTable tablaProductos;
	private DefaultTableModel modeloTabla;
	private JTable tablaCarrito;
	private DefaultTableModel modeloCarrito;
	private JTextField campoDineroCliente;
	private JLabel etiquetaTotal;
	private JLabel etiquetaCambio;
	private JButton botonAñadir;
	private JButton botonEliminar;
	private JButton botonFinalizar;

	public VistaCajeros() {
		super("Panel de Cajero");
		setIconoVentana();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(1500, 900));
		setLocationRelativeTo(null);

		pestanas = new JTabbedPane();
		JPanel panelCaja = new JPanel(new BorderLayout(10, 10));

		JPanel panelCentro = crearPanelCentro();
		JPanel zonaInferior = crearZonaInferior();

		panelCaja.add(panelCentro, BorderLayout.CENTER);
		panelCaja.add(zonaInferior, BorderLayout.SOUTH);
		pestanas.addTab("Caja", panelCaja);

		add(pestanas);
	}

	private void setIconoVentana() {
		Image imagen = Logotipo.logotipoCabecera(this);
		if (imagen != null) {
			setIconImage(imagen);
		}
	}

	private JPanel crearPanelCentro() {
		JPanel panelCentro = new JPanel(new GridLayout(1, 2, 10, 10));
		panelCentro.add(crearTablaProductos());
		panelCentro.add(crearTablaCarrito());
		return panelCentro;
	}

	@SuppressWarnings("serial")
	private JScrollPane crearTablaProductos() {
		String[] columnasProductos = { "Nombre", "Precio", "Disponibles" };
		modeloTabla = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modeloTabla.setColumnIdentifiers(columnasProductos);
		tablaProductos = new JTable(modeloTabla);
		JScrollPane scroll = new JScrollPane(tablaProductos);
		scroll.setBorder(BorderFactory.createTitledBorder("Productos disponibles"));
		return scroll;
	}

	@SuppressWarnings("serial")
	private JScrollPane crearTablaCarrito() {
		String[] columnasCarrito = { "Nombre", "Precio", "Cantidad", "Subtotal" };
		modeloCarrito = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modeloCarrito.setColumnIdentifiers(columnasCarrito);
		tablaCarrito = new JTable(modeloCarrito);
		JScrollPane scroll = new JScrollPane(tablaCarrito);
		scroll.setBorder(BorderFactory.createTitledBorder("Carrito de compra"));
		return scroll;
	}

	private JPanel crearZonaInferior() {
		JPanel zonaInferior = new JPanel(new BorderLayout());
		zonaInferior.add(crearPanelTotales(), BorderLayout.CENTER);
		zonaInferior.add(crearPanelBotones(), BorderLayout.SOUTH);
		return zonaInferior;
	}

	private JPanel crearPanelTotales() {
		etiquetaTotal = new JLabel("Total: 0.00 €");
		etiquetaCambio = new JLabel("Cambio: 0.00 €");
		campoDineroCliente = new JTextField();

		JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
		panel.add(etiquetaTotal);
		panel.add(new JLabel("Efectivo entregado:"));
		panel.add(campoDineroCliente);
		panel.add(etiquetaCambio);
		panel.add(new JLabel()); // espacio vacío
		panel.add(new JLabel()); // espacio vacío
		return panel;
	}

	private JPanel crearPanelBotones() {
		botonAñadir = new JButton("Añadir");
		botonEliminar = new JButton("Eliminar");
		botonFinalizar = new JButton("Finalizar");

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel.add(botonAñadir);
		panel.add(botonEliminar);
		panel.add(botonFinalizar);
		return panel;
	}

	// Getters
	public JTable getTablaProductos() { return tablaProductos; }
	public DefaultTableModel getModeloTabla() { return modeloTabla; }
	public JTable getTablaCarrito() { return tablaCarrito; }
	public DefaultTableModel getModeloCarrito() { return modeloCarrito; }
	public JTextField getCampoDineroCliente() { return campoDineroCliente; }
	public JLabel getEtiquetaTotal() { return etiquetaTotal; }
	public JLabel getEtiquetaCambio() { return etiquetaCambio; }
	public JButton getBotonAñadir() { return botonAñadir; }
	public JButton getBotonEliminar() { return botonEliminar; }
	public JButton getBotonFinalizar() { return botonFinalizar; }

	public void control(ControladorCajero ctr, ControladorTema ctrTema) {
		botonAñadir.addActionListener(ctr);
		botonEliminar.addActionListener(ctr);
		botonFinalizar.addActionListener(ctr);

		addKeyListener(ctrTema);
		setFocusable(true);
	}
	
}
