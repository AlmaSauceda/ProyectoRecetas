package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.IngredientesControlador;
import modelo.Ingredientes;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;

public class IngredientesGestionar extends JFrame {

	private JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtMarca;
	public JTextField txtCaducidad;
	private JLabel lblRegistrarIngredientes;
	private JLabel lblNewLabel;
	private JLabel lblTipo;
	private JLabel lblMarca;
	private JLabel lblCaducidad;
	public JButton btnAnterior;
	public JButton btnSiguiente;
	public JButton btnActualizar;
	public JButton btnEliminar;
	public JButton btnAtrasVentana;
	public JComboBox cmbTipoIn;
	private JLabel label;
	public JTextField txt_Costo;
	private JLabel label_1;

	//IngredientesGestionar ig;
	/**tionar
	 * Create the frame.
	 */
	public IngredientesGestionar() {
		createGUI();
		//IngredientesControlador ing=new IngredientesControlador(ig);
		//ing.consultar();
	}
	
	public void createGUI() {
		setResizable(false);
		setBackground(new Color(255, 165, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblRegistrarIngredientes = new JLabel("CONSULTAR INGREDIENTES");
		lblRegistrarIngredientes.setBounds(89, 10, 350, 33);
		lblRegistrarIngredientes.setForeground(new Color(255, 255, 255));
		lblRegistrarIngredientes.setFont(new Font("Andalus", Font.BOLD, 25));
		contentPane.add(lblRegistrarIngredientes);

		lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(49, 89, 66, 18);
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblNewLabel);

		txtNombre = new JTextField();
		txtNombre.setBounds(210, 88, 221, 20);
		txtNombre.setEditable(false);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		lblTipo = new JLabel("Tipo de ingrediente:");
		lblTipo.setBounds(49, 125, 145, 18);
		lblTipo.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblTipo);

		lblMarca = new JLabel("Marca: ");
		lblMarca.setBounds(49, 164, 53, 18);
		lblMarca.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblMarca);

		txtMarca = new JTextField();
		txtMarca.setBounds(210, 163, 221, 20);
		txtMarca.setEditable(false);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);

		lblCaducidad = new JLabel("$");
		lblCaducidad.setBounds(193, 223, 18, 18);
		lblCaducidad.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblCaducidad);

		txtCaducidad = new JTextField();
		txtCaducidad.setBounds(210, 195, 221, 20);
		txtCaducidad.setEditable(false);
		contentPane.add(txtCaducidad);
		txtCaducidad.setColumns(10);

		btnAnterior = new JButton("ANTERIOR");
		btnAnterior.setBounds(62, 261, 110, 30);
		btnAnterior.setPreferredSize(new Dimension(110, 30));
		btnAnterior.setForeground(new Color(255, 165, 0));
		btnAnterior.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnterior.setBackground(new Color(255, 255, 204));
		contentPane.add(btnAnterior);

		btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setBounds(373, 261, 110, 30);
		btnSiguiente.setPreferredSize(new Dimension(110, 30));
		btnSiguiente.setForeground(new Color(255, 165, 0));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSiguiente.setBackground(new Color(255, 255, 204));
		contentPane.add(btnSiguiente);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(156, 302, 110, 30);

		btnActualizar.setPreferredSize(new Dimension(110, 50));
		btnActualizar.setForeground(new Color(255, 165, 0));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBackground(Color.WHITE);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(276, 302, 110, 30);
		btnEliminar.setPreferredSize(new Dimension(110, 50));
		btnEliminar.setForeground(new Color(255, 165, 0));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBackground(Color.WHITE);
		contentPane.add(btnEliminar);

		btnAtrasVentana = new JButton("Atr\u00E1s");
		btnAtrasVentana.setBounds(209, 343, 110, 30);

		btnAtrasVentana.setPreferredSize(new Dimension(110, 30));
		btnAtrasVentana.setForeground(new Color(255, 165, 0));
		btnAtrasVentana.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtrasVentana.setBackground(SystemColor.controlHighlight);
		contentPane.add(btnAtrasVentana);

		cmbTipoIn = new JComboBox();
		cmbTipoIn.setEnabled(false);
		cmbTipoIn.setEditable(true);
		cmbTipoIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmbTipoIn.setModel(new DefaultComboBoxModel(new String[] {"-Seleccione-", "Frutas", "Verduras", "Carnes", "Especias"}));
		cmbTipoIn.setBounds(210, 124, 221, 20);
		contentPane.add(cmbTipoIn);
		
		label = new JLabel("Caducidad: ");
		label.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label.setBounds(49, 194, 83, 18);
		contentPane.add(label);
		
		txt_Costo = new JTextField();
		txt_Costo.setEditable(false);
		txt_Costo.setBounds(210, 224, 109, 20);
		contentPane.add(txt_Costo);
		txt_Costo.setColumns(10);
		
		label_1 = new JLabel("Costo:");
		label_1.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_1.setBounds(49, 223, 83, 18);
		contentPane.add(label_1);
		
		IngredientesControlador x = new IngredientesControlador(this);
		
		btnActualizar.addActionListener(x);
		btnAnterior.addActionListener(x);
		btnAtrasVentana.addActionListener(x);
		btnEliminar.addActionListener(x);
		btnSiguiente.addActionListener(x);
	}

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

	public JButton getBtnAnterior() {
		return btnAnterior;
	}

	public void setBtnAnterior(JButton btnAnterior) {
		this.btnAnterior = btnAnterior;
	}

	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}

	public void setBtnSiguiente(JButton btnSiguiente) {
		this.btnSiguiente = btnSiguiente;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnAtrasVentana() {
		return btnAtrasVentana;
	}

	public void setBtnAtrasVentana(JButton btnAtrasVentana) {
		this.btnAtrasVentana = btnAtrasVentana;
	}

	public String getCmbTipoIn() {
		return (String) cmbTipoIn.getSelectedItem();
	}

	public void setCmbTipoIn(String cmbTipoIn) {
		this.cmbTipoIn.setSelectedItem(cmbTipoIn);
	}

	public String getTxt_Costo() {
		return txt_Costo.getText();
	}

	public void setTxt_Costo(String txt_Costo) {
		this.txt_Costo.setText(txt_Costo);
	}
	
}
