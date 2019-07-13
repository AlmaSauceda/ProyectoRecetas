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
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

public class PlatilloGestionar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCosto;
	private JLabel lblRegistrarIngredientes;
	private JLabel label_1;
	private JLabel label_3;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JTextArea txtDescripcion;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnVentanaAtras;

	/**
	 * Create the frame.
	 */
	public PlatilloGestionar() {
		createGui();
	}

	public void createGui() {
		setResizable(false);
		setBackground(new Color(255, 165, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 395);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblRegistrarIngredientes = new JLabel("CONSULTAR PLATILLOS");
		lblRegistrarIngredientes.setBounds(78, 11, 299, 33);
		lblRegistrarIngredientes.setForeground(new Color(255, 255, 255));
		lblRegistrarIngredientes.setFont(new Font("Andalus", Font.BOLD, 25));
		contentPane.add(lblRegistrarIngredientes);

		label_1 = new JLabel("Nombre: ");
		label_1.setBounds(49, 67, 66, 18);
		label_1.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(label_1);

		txtNombre = new JTextField();
		txtNombre.setBounds(164, 66, 200, 20);
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		contentPane.add(txtNombre);

		label_3 = new JLabel("Descripci\u00F3n:");
		label_3.setBounds(49, 108, 91, 18);
		label_3.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(label_3);

		txtDescripcion = new JTextArea();
		txtDescripcion.setBounds(164, 108, 200, 40);
		txtDescripcion.setEditable(false);
		txtDescripcion.setRows(2);
		txtDescripcion.setLineWrap(true);
		contentPane.add(txtDescripcion);

		label_8 = new JLabel("Costo:");
		label_8.setBounds(49, 168, 45, 18);
		label_8.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(label_8);

		label_9 = new JLabel("$ ");
		label_9.setBounds(152, 168, 13, 18);
		label_9.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(label_9);

		txtCosto = new JTextField();
		txtCosto.setBounds(164, 167, 200, 20);
		txtCosto.setEditable(false);
		txtCosto.setColumns(10);
		contentPane.add(txtCosto);

		label_10 = new JLabel("Categor\u00EDa:");
		label_10.setBounds(49, 207, 73, 18);
		label_10.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(label_10);

		btnAnterior = new JButton("ANTERIOR");
		btnAnterior.setBounds(29, 248, 110, 30);
		btnAnterior.setPreferredSize(new Dimension(110, 30));
		btnAnterior.setForeground(new Color(255, 165, 0));
		btnAnterior.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnterior.setBackground(new Color(255, 255, 204));
		contentPane.add(btnAnterior);

		btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setBounds(332, 248, 110, 30);
		btnSiguiente.setPreferredSize(new Dimension(110, 30));
		btnSiguiente.setForeground(new Color(255, 165, 0));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSiguiente.setBackground(new Color(255, 255, 204));
		contentPane.add(btnSiguiente);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(119, 289, 110, 30);

		btnActualizar.setPreferredSize(new Dimension(110, 50));
		btnActualizar.setForeground(new Color(255, 165, 0));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBackground(Color.WHITE);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(234, 289, 110, 30);
		btnEliminar.setPreferredSize(new Dimension(110, 50));
		btnEliminar.setForeground(new Color(255, 165, 0));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBackground(Color.WHITE);
		contentPane.add(btnEliminar);

		btnVentanaAtras = new JButton("Atr\u00E1s");
		btnVentanaAtras.setBounds(185, 329, 110, 30);

		btnVentanaAtras.setPreferredSize(new Dimension(110, 30));
		btnVentanaAtras.setForeground(new Color(255, 165, 0));
		btnVentanaAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVentanaAtras.setBackground(SystemColor.controlHighlight);
		contentPane.add(btnVentanaAtras);
		
		JRadioButton radioButton = new JRadioButton("Comida");
		radioButton.setBackground(new Color(255, 165, 0));
		radioButton.setBounds(243, 205, 83, 23);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Cena");
		radioButton_1.setBackground(new Color(255, 165, 0));
		radioButton_1.setBounds(328, 205, 87, 23);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("Desayuno");
		radioButton_2.setBackground(new Color(255, 165, 0));
		radioButton_2.setBounds(150, 205, 91, 23);
		contentPane.add(radioButton_2);
		
		
		btnActualizar.addActionListener(new PlatillosControlador(this));
		btnAnterior.addActionListener(new PlatillosControlador(this));
		btnEliminar.addActionListener(new PlatillosControlador(this));
		btnSiguiente.addActionListener(new PlatillosControlador(this));
		btnVentanaAtras.addActionListener(new PlatillosControlador(this));
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
	 * @return the btnVentanaAtras
	 */
	public Object getBtnVentanaAtras() {
		return btnVentanaAtras;
	}
}
