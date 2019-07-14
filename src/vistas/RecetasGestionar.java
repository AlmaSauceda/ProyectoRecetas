package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.RecetasControlador;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class RecetasGestionar extends JFrame {

	private RecetasControlador controller;
	private JPanel contentPane;
	private JLabel lblRegistrarIngredientes;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnAtrasVentana;
	private JComboBox cmbPlatillo;
	private JLabel label;
	private JLabel label_1;
	private JTextField txtTitulo;
	private JLabel label_2;
	private JTextArea txtProcedimiento;
	private JLabel label_3;
	private JTextField txtTerminologia;
	private JLabel label_4;
	private JSpinner txtComenzales;
	private JLabel label_5;
	private JTextField txtImplementacion;
	private JTextField txtPorcion;
	private JLabel label_6;
	private JLabel label_7;
	private JSpinner txtCantidad;
	private JLabel label_8;
	private JComboBox cmbIngrediente;
	private JScrollPane scrollPane;
	private JButton btnAgregar;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public RecetasGestionar() {
		createGUI();
		controller = new RecetasControlador(this);
		controller.CargarCombosGes();
	}

	public void createGUI() {
		controller = new RecetasControlador(this);
		setResizable(false);
		setBackground(new Color(255, 165, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblRegistrarIngredientes = new JLabel("GESTIONAR RECETAS");
		lblRegistrarIngredientes.setBounds(321, 11, 281, 33);
		lblRegistrarIngredientes.setForeground(new Color(255, 255, 255));
		lblRegistrarIngredientes.setFont(new Font("Andalus", Font.BOLD, 25));
		contentPane.add(lblRegistrarIngredientes);

		btnAnterior = new JButton("ANTERIOR");
		btnAnterior.setBounds(154, 424, 110, 30);
		btnAnterior.setPreferredSize(new Dimension(110, 30));
		btnAnterior.setForeground(new Color(255, 165, 0));
		btnAnterior.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnterior.setBackground(new Color(255, 255, 204));
		contentPane.add(btnAnterior);

		btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setBounds(289, 424, 110, 30);
		btnSiguiente.setPreferredSize(new Dimension(110, 30));
		btnSiguiente.setForeground(new Color(255, 165, 0));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSiguiente.setBackground(new Color(255, 255, 204));
		contentPane.add(btnSiguiente);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(446, 424, 110, 30);
		btnActualizar.setPreferredSize(new Dimension(110, 50));
		btnActualizar.setForeground(new Color(255, 165, 0));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBackground(Color.WHITE);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(583, 424, 110, 30);
		btnEliminar.setPreferredSize(new Dimension(110, 50));
		btnEliminar.setForeground(new Color(255, 165, 0));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBackground(Color.WHITE);
		contentPane.add(btnEliminar);

		btnAtrasVentana = new JButton("Atr\u00E1s");
		btnAtrasVentana.setBounds(758, 424, 110, 30);

		btnAtrasVentana.setPreferredSize(new Dimension(110, 30));
		btnAtrasVentana.setForeground(new Color(255, 165, 0));
		btnAtrasVentana.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtrasVentana.setBackground(SystemColor.controlHighlight);
		contentPane.add(btnAtrasVentana);

		cmbPlatillo = new JComboBox();
		cmbPlatillo.setModel(new DefaultComboBoxModel(new String[] { "Seleccione" }));
		cmbPlatillo.setBounds(166, 55, 293, 20);
		contentPane.add(cmbPlatillo);

		label = new JLabel("Platillo:");
		label.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label.setBounds(51, 57, 101, 18);
		contentPane.add(label);

		label_1 = new JLabel("T\u00EDtulo:");
		label_1.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_1.setBounds(51, 99, 49, 18);
		contentPane.add(label_1);

		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(166, 98, 293, 20);
		contentPane.add(txtTitulo);

		label_2 = new JLabel("Procedimiento:");
		label_2.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_2.setBounds(51, 148, 111, 18);
		contentPane.add(label_2);

		txtProcedimiento = new JTextArea();
		txtProcedimiento.setRows(6);
		txtProcedimiento.setLineWrap(true);
		txtProcedimiento.setColumns(10);
		txtProcedimiento.setBounds(166, 129, 293, 83);
		contentPane.add(txtProcedimiento);

		label_3 = new JLabel("Terminolog\u00EDa:");
		label_3.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_3.setBounds(51, 227, 101, 18);
		contentPane.add(label_3);

		txtTerminologia = new JTextField();
		txtTerminologia.setColumns(10);
		txtTerminologia.setBounds(166, 226, 293, 20);
		contentPane.add(txtTerminologia);

		label_4 = new JLabel("Comenzales:");
		label_4.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_4.setBounds(51, 271, 101, 18);
		contentPane.add(label_4);

		txtComenzales = new JSpinner();
		txtComenzales.setBounds(166, 270, 130, 20);
		contentPane.add(txtComenzales);

		label_5 = new JLabel("Implementaci\u00F3n:");
		label_5.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_5.setBounds(498, 198, 130, 18);
		contentPane.add(label_5);

		txtImplementacion = new JTextField();
		txtImplementacion.setColumns(10);
		txtImplementacion.setBounds(624, 197, 200, 20);
		contentPane.add(txtImplementacion);

		txtPorcion = new JTextField();
		txtPorcion.setColumns(10);
		txtPorcion.setBounds(624, 147, 200, 20);
		contentPane.add(txtPorcion);

		label_6 = new JLabel("Porci\u00F3n:");
		label_6.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_6.setBounds(498, 150, 101, 18);
		contentPane.add(label_6);

		label_7 = new JLabel("Cantidad:");
		label_7.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_7.setBounds(498, 101, 101, 18);
		contentPane.add(label_7);

		txtCantidad = new JSpinner();
		txtCantidad.setBounds(624, 98, 111, 20);
		contentPane.add(txtCantidad);

		label_8 = new JLabel("Ingredientes:");
		label_8.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_8.setBounds(498, 59, 101, 18);
		contentPane.add(label_8);

		cmbIngrediente = new JComboBox();
		cmbIngrediente.setModel(new DefaultComboBoxModel(new String[] { "Seleccione" }));
		cmbIngrediente.setBounds(624, 55, 200, 20);
		contentPane.add(cmbIngrediente);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(154, 298, 539, 119);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Ingrediente", "Cantidad", "Porci\u00F3n", "Implementaci\u00F3n" }));

		scrollPane.setViewportView(table);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setPreferredSize(new Dimension(110, 30));
		btnAgregar.setForeground(new Color(255, 165, 0));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBackground(new Color(255, 255, 204));
		btnAgregar.setBounds(624, 227, 110, 30);
		contentPane.add(btnAgregar);

		btnAgregar.addActionListener(controller);
		btnActualizar.addActionListener(controller);
		btnAnterior.addActionListener(controller);
		btnAtrasVentana.addActionListener(controller);
		btnEliminar.addActionListener(controller);
		btnSiguiente.addActionListener(controller);
	}

	/**
	 * @return the btnAnterior
	 */
	public Object getBtnAnterior() {
		return btnAnterior;
	}

	/**
	 * @return the btnSiguiente
	 */
	public Object getBtnSiguiente() {
		return btnSiguiente;
	}

	/**
	 * @return the btnActualizar
	 */
	public Object getBtnActualizar() {
		return btnActualizar;
	}

	/**
	 * @return the btnEliminar
	 */
	public Object getBtnEliminar() {
		return btnEliminar;
	}

	/**
	 * @return the btnAtrasVentana
	 */
	public Object getBtnAtrasVentana() {
		return btnAtrasVentana;
	}

	/**
	 * @return the txtTitulo
	 */
	public String getTxtTitulo() {
		return txtTitulo.getText();
	}

	/**
	 * @param txtTitulo the txtTitulo to set
	 */
	public void setTxtTitulo(String txtTitulo) {
		this.txtTitulo.setText(txtTitulo);
	}

	/**
	 * @return the txtTerminologia
	 */
	public String getTxtTerminologia() {
		return txtTerminologia.getText();
	}

	/**
	 * @param txtTerminologia the txtTerminologia to set
	 */
	public void setTxtTerminologia(String txtTerminologia) {
		this.txtTerminologia.setText(txtTerminologia);
	}

	/**
	 * @return the txtProcedimiento
	 */
	public String getTxtProcedimiento() {
		return txtProcedimiento.getText();
	}

	/**
	 * @param txtProcedimiento the txtProcedimiento to set
	 */
	public void setTxtProcedimiento(String txtProcedimiento) {
		this.txtProcedimiento.setText(txtProcedimiento);
	}

	/**
	 * @return the txtImplementacion
	 */
	public String getTxtImplementacion() {
		return txtImplementacion.getText();
	}

	/**
	 * @param txtImplementacion the txtImplementacion to set
	 */
	public void setTxtImplementacion(String txtImplementacion) {
		this.txtImplementacion.setText(txtImplementacion);
	}

	/**
	 * @return the txtPorcion
	 */
	public String getTxtPorcion() {
		return txtPorcion.getText();
	}

	/**
	 * @param txtPorcion the txtPorcion to set
	 */
	public void setTxtPorcion(JTextField txtPorcion) {
		this.txtPorcion = txtPorcion;
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
	 * @return the cmbPlatillo
	 */
	public JComboBox getCmbPlatillo() {
		return cmbPlatillo;
	}

	/**
	 * @param cmbPlatillo the cmbPlatillo to set
	 */
	public void setCmbPlatillo(JComboBox cmbPlatillo) {
		this.cmbPlatillo = cmbPlatillo;
	}

	/**
	 * @param cmbPlatillo the cmbPlatillo to set
	 */
	public void setMandarCmbPlatillo(String cmbPlatillo) {
		this.cmbPlatillo.setSelectedItem(cmbPlatillo);
	}
	
	/**
	 * @return the cmbPlatillo en cadena
	 */
	public String getCmbPlatilloS() {
		return cmbPlatillo.getSelectedItem().toString();
	}

	/**
	 * @return the cmbIngrediente
	 */
	public JComboBox getCmbIngrediente() {
		return cmbIngrediente;
	}

	/**
	 * @param cmbIngrediente the cmbIngrediente to set
	 */
	public void setCmbIngrediente(JComboBox cmbIngrediente) {
		this.cmbIngrediente = cmbIngrediente;
	}

	/**
	 * @return the cmbIngrediente en cadena
	 */
	public String getCmbIngredienteS() {
		return cmbIngrediente.getSelectedItem().toString();
	}

	/**
	 * @return the txtCantidad
	 */
	public String getTxtCantidad() {
		return txtCantidad.getValue().toString();
	}

	/**
	 * @param txtCantidad the txtCantidad to set
	 */
	public void setTxtCantidad(JSpinner txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	/**
	 * @return the txtComenzales
	 */
	public String getTxtComenzales() {
		return (String) txtComenzales.getValue();
	}

	/**
	 * @param txtComenzales the txtComenzales to set
	 */
	public void setTxtComenzales(int txtComenzales) {
		this.txtComenzales.setValue(txtComenzales);
	}

}
