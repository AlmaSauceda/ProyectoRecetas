package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.PlatillosFiltroControlador;

import javax.swing.DefaultComboBoxModel;

public class PlatilloFiltro extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblFiltrarPlatillos;
	private JLabel label_1;
	private JComboBox cmbFiltro;
	private JLabel label_2;
	public JComboBox cmbDatos;
	private JButton button;
	private JScrollPane scrollPane;
	private PlatillosFiltroControlador controlador;

	/**
	 * Create the frame.
	 */
	public PlatilloFiltro() {
		controlador = new PlatillosFiltroControlador(this);
		createGui();

	}

	private void createGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Image imagen = new ImageIcon(this.getClass().getResource("/fondoPlatillos.jpg")).getImage();
		contentPane.setLayout(null);

		lblFiltrarPlatillos = new JLabel("FILTRAR PLATILLOS");
		lblFiltrarPlatillos.setForeground(Color.BLACK);
		lblFiltrarPlatillos.setFont(new Font("Dialog", Font.BOLD, 25));
		lblFiltrarPlatillos.setBackground(Color.BLACK);
		lblFiltrarPlatillos.setBounds(108, 29, 341, 33);
		contentPane.add(lblFiltrarPlatillos);

		label_1 = new JLabel("Filtrar por:");
		label_1.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_1.setBounds(32, 73, 88, 18);
		contentPane.add(label_1);

		cmbFiltro = new JComboBox();
		cmbFiltro.setModel(
				new DefaultComboBoxModel(new String[] { "-Seleccione-", "Categoria", "Nacionalidad", "Costo" }));
		cmbFiltro.setBounds(126, 72, 107, 20);
		contentPane.add(cmbFiltro);

		label_2 = new JLabel("Datos:");
		label_2.setFont(new Font("Cambria Math", Font.BOLD, 15));
		label_2.setBounds(263, 73, 57, 18);
		contentPane.add(label_2);

		cmbDatos = new JComboBox();
		cmbDatos.setModel(new DefaultComboBoxModel(new String[] { "-Seleccione-" }));
		cmbDatos.setBounds(330, 72, 101, 20);
		contentPane.add(cmbDatos);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 124, 429, 185);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Descripci\u00F3n", "Costo", "Categoria", "Nacionalidad"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(108);
		table.getColumnModel().getColumn(2).setPreferredWidth(53);
		scrollPane.setViewportView(table);

		button = new JButton("Atr\u00E1s");
		button.setPreferredSize(new Dimension(110, 30));
		button.setForeground(new Color(255, 165, 0));
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(351, 323, 110, 30);
		contentPane.add(button);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(imagen));
		fondo.setBounds(0, 0, 497, 371);
		contentPane.add(fondo);

		cmbDatos.addActionListener(controlador);
		cmbFiltro.addActionListener(controlador);
		button.addActionListener(controlador);
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
	 * @return the cmbFiltro
	 */
	public Object getCmbFiltro() {
		return cmbFiltro;
	}

	/**
	 * @return the cmbFiltro
	 */
	public String getCmbFiltroString() {
		return cmbFiltro.getSelectedItem().toString();
	}

	/**
	 * @param cmbFiltro the cmbFiltro to set
	 */
	public void setCmbFiltro(JComboBox cmbFiltro) {
		this.cmbFiltro = cmbFiltro;
	}

	/**
	 * @return the cmbDatos
	 */
	public Object getCmbDatos() {
		return cmbDatos;
	}

	/**
	 * @return the cmbDatos
	 */
	public String getCmbDatosString() {
		return cmbDatos.getSelectedItem().toString();
	}

	/**
	 * @param cmbDatos the cmbDatos to set
	 */
	public void setCmbDatos(JComboBox cmbDatos) {
		this.cmbDatos = cmbDatos;
	}

	/**
	 * @return the button
	 */
	public Object getButton() {
		return button;
	}

	public JComboBox getCmbDatosCmb() {
		return cmbDatos;
	}

}
