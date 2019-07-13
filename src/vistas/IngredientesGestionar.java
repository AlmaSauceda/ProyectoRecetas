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

public class IngredientesGestionar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtCaducidad;
	private JLabel lblRegistrarIngredientes;
	private JLabel lblNewLabel;
	private JLabel lblTipo;
	private JLabel lblMarca;
	private JLabel lblCaducidad;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnAtrasVentana;
	private JComboBox cmbTipoIn;

	/**
	 * Create the frame.
	 */
	public IngredientesGestionar() {
		createGUI();
	}

	public void createGUI() {
		setResizable(false);
		setBackground(new Color(255, 165, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 365);
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

		lblCaducidad = new JLabel("Caducidad: ");
		lblCaducidad.setBounds(49, 193, 83, 18);
		lblCaducidad.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblCaducidad);

		txtCaducidad = new JTextField();
		txtCaducidad.setBounds(210, 197, 221, 20);
		txtCaducidad.setEditable(false);
		contentPane.add(txtCaducidad);
		txtCaducidad.setColumns(10);

		btnAnterior = new JButton("ANTERIOR");
		btnAnterior.setBounds(39, 228, 110, 30);
		btnAnterior.setPreferredSize(new Dimension(110, 30));
		btnAnterior.setForeground(new Color(255, 165, 0));
		btnAnterior.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnterior.setBackground(new Color(255, 255, 204));
		contentPane.add(btnAnterior);

		btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setBounds(399, 228, 110, 30);
		btnSiguiente.setPreferredSize(new Dimension(110, 30));
		btnSiguiente.setForeground(new Color(255, 165, 0));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSiguiente.setBackground(new Color(255, 255, 204));
		contentPane.add(btnSiguiente);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(159, 253, 110, 30);

		btnActualizar.setPreferredSize(new Dimension(110, 50));
		btnActualizar.setForeground(new Color(255, 165, 0));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBackground(Color.WHITE);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(279, 253, 110, 30);
		btnEliminar.setPreferredSize(new Dimension(110, 50));
		btnEliminar.setForeground(new Color(255, 165, 0));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBackground(Color.WHITE);
		contentPane.add(btnEliminar);

		btnAtrasVentana = new JButton("Atr\u00E1s");
		btnAtrasVentana.setBounds(226, 298, 110, 30);

		btnAtrasVentana.setPreferredSize(new Dimension(110, 30));
		btnAtrasVentana.setForeground(new Color(255, 165, 0));
		btnAtrasVentana.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtrasVentana.setBackground(SystemColor.controlHighlight);
		contentPane.add(btnAtrasVentana);

		cmbTipoIn = new JComboBox();
		cmbTipoIn.setBounds(210, 124, 221, 20);
		contentPane.add(cmbTipoIn);
		
		btnActualizar.addActionListener(new IngredientesControlador(this));
		btnAnterior.addActionListener(new IngredientesControlador(this));
		btnAtrasVentana.addActionListener(new IngredientesControlador(this));
		btnEliminar.addActionListener(new IngredientesControlador(this));
		btnSiguiente.addActionListener(new IngredientesControlador(this));
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
	
	
}
