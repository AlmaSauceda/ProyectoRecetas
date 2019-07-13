package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.RecetasControlador;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextArea;

public class RecetasGestionar extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtTerminologia;
	private JLabel lblRegistrarIngredientes;
	private JLabel lblNewLabel;
	private JLabel lblTipo;
	private JTextArea txtProcedimiento;
	private JLabel lblMarca;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnAtrasVentana;

	/**
	 * Create the frame.
	 */
	public RecetasGestionar() {
		createGUI();
	}

	public void createGUI() {
		setResizable(false);
		setBackground(new Color(255, 165, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 373);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblRegistrarIngredientes = new JLabel("CONSULTAR RECETAS");
		lblRegistrarIngredientes.setBounds(51, 10, 281, 33);
		lblRegistrarIngredientes.setForeground(new Color(255, 255, 255));
		lblRegistrarIngredientes.setFont(new Font("Andalus", Font.BOLD, 25));
		contentPane.add(lblRegistrarIngredientes);

		lblNewLabel = new JLabel("T\u00EDtulo:");
		lblNewLabel.setBounds(51, 66, 49, 18);
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblNewLabel);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(171, 65, 205, 20);
		txtTitulo.setEditable(false);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		lblTipo = new JLabel("Procedimiento:");
		lblTipo.setBounds(51, 110, 111, 18);
		lblTipo.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblTipo);

		txtProcedimiento = new JTextArea();
		txtProcedimiento.setBounds(171, 107, 205, 60);
		txtProcedimiento.setEditable(false);
		txtProcedimiento.setLineWrap(true);
		txtProcedimiento.setColumns(10);
		txtProcedimiento.setRows(6);
		contentPane.add(txtProcedimiento);

		lblMarca = new JLabel("Terminolog\u00EDa:");
		lblMarca.setBounds(51, 182, 101, 18);
		lblMarca.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblMarca);

		txtTerminologia = new JTextField();
		txtTerminologia.setBounds(169, 181, 211, 20);
		txtTerminologia.setEditable(false);
		contentPane.add(txtTerminologia);
		txtTerminologia.setColumns(10);

		btnAnterior = new JButton("ANTERIOR");
		btnAnterior.setBounds(39, 211, 110, 30);
		btnAnterior.setPreferredSize(new Dimension(110, 30));
		btnAnterior.setForeground(new Color(255, 165, 0));
		btnAnterior.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAnterior.setBackground(new Color(255, 255, 204));
		contentPane.add(btnAnterior);

		btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setBounds(379, 211, 110, 30);
		btnSiguiente.setPreferredSize(new Dimension(110, 30));
		btnSiguiente.setForeground(new Color(255, 165, 0));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSiguiente.setBackground(new Color(255, 255, 204));
		contentPane.add(btnSiguiente);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(151, 252, 110, 30);
		btnActualizar.setPreferredSize(new Dimension(110, 50));
		btnActualizar.setForeground(new Color(255, 165, 0));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBackground(Color.WHITE);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(266, 252, 110, 30);
		btnEliminar.setPreferredSize(new Dimension(110, 50));
		btnEliminar.setForeground(new Color(255, 165, 0));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBackground(Color.WHITE);
		contentPane.add(btnEliminar);

		btnAtrasVentana = new JButton("Atr\u00E1s");
		btnAtrasVentana.setBounds(227, 293, 110, 30);

		btnAtrasVentana.setPreferredSize(new Dimension(110, 30));
		btnAtrasVentana.setForeground(new Color(255, 165, 0));
		btnAtrasVentana.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtrasVentana.setBackground(SystemColor.controlHighlight);
		contentPane.add(btnAtrasVentana);

		btnActualizar.addActionListener(new RecetasControlador(this));
		btnAnterior.addActionListener(new RecetasControlador(this));
		btnAtrasVentana.addActionListener(new RecetasControlador(this));
		btnEliminar.addActionListener(new RecetasControlador(this));
		btnSiguiente.addActionListener(new RecetasControlador(this));
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
