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

public class RecetasRegistrar extends JFrame {

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

	/**
	 * Create the frame.
	 */
	public RecetasRegistrar() {
		setResizable(false);
		setBackground(new Color(255, 165, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 306);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblRegistrarIngredientes = new JLabel("REGISTRAR RECETA");
		lblRegistrarIngredientes.setBounds(137, 10, 255, 33);
		lblRegistrarIngredientes.setForeground(new Color(255, 255, 255));
		lblRegistrarIngredientes.setFont(new Font("Andalus", Font.BOLD, 25));
		contentPane.add(lblRegistrarIngredientes);

		lblNewLabel = new JLabel("T\u00EDtulo:");
		lblNewLabel.setBounds(39, 59, 49, 18);
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblNewLabel);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(154, 58, 293, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		lblTipo = new JLabel("Procedimiento:");
		lblTipo.setBounds(39, 108, 111, 18);
		lblTipo.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblTipo);

		txtProcedimiento = new JTextArea();
		txtProcedimiento.setBounds(154, 89, 293, 83);
		txtProcedimiento.setLineWrap(true);
		txtProcedimiento.setColumns(10);
		txtProcedimiento.setRows(6);
		contentPane.add(txtProcedimiento);

		lblMarca = new JLabel("Terminolog\u00EDa:");
		lblMarca.setBounds(39, 187, 101, 18);
		lblMarca.setFont(new Font("Cambria Math", Font.BOLD, 15));
		contentPane.add(lblMarca);

		txtTerminologia = new JTextField();
		txtTerminologia.setBounds(154, 186, 293, 20);
		contentPane.add(txtTerminologia);
		txtTerminologia.setColumns(10);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(188, 227, 110, 30);
		btnRegistrar.setPreferredSize(new Dimension(110, 30));
		btnRegistrar.setForeground(new Color(255, 165, 0));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrar.setBackground(new Color(255, 255, 204));
		contentPane.add(btnRegistrar);

		btnAtrasVentana = new JButton("Atr\u00E1s");
		btnAtrasVentana.setBounds(337, 227, 110, 30);

		btnAtrasVentana.setPreferredSize(new Dimension(110, 30));
		btnAtrasVentana.setForeground(new Color(255, 165, 0));
		btnAtrasVentana.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtrasVentana.setBackground(SystemColor.controlHighlight);
		contentPane.add(btnAtrasVentana);

		btnAtrasVentana.addActionListener(new RecetasControlador(this));
		btnRegistrar.addActionListener(new RecetasControlador(this));
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

}
