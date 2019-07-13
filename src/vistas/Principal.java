package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Navegadores;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCocinacaj;
	private JButton btnGestionarIngre;
	private JLabel lblIngredientes;
	private JLabel lblRecetas;
	private JLabel lblPlatillos;
	private JButton btnAgregarIngre;
	private JButton btnAgregarRece;
	private JButton btnGestionarRece;
	private JButton btnAgregarPlati;
	private JButton btnGestionarPlat;

	/**
	 * Create the frame.
	 */
	public Principal() {
		createGui();
	}

	public void createGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 289);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCocinacaj = new JLabel("COCINA \"CAJ\"");
		lblCocinacaj.setBounds(167, 11, 230, 47);
		lblCocinacaj.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		contentPane.add(lblCocinacaj);

		btnGestionarIngre = new JButton("GESTIONAR");
		btnGestionarIngre.setBackground(new Color(255, 255, 102));
		btnGestionarIngre.setFont(new Font("Arial", Font.ITALIC, 15));
		btnGestionarIngre.setBounds(30, 164, 138, 24);
		contentPane.add(btnGestionarIngre);

		lblIngredientes = new JLabel("INGREDIENTES");
		lblIngredientes.setFont(new Font("Arial", Font.ITALIC, 20));
		lblIngredientes.setBounds(20, 85, 153, 24);
		contentPane.add(lblIngredientes);

		lblRecetas = new JLabel("RECETAS");
		lblRecetas.setFont(new Font("Arial", Font.ITALIC, 20));
		lblRecetas.setBounds(207, 85, 153, 24);
		contentPane.add(lblRecetas);

		lblPlatillos = new JLabel("PLATILLOS");
		lblPlatillos.setFont(new Font("Arial", Font.ITALIC, 20));
		lblPlatillos.setBounds(384, 85, 153, 24);
		contentPane.add(lblPlatillos);

		btnAgregarIngre = new JButton("AGREGAR");
		btnAgregarIngre.setFont(new Font("Arial", Font.ITALIC, 15));
		btnAgregarIngre.setBackground(new Color(255, 255, 102));
		btnAgregarIngre.setBounds(30, 120, 138, 24);
		contentPane.add(btnAgregarIngre);

		btnAgregarRece = new JButton("AGREGAR");
		btnAgregarRece.setFont(new Font("Arial", Font.ITALIC, 15));
		btnAgregarRece.setBackground(new Color(255, 255, 102));
		btnAgregarRece.setBounds(196, 120, 138, 24);
		contentPane.add(btnAgregarRece);

		btnGestionarRece = new JButton("GESTIONAR");
		btnGestionarRece.setFont(new Font("Arial", Font.ITALIC, 15));
		btnGestionarRece.setBackground(new Color(255, 255, 102));
		btnGestionarRece.setBounds(196, 164, 138, 24);
		contentPane.add(btnGestionarRece);

		btnAgregarPlati = new JButton("AGREGAR");
		btnAgregarPlati.setFont(new Font("Arial", Font.ITALIC, 15));
		btnAgregarPlati.setBackground(new Color(255, 255, 102));
		btnAgregarPlati.setBounds(374, 120, 138, 24);
		contentPane.add(btnAgregarPlati);

		btnGestionarPlat = new JButton("GESTIONAR");
		btnGestionarPlat.setFont(new Font("Arial", Font.ITALIC, 15));
		btnGestionarPlat.setBackground(new Color(255, 255, 102));
		btnGestionarPlat.setBounds(374, 164, 138, 24);
		contentPane.add(btnGestionarPlat);

		btnAgregarIngre.addActionListener(new Navegadores(this));
		btnAgregarPlati.addActionListener(new Navegadores(this));
		btnAgregarRece.addActionListener(new Navegadores(this));
		btnGestionarIngre.addActionListener(new Navegadores(this));
		btnGestionarPlat.addActionListener(new Navegadores(this));
		btnGestionarRece.addActionListener(new Navegadores(this));
	}

	/**
	 * @return the btnGestionarIngre
	 */
	public Object getBtnGestionarIngre() {
		return btnGestionarIngre;
	}

	/**
	 * @return the btnAgregarIngre
	 */
	public Object getBtnAgregarIngre() {
		return btnAgregarIngre;
	}

	/**
	 * @return the btnAgregarRece
	 */
	public Object getBtnAgregarRece() {
		return btnAgregarRece;
	}

	/**
	 * @return the btnGestionarRece
	 */
	public Object getBtnGestionarRece() {
		return btnGestionarRece;
	}

	/**
	 * @return the btnAgregarPlati
	 */
	public Object getBtnAgregarPlati() {
		return btnAgregarPlati;
	}

	/**
	 * @return the btnGestionarPlat
	 */
	public Object getBtnGestionarPlat() {
		return btnGestionarPlat;
	}

}
