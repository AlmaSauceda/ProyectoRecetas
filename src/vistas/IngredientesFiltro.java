package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.IngredientesFiltroControlador;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Dimension;

public class IngredientesFiltro extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblFiltrarIngredientes;
	private JLabel lblFiltrarPor;
	private JComboBox cmbFiltro;
	private JLabel lblDatos;
	public JComboBox cmbDatos;
	private JScrollPane scrollPane;
	private IngredientesFiltroControlador controlador;
	private JButton button;

	/**
	 * Create the frame.
	 */
	public IngredientesFiltro() {
		controlador = new IngredientesFiltroControlador(this);
		createGui();
	}

	private void createGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image imagen = new ImageIcon(this.getClass().getResource("/fondoIngredientes.jpg")).getImage();

		lblFiltrarIngredientes = new JLabel("FILTRAR INGREDIENTES");
		lblFiltrarIngredientes.setForeground(Color.BLACK);
		lblFiltrarIngredientes.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFiltrarIngredientes.setBackground(Color.BLACK);
		lblFiltrarIngredientes.setBounds(91, 32, 341, 33);
		contentPane.add(lblFiltrarIngredientes);

		lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setFont(new Font("Cambria Math", Font.BOLD, 15));
		lblFiltrarPor.setBounds(33, 75, 88, 18);
		contentPane.add(lblFiltrarPor);

		cmbFiltro = new JComboBox();
		cmbFiltro.setModel(new DefaultComboBoxModel(new String[] { "-Seleccione-", "Tipo", "Marca", "Caducidad" }));
		cmbFiltro.setBounds(127, 74, 107, 20);
		contentPane.add(cmbFiltro);

		lblDatos = new JLabel("Datos:");
		lblDatos.setFont(new Font("Cambria Math", Font.BOLD, 15));
		lblDatos.setBounds(264, 75, 57, 18);
		contentPane.add(lblDatos);

		cmbDatos = new JComboBox();
		cmbDatos.setModel(new DefaultComboBoxModel(new String[] { "-Seleccione-" }));
		cmbDatos.setBounds(331, 74, 101, 20);
		contentPane.add(cmbDatos);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 126, 429, 185);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Tipo", "Marca", "Caducidad", "Costo" }));
		scrollPane.setViewportView(table);
		
		button = new JButton("Atr\u00E1s");
		button.setPreferredSize(new Dimension(110, 30));
		button.setForeground(new Color(255, 165, 0));
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(352, 325, 110, 30);
		contentPane.add(button);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(imagen));
		fondo.setBounds(0, 0, 496, 371);
		contentPane.add(fondo);

		cmbDatos.addActionListener(controlador);
		cmbFiltro.addActionListener(controlador);
		cmbFiltro.addActionListener(controlador);
		button.addActionListener(controlador);
		this.setVisible(true);
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * @return the cmbFiltro
	 */
	public Object getCmbFiltro() {
		return cmbFiltro;
	}
	
	/**
	 * @return the cmbFiltro
	 */
	public JComboBox getCmbFiltroCmb() {
		return cmbFiltro;
	}
	

	/**
	 * @return the cmbFiltro
	 */
	public String getCmbFiltroString() {
		return cmbFiltro.getSelectedItem().toString();
	}

	/**
	 * @param cmbFiltro the cmbFiltro to set
	 */
	public void setCmbFiltro(JComboBox cmbFiltro) {
		this.cmbFiltro = cmbFiltro;
	}

	/**
	 * @return the cmbDatos
	 */
	public JComboBox getCmbDatos() {
		return cmbDatos;
	}

	
	/**
	 * @return the cmbDatos
	 */
	public JComboBox getCmbDatosCmb() {
		return cmbDatos;
	}

	/**
	 * @return the cmbDatos
	 */
	public String getCmbDatosString() {
		return cmbDatos.getSelectedItem().toString();
	}


	/**
	 * @return the button
	 */
	public Object getButton() {
		return button;
	}

	public void setCmbDatos(JComboBox cargarComboFiltro) {
		this.cmbDatos = cargarComboFiltro;
		
	}
}
