/***
 * Develop by Angel
 * 
 * JFrame RecetasRegistrar donde se encuentran todos los componentesF
 * 
 * **/

package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.RecetasControlador;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecetasRegistrar extends JFrame {

	private RecetasControlador controller;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtTerminologia;
	private JLabel lblRegistrarIngredientes;
	private JLabel lblNewLabel;
	private JLabel lblTipo;
	private JTextArea txtProcedimiento;
	private JLabel lblMarca;
	private JButton btnRegistrar;
	private JButton btnAtrasVentana;
	private JButton btnAgregar;
	private JLabel lblCantidad;
	private JLabel lblPorcin;
	private JTextField txtImplementacion;
	private JTextField txtPorcion;
	private JTable table;
	private JLabel lblPlatillo;
	private JComboBox<String> cmbPlatillo;
	private JLabel lblComenzales;
	private JLabel lblImplementacin;
	private JLabel lblIngredientes;
	private JComboBox cmbIngrediente;
	private JSpinner txtCantidad;
	private JSpinner txtComenzales;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public RecetasRegistrar() {
		createGui();
		controller = new RecetasControlador(this);
		controller.CargarCombosReg();

	}

	public void createGui() {
		controller = new RecetasControlador(this);
		setResizable(false);
		setBackground(new Color(255, 165, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 524);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblRegistrarIngredientes = new JLabel("REGISTRAR RECETA");
		lblRegistrarIngredientes.setBackground(SystemColor.desktop);
		lblRegistrarIngredientes.setBounds(319, 10, 255, 33);
		lblRegistrarIngredientes.setForeground(SystemColor.desktop);
		lblRegistrarIngredientes.setFont(new Font("Andalus", Font.BOLD, 25));
		contentPane.add(lblRegistrarIngredientes);

		lblNewLabel = new JLabel("T\u00EDtulo:");
		lblNewLabel.setBounds(233, 98, 49, 18);
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblNewLabel);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(348, 97, 293, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		lblTipo = new JLabel("Procedimiento:");
		lblTipo.setBounds(313, 175, 111, 18);
		lblTipo.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblTipo);

		txtProcedimiento = new JTextArea();
		txtProcedimiento.setBackground(SystemColor.menu);
		txtProcedimiento.setBounds(340, 224, 498, 83);
		txtProcedimiento.setLineWrap(true);
		txtProcedimiento.setColumns(10);
		txtProcedimiento.setRows(6);
		contentPane.add(txtProcedimiento);

		lblMarca = new JLabel("Terminolog\u00EDa:");
		lblMarca.setBounds(528, 133, 101, 18);
		lblMarca.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblMarca);

		txtTerminologia = new JTextField();
		txtTerminologia.setBounds(643, 132, 130, 20);
		contentPane.add(txtTerminologia);
		txtTerminologia.setColumns(10);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(574, 454, 110, 30);
		btnRegistrar.setPreferredSize(new Dimension(110, 30));
		btnRegistrar.setForeground(new Color(255, 165, 0));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrar.setBackground(new Color(255, 255, 204));
		contentPane.add(btnRegistrar);

		btnAtrasVentana = new JButton("Atr\u00E1s");
		btnAtrasVentana.setBounds(716, 454, 110, 30);

		btnAtrasVentana.setPreferredSize(new Dimension(110, 30));
		btnAtrasVentana.setForeground(new Color(255, 165, 0));
		btnAtrasVentana.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtrasVentana.setBackground(SystemColor.controlHighlight);
		contentPane.add(btnAtrasVentana);

		lblPlatillo = new JLabel("Platillo:");
		lblPlatillo.setFont(new Font("Cambria Math", Font.BOLD, 15));
		lblPlatillo.setBounds(233, 56, 101, 18);
		contentPane.add(lblPlatillo);

		cmbPlatillo = new JComboBox<String>();
		cmbPlatillo.setModel(new DefaultComboBoxModel<String>(new String[] { "-Seleccione-" }));
		cmbPlatillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		cmbPlatillo.setBounds(348, 54, 293, 20);
		contentPane.add(cmbPlatillo);

		lblComenzales = new JLabel("Comensales:");
		lblComenzales.setFont(new Font("Cambria Math", Font.BOLD, 15));
		lblComenzales.setBounds(528, 177, 101, 18);
		contentPane.add(lblComenzales);

		lblIngredientes = new JLabel("Ingredientes:");
		lblIngredientes.setFont(new Font("Cambria Math", Font.BOLD, 15));
		lblIngredientes.setBounds(78, 175, 101, 18);
		contentPane.add(lblIngredientes);

		cmbIngrediente = new JComboBox();
		cmbIngrediente.setModel(new DefaultComboBoxModel(new String[] { "Seleccione", }));
		cmbIngrediente.setBounds(59, 215, 200, 20);
		contentPane.add(cmbIngrediente);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setPreferredSize(new Dimension(110, 30));
		btnAgregar.setForeground(new Color(255, 165, 0));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBackground(new Color(255, 255, 204));
		btnAgregar.setBounds(107, 393, 110, 30);
		contentPane.add(btnAgregar);

		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Cambria Math", Font.BOLD, 15));
		lblCantidad.setBounds(38, 246, 101, 18);
		contentPane.add(lblCantidad);

		lblPorcin = new JLabel("Porci\u00F3n:");
		lblPorcin.setFont(new Font("Cambria Math", Font.BOLD, 15));
		lblPorcin.setBounds(38, 287, 101, 18);
		contentPane.add(lblPorcin);

		lblImplementacin = new JLabel("Implementaci\u00F3n:");
		lblImplementacin.setFont(new Font("Cambria Math", Font.BOLD, 15));
		lblImplementacin.setBounds(37, 329, 130, 18);
		contentPane.add(lblImplementacin);

		txtImplementacion = new JTextField();
		txtImplementacion.setBounds(59, 358, 200, 20);
		contentPane.add(txtImplementacion);
		txtImplementacion.setColumns(10);

		txtCantidad = new JSpinner();
		txtCantidad.setBounds(93, 263, 111, 20);
		contentPane.add(txtCantidad);

		txtComenzales = new JSpinner();
		txtComenzales.setBounds(643, 176, 130, 20);
		contentPane.add(txtComenzales);

		txtPorcion = new JTextField();
		txtPorcion.setBounds(59, 309, 200, 20);
		contentPane.add(txtPorcion);
		txtPorcion.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(319, 324, 539, 119);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Ingrediente", "Cantidad", "Porci\u00F3n", "Implementaci\u00F3n" }));

		scrollPane.setViewportView(table);

		JLabel fondo = new JLabel("");
		Image imagen = new ImageIcon(this.getClass().getResource("/fondoReceta.jpg")).getImage();
		fondo.setIcon(new ImageIcon(imagen));
		fondo.setBounds(0, 0, 894, 501);
		contentPane.add(fondo);
		
		btnAtrasVentana.addActionListener(controller);
		btnRegistrar.addActionListener(controller);
		btnAgregar.addActionListener(controller);
	}

	/**
	 * @return the btnRegistrar
	 */
	public Object getBtnRegistrar() {
		return btnRegistrar;
	}

	/**
	 * @return the btnAtrasVentana
	 */
	public Object getBtnAtrasVentana() {
		return btnAtrasVentana;
	}

	/**
	 * @return the btnAgregar
	 */
	public Object getBtnAgregar() {
		return btnAgregar;
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
	public void setTxtPorcion(String txtPorcion) {
		this.txtPorcion.setText(txtPorcion);
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
	 * @return the cmbPlatillo en cadena 
	 */
	public String getCmbPlatilloS() {
		return cmbPlatillo.getSelectedItem().toString();
	}

	/**
	 * @param cmbPlatillo the cmbPlatillo to set
	 */
	public void setCmbPlatillo(JComboBox<String> cmbPlatillo) {
		this.cmbPlatillo = cmbPlatillo;
	}
	
	/**
	 * @param cmbPlatillo the cmbPlatillo to set
	 */
	public void setCmbPlatillo(int cmbPlatillo) {
		this.cmbPlatillo.setSelectedIndex(cmbPlatillo);
	}

	/**
	 * @return the cmbIngrediente
	 */
	public JComboBox getCmbIngrediente() {
		return cmbIngrediente;
	}
	
	

	/**
	 * @return the cmbIngrediente en cadena
	 */
	public String getCmbIngredienteS() {
		return cmbIngrediente.getSelectedItem().toString();
	}

	/**
	 * @param cmbIngrediente the cmbIngrediente to set
	 */
	public void setCmbIngrediente(JComboBox cmbIngrediente) {
		this.cmbIngrediente = cmbIngrediente;
	}

	/**
	 * @param cmbIngrediente the cmbIngrediente to set
	 */
	public void setCmbIngredienteCambio(int cmbIngrediente) {
		this.cmbIngrediente.setSelectedIndex(cmbIngrediente);
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
	public void setTxtCantidad(int txtCantidad) {
		this.txtCantidad.setValue(txtCantidad);
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
