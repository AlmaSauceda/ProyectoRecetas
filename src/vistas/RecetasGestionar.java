package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.RecetasControlador;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.ImageIcon;

public class RecetasGestionar extends JFrame {

	private RecetasControlador controller;
	private JPanel contentPane;
	private JLabel lblRegistrarIngredientes;
	public JButton btnAnterior;
	public JButton btnSiguiente;
	public JButton btnActualizar;
	public JButton btnEliminar;
	public JButton btnAtrasVentana;
	public JComboBox cmbPlatillo;
	private JLabel label;
	private JLabel label_1;
	public JTextField txtTitulo;
	private JLabel label_2;
	private JTextArea txtProcedimiento;
	private JLabel label_3;
	public JTextField txtTerminologia;
	private JLabel label_4;
	public JSpinner txtComenzales;
	private JLabel label_5;
	public JTextField txtImplementacion;
	public JTextField txtPorcion;
	private JLabel label_6;
	private JLabel label_7;
	public JSpinner txtCantidad;
	private JLabel label_8;
	public JComboBox cmbIngrediente;
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
		setBounds(100, 100, 900, 511);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblRegistrarIngredientes = new JLabel("GESTIONAR RECETAS");
		lblRegistrarIngredientes.setBounds(318, 0, 281, 33);
		lblRegistrarIngredientes.setForeground(Color.BLACK);
		lblRegistrarIngredientes.setFont(new Font("Andalus", Font.BOLD, 25));
		contentPane.add(lblRegistrarIngredientes);

		btnAnterior = new JButton("ANTERIOR");
		btnAnterior.setBounds(32, 441, 110, 30);
		btnAnterior.setPreferredSize(new Dimension(110, 30));
		btnAnterior.setForeground(new Color(255, 165, 0));
		btnAnterior.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnterior.setBackground(new Color(255, 255, 204));
		contentPane.add(btnAnterior);

		btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setBounds(167, 441, 110, 30);
		btnSiguiente.setPreferredSize(new Dimension(110, 30));
		btnSiguiente.setForeground(new Color(255, 165, 0));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSiguiente.setBackground(new Color(255, 255, 204));
		contentPane.add(btnSiguiente);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(495, 441, 110, 30);
		btnActualizar.setPreferredSize(new Dimension(110, 50));
		btnActualizar.setForeground(new Color(255, 165, 0));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBackground(Color.WHITE);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(632, 441, 110, 30);
		btnEliminar.setPreferredSize(new Dimension(110, 50));
		btnEliminar.setForeground(new Color(255, 165, 0));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBackground(Color.WHITE);
		contentPane.add(btnEliminar);

		btnAtrasVentana = new JButton("Atr\u00E1s");
		btnAtrasVentana.setBounds(774, 441, 110, 30);

		btnAtrasVentana.setPreferredSize(new Dimension(110, 30));
		btnAtrasVentana.setForeground(new Color(255, 165, 0));
		btnAtrasVentana.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtrasVentana.setBackground(SystemColor.controlHighlight);
		contentPane.add(btnAtrasVentana);

		cmbPlatillo = new JComboBox();
		cmbPlatillo.setModel(new DefaultComboBoxModel(new String[] { "Seleccione" }));
		cmbPlatillo.setBounds(338, 50, 293, 20);
		contentPane.add(cmbPlatillo);

		label = new JLabel("Platillo:");
		label.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label.setBounds(223, 52, 101, 18);
		contentPane.add(label);

		label_1 = new JLabel("T\u00EDtulo:");
		label_1.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_1.setBounds(223, 94, 49, 18);
		contentPane.add(label_1);

		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(338, 93, 293, 20);
		contentPane.add(txtTitulo);

		label_2 = new JLabel("Procedimiento:");
		label_2.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_2.setBounds(314, 168, 111, 18);
		contentPane.add(label_2);

		txtProcedimiento = new JTextArea();
		txtProcedimiento.setBackground(SystemColor.menu);
		txtProcedimiento.setRows(6);
		txtProcedimiento.setLineWrap(true);
		txtProcedimiento.setColumns(10);
		txtProcedimiento.setBounds(318, 210, 523, 83);
		contentPane.add(txtProcedimiento);

		label_3 = new JLabel("Terminolog\u00EDa:");
		label_3.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_3.setBounds(502, 139, 101, 18);
		contentPane.add(label_3);

		txtTerminologia = new JTextField();
		txtTerminologia.setColumns(10);
		txtTerminologia.setBounds(612, 138, 183, 20);
		contentPane.add(txtTerminologia);

		label_4 = new JLabel("Comensales:");
		label_4.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_4.setBounds(498, 168, 101, 18);
		contentPane.add(label_4);

		txtComenzales = new JSpinner();
		txtComenzales.setBounds(612, 169, 130, 20);
		contentPane.add(txtComenzales);

		label_5 = new JLabel("Implementaci\u00F3n:");
		label_5.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_5.setBounds(32, 328, 130, 18);
		contentPane.add(label_5);

		txtImplementacion = new JTextField();
		txtImplementacion.setColumns(10);
		txtImplementacion.setBounds(58, 357, 200, 20);
		contentPane.add(txtImplementacion);

		txtPorcion = new JTextField();
		txtPorcion.setColumns(10);
		txtPorcion.setBounds(58, 305, 200, 20);
		contentPane.add(txtPorcion);

		label_6 = new JLabel("Porci\u00F3n:");
		label_6.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_6.setBounds(31, 281, 101, 18);
		contentPane.add(label_6);

		label_7 = new JLabel("Cantidad:");
		label_7.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_7.setBounds(32, 239, 101, 18);
		contentPane.add(label_7);

		txtCantidad = new JSpinner();
		txtCantidad.setBounds(104, 257, 111, 20);
		contentPane.add(txtCantidad);

		label_8 = new JLabel("Ingredientes:");
		label_8.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_8.setBounds(76, 168, 101, 18);
		contentPane.add(label_8);

		cmbIngrediente = new JComboBox();
		cmbIngrediente.setModel(new DefaultComboBoxModel(new String[] { "Seleccione" }));
		cmbIngrediente.setBounds(58, 212, 200, 20);
		contentPane.add(cmbIngrediente);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 311, 539, 119);
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
		btnAgregar.setBounds(105, 388, 110, 30);
		contentPane.add(btnAgregar);

		JLabel fondo = new JLabel("");
		Image imagen = new ImageIcon(this.getClass().getResource("/fondoReceta.jpg")).getImage();
		fondo.setIcon(new ImageIcon(imagen));
		fondo.setBounds(0, 0, 894, 482);
		contentPane.add(fondo);
		
		
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
	public int getTxtCantidad() {
		return (int) txtCantidad.getValue();
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
	public int getTxtComenzales() {
		return (int) txtComenzales.getValue();
	}

	/**
	 * @param txtComenzales the txtComenzales to set
	 */
	public void setTxtComenzales(int txtComenzales) {
		this.txtComenzales.setValue(txtComenzales);
	}

}
