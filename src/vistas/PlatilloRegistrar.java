package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.PlatillosControlador;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.SystemColor;
import javax.swing.JTextArea;
public class PlatilloRegistrar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCosto;
	private JLabel lblRegistrarIngredientes;
	private JLabel lblNewLabel;
	private JLabel lblTipo;
	private JTextArea txtDescripcion;
	private JLabel lblMarca;
	private JLabel label_7;
	private JLabel lblCaducidad;
	private JComboBox<String> jcbCtegorias;
	private JLabel lblNacionalidad;

	private JTextField txtNacionalidad;
	private JButton btnRegistrar;
	JButton btnAtrasVentana;
	

	/**
	 * Create the frame.
	 */
	public PlatilloRegistrar() {
		createGUI();
	}

	public void createGUI() {
		setResizable(false);
		setBackground(new Color(255, 165, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 360);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblRegistrarIngredientes = new JLabel("REGISTRAR PLATILLO");
		lblRegistrarIngredientes.setBackground(new Color(102, 102, 102));
		lblRegistrarIngredientes.setBounds(82, 11, 273, 33);
		lblRegistrarIngredientes.setForeground(new Color(102, 102, 102));
		lblRegistrarIngredientes.setFont(new Font("Andalus", Font.BOLD, 25));
		contentPane.add(lblRegistrarIngredientes);

		lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(39, 60, 66, 18);
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblNewLabel);

		txtNombre = new JTextField();
		txtNombre.setBounds(151, 55, 204, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		lblTipo = new JLabel("Descripci\u00F3n:");
		lblTipo.setBounds(39, 100, 91, 18);
		lblTipo.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblTipo);

		txtDescripcion = new JTextArea();
		txtDescripcion.setBounds(151, 97, 204, 47);
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setRows(2);
		contentPane.add(txtDescripcion);

		lblMarca = new JLabel("Costo:");
		lblMarca.setBounds(39, 168, 45, 18);
		lblMarca.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblMarca);

		label_7 = new JLabel("$ ");
		label_7.setBounds(128, 160, 13, 18);
		label_7.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(label_7);

		txtCosto = new JTextField();
		txtCosto.setBounds(151, 158, 204, 20);
		contentPane.add(txtCosto);
		txtCosto.setColumns(10);

		lblCaducidad = new JLabel("Categor\u00EDa:");
		lblCaducidad.setBounds(39, 208, 73, 18);
		lblCaducidad.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblCaducidad);

		jcbCtegorias = new JComboBox<>();
		jcbCtegorias.setModel(new DefaultComboBoxModel<String>(new String[] {"Selecciona...", "Desayuno", 
				"Comida","Cena"}));
		jcbCtegorias.setBounds(151, 202, 204, 30);

		
		contentPane.add(jcbCtegorias);
		lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(39, 247, 102, 18);
		lblNacionalidad.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblNacionalidad);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setBounds(151, 243, 204, 22);
		contentPane.add(txtNacionalidad);
		txtNacionalidad.setColumns(10);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(117, 290, 110, 30);
		btnRegistrar.setPreferredSize(new Dimension(110, 30));
		btnRegistrar.setForeground(new Color(255, 165, 0));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrar.setBackground(SystemColor.controlHighlight);
		contentPane.add(btnRegistrar);

		btnAtrasVentana = new JButton("Atr\u00E1s");
		btnAtrasVentana.setBounds(273, 290, 110, 30);

		btnAtrasVentana.setPreferredSize(new Dimension(110, 30));
		btnAtrasVentana.setForeground(new Color(255, 165, 0));
		btnAtrasVentana.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtrasVentana.setBackground(SystemColor.controlHighlight);
		contentPane.add(btnAtrasVentana);
		
		btnAtrasVentana.addActionListener(new PlatillosControlador(this));
		btnRegistrar.addActionListener(new PlatillosControlador(this));
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

	public String getTxtNombre() {
		return txtNombre.getText();
	}

	public String getTxtCosto() {
		return txtCosto.getText();
	}

	public String getTxtDescripcion() {
		return txtDescripcion.getText();
	}

	public String getTxtNacionalidad() {
		return txtNacionalidad.getText();
	}

	

	public int getJcbCategorias() {
		return jcbCtegorias.getSelectedIndex();
	}
	
	
	public String getSelectedItem() {
		return (String) jcbCtegorias.getSelectedItem();
	} 
	
	public void setTxtNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);
	}

	public void setTxtCosto(String txtCosto) {
		this.txtCosto.setText(txtCosto);
	}

	public void setTxtDescripcion(String txtDescripcion) {
		this.txtDescripcion.setText(txtDescripcion);
	}
	

	public void setTxtNacionalidad(String txtNacionalidad) {
		this.txtNacionalidad.setText(txtNacionalidad);
	}

	
	public void setJcbCtegorias(int i) {
		this.jcbCtegorias.setSelectedIndex(i);
	}
	
}
