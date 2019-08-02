package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.IngredientesControlador;
import modelo.Ingredientes;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

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
		setBounds(100, 100, 500, 397);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblRegistrarIngredientes = new JLabel("CONSULTAR INGREDIENTES");
		lblRegistrarIngredientes.setBounds(77, 30, 350, 33);
		lblRegistrarIngredientes.setForeground(Color.BLACK);
		lblRegistrarIngredientes.setFont(new Font("Andalus", Font.BOLD, 25));
		contentPane.add(lblRegistrarIngredientes);

		lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(55, 74, 66, 18);
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblNewLabel);

		txtNombre = new JTextField();
		txtNombre.setBounds(218, 74, 221, 20);
		txtNombre.setEditable(false);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		lblTipo = new JLabel("Tipo de ingrediente:");
		lblTipo.setBounds(55, 110, 145, 18);
		lblTipo.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblTipo);

		lblMarca = new JLabel("Marca: ");
		lblMarca.setBounds(55, 149, 53, 18);
		lblMarca.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblMarca);

		txtMarca = new JTextField();
		txtMarca.setBounds(218, 149, 221, 20);
		txtMarca.setEditable(false);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);

		lblCaducidad = new JLabel("$");
		lblCaducidad.setBounds(201, 209, 18, 18);
		lblCaducidad.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblCaducidad);

		txtCaducidad = new JTextField();
		txtCaducidad.setBounds(218, 181, 221, 20);
		txtCaducidad.setEditable(false);
		contentPane.add(txtCaducidad);
		txtCaducidad.setColumns(10);

		btnAnterior = new JButton("ANTERIOR");
		btnAnterior.setBounds(55, 257, 110, 30);
		btnAnterior.setPreferredSize(new Dimension(110, 30));
		btnAnterior.setForeground(new Color(255, 165, 0));
		btnAnterior.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnterior.setBackground(new Color(255, 255, 204));
		contentPane.add(btnAnterior);

		btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setBounds(201, 257, 110, 30);
		btnSiguiente.setPreferredSize(new Dimension(110, 30));
		btnSiguiente.setForeground(new Color(255, 165, 0));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSiguiente.setBackground(new Color(255, 255, 204));
		contentPane.add(btnSiguiente);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(55, 298, 110, 30);

		btnActualizar.setPreferredSize(new Dimension(110, 50));
		btnActualizar.setForeground(new Color(255, 165, 0));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBackground(Color.WHITE);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(201, 298, 110, 30);
		btnEliminar.setPreferredSize(new Dimension(110, 50));
		btnEliminar.setForeground(new Color(255, 165, 0));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBackground(Color.WHITE);
		contentPane.add(btnEliminar);

		btnAtrasVentana = new JButton("Atr\u00E1s");
		btnAtrasVentana.setBounds(329, 298, 110, 30);

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
		cmbTipoIn.setBounds(218, 110, 221, 20);
		contentPane.add(cmbTipoIn);
		
		label = new JLabel("Caducidad: ");
		label.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label.setBounds(55, 179, 83, 18);
		contentPane.add(label);
		
		txt_Costo = new JTextField();
		txt_Costo.setEditable(false);
		txt_Costo.setBounds(218, 210, 109, 20);
		contentPane.add(txt_Costo);
		txt_Costo.setColumns(10);
		
		label_1 = new JLabel("Costo:");
		label_1.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_1.setBounds(55, 208, 83, 18);
		contentPane.add(label_1);
		
		IngredientesControlador x = new IngredientesControlador(this);
		
		JLabel fondo = new JLabel("");
		Image imagen = new ImageIcon(this.getClass().getResource("/fondoIngredientes.jpg")).getImage();
		fondo.setIcon(new ImageIcon(imagen));
		fondo.setBounds(0, 0, 496, 371);
		
		contentPane.add(fondo);
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
