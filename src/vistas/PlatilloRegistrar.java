package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.PlatillosControlador;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
		setBounds(100, 100, 500, 396);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblRegistrarIngredientes = new JLabel("REGISTRAR PLATILLO");
		lblRegistrarIngredientes.setBackground(SystemColor.desktop);
		lblRegistrarIngredientes.setBounds(98, 22, 273, 33);
		lblRegistrarIngredientes.setForeground(SystemColor.desktop);
		lblRegistrarIngredientes.setFont(new Font("Andalus", Font.BOLD, 25));
		contentPane.add(lblRegistrarIngredientes);

		lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(87, 74, 66, 18);
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblNewLabel);

		txtNombre = new JTextField();
		txtNombre.setBounds(199, 69, 204, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		lblTipo = new JLabel("Descripci\u00F3n:");
		lblTipo.setBounds(87, 114, 91, 18);
		lblTipo.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblTipo);

		txtDescripcion = new JTextArea();
		txtDescripcion.setBackground(SystemColor.menu);
		txtDescripcion.setBounds(199, 111, 204, 47);
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setRows(2);
		contentPane.add(txtDescripcion);

		lblMarca = new JLabel("Costo:");
		lblMarca.setBounds(87, 182, 45, 18);
		lblMarca.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblMarca);

		label_7 = new JLabel("$ ");
		label_7.setBounds(176, 174, 13, 18);
		label_7.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(label_7);

		txtCosto = new JTextField();
		txtCosto.setBounds(199, 172, 204, 20);
		contentPane.add(txtCosto);
		txtCosto.setColumns(10);

		lblCaducidad = new JLabel("Categor\u00EDa:");
		lblCaducidad.setBounds(87, 222, 73, 18);
		lblCaducidad.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblCaducidad);

		jcbCtegorias = new JComboBox<>();
		jcbCtegorias.setModel(new DefaultComboBoxModel<String>(new String[] {"Selecciona...", "Desayuno", 
				"Comida","Cena"}));
		jcbCtegorias.setBounds(199, 216, 204, 30);

		
		contentPane.add(jcbCtegorias);
		lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(87, 261, 102, 18);
		lblNacionalidad.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblNacionalidad);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setBounds(199, 257, 204, 22);
		contentPane.add(txtNacionalidad);
		txtNacionalidad.setColumns(10);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(71, 303, 110, 30);
		btnRegistrar.setPreferredSize(new Dimension(110, 30));
		btnRegistrar.setForeground(new Color(255, 165, 0));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrar.setBackground(SystemColor.controlHighlight);
		contentPane.add(btnRegistrar);

		btnAtrasVentana = new JButton("Atr\u00E1s");
		btnAtrasVentana.setBounds(344, 303, 110, 30);

		btnAtrasVentana.setPreferredSize(new Dimension(110, 30));
		btnAtrasVentana.setForeground(new Color(255, 165, 0));
		btnAtrasVentana.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtrasVentana.setBackground(SystemColor.controlHighlight);
		contentPane.add(btnAtrasVentana);
		
		JLabel fondo = new JLabel("");
		Image imagen = new ImageIcon(this.getClass().getResource("/fondoPlatillos.jpg")).getImage();
		fondo.setIcon(new ImageIcon(imagen));
		fondo.setBounds(0, 0, 496, 371);
		contentPane.add(fondo);
		
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
