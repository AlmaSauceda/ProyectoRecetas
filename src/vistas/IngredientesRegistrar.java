package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.IngredientesControlador;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;

public class IngredientesRegistrar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtCaducidad;
	private JLabel lblRegistrarIngredientes;
	private JLabel lblNewLabel;
	private JLabel lblMarca;
	private JLabel lblTipo;
	private JLabel lblCaducidad;
	private JButton btnRegistrar;
	private JButton btnAtrasVentana;
	private JComboBox cmbIngrediente;
	private JTextField txt_Costo;
	private JLabel label;

	/**
	 * Create the frame.
	 */
	public IngredientesRegistrar() {
		createGUI();
	}

	
	public void createGUI() {
		setResizable(false);
		setBackground(new Color(255, 165, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblRegistrarIngredientes = new JLabel("REGISTRAR INGREDIENTES");
		lblRegistrarIngredientes.setBounds(68, 11, 341, 33);
		lblRegistrarIngredientes.setForeground(new Color(255, 255, 255));
		lblRegistrarIngredientes.setFont(new Font("Andalus", Font.BOLD, 25));
		contentPane.add(lblRegistrarIngredientes);

		lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(39, 89, 66, 18);
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblNewLabel);

		txtNombre = new JTextField();
		txtNombre.setBounds(203, 87, 232, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		lblTipo = new JLabel("Tipo de ingrediente:");
		lblTipo.setBounds(39, 124, 145, 18);
		lblTipo.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblTipo);

		cmbIngrediente = new JComboBox();
		cmbIngrediente.setBounds(203, 118, 232, 20);
		cmbIngrediente.setModel(
				new DefaultComboBoxModel(new String[] { "-Seleccione-", "Frutas", "Verduras", "Carnes", "Especias" }));
		contentPane.add(cmbIngrediente);

		lblMarca = new JLabel("Marca: ");
		lblMarca.setBounds(39, 164, 53, 18);
		lblMarca.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblMarca);

		txtMarca = new JTextField();
		txtMarca.setBounds(203, 163, 232, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);

		lblCaducidad = new JLabel("Caducidad: ");
		lblCaducidad.setBounds(39, 202, 83, 18);
		lblCaducidad.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblCaducidad);

		txtCaducidad = new JTextField();
		txtCaducidad.setBounds(203, 203, 232, 20);
		contentPane.add(txtCaducidad);
		txtCaducidad.setColumns(10);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(242, 278, 110, 30);
		btnRegistrar.setPreferredSize(new Dimension(110, 30));
		btnRegistrar.setForeground(new Color(255, 165, 0));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrar.setBackground(new Color(255, 255, 204));
		contentPane.add(btnRegistrar);

		btnAtrasVentana = new JButton("Atr\u00E1s");
		btnAtrasVentana.setBounds(362, 278, 110, 30);
		btnAtrasVentana.setPreferredSize(new Dimension(110, 30));
		btnAtrasVentana.setForeground(new Color(255, 165, 0));
		btnAtrasVentana.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtrasVentana.setBackground(SystemColor.controlHighlight);
		contentPane.add(btnAtrasVentana);
		
		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setFont(new Font("Cambria Math", Font.BOLD, 15));
		lblCosto.setBounds(39, 231, 83, 18);
		contentPane.add(lblCosto);
		
		txt_Costo = new JTextField();
		txt_Costo.setBounds(203, 234, 110, 20);
		contentPane.add(txt_Costo);
		txt_Costo.setColumns(10);
		
		label = new JLabel("$");
		label.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label.setBounds(183, 235, 18, 18);
		contentPane.add(label);
		
		btnAtrasVentana.addActionListener(new IngredientesControlador(this));
		btnRegistrar.addActionListener(new IngredientesControlador(this));
	}
	/**
	 * @return the btnRegistrar
	 */


	public String getTxtNombre() {
		return txtNombre.getText();
	}


	public void setTxtNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);
	}


	public String getTxtMarca() {
		return txtMarca.getText();
	}


	public void setTxtMarca(String txtMarca) {
		this.txtMarca.setText(txtMarca);
	}


	public String getTxtCaducidad() {
		return txtCaducidad.getText();
	}


	public void setTxtCaducidad(String txtCaducidad) {
		this.txtCaducidad.setText(txtCaducidad);
	}


	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}


	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}


	public JButton getBtnAtrasVentana() {
		return btnAtrasVentana;
	}


	public void setBtnAtrasVentana(JButton btnAtrasVentana) {
		this.btnAtrasVentana = btnAtrasVentana;
	}


	public String getCmbIngrediente() {
		return (String) cmbIngrediente.getSelectedItem();
	}


	public void setCmbIngrediente(String cmbIngrediente) {
		this.cmbIngrediente.setSelectedItem(cmbIngrediente);
	}


	public String getTxt_Costo() {
		return txt_Costo.getText();
	}


	public void setTxt_Costo(String txt_Costo) {
		this.txt_Costo.setText(txt_Costo);
	}
	
	
}
