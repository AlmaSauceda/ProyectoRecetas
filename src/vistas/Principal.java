package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Navegadores;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
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
		setBounds(100, 100, 583, 359);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCocinacaj = new JLabel("COCINA \"CAJ\"");
		lblCocinacaj.setForeground(new Color(255, 102, 0));
		lblCocinacaj.setBounds(146, 28, 262, 47);
		lblCocinacaj.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 35));
		contentPane.add(lblCocinacaj);

		btnGestionarIngre = new JButton("GESTIONAR");
		btnGestionarIngre.setBackground(new Color(255, 255, 102));
		btnGestionarIngre.setFont(new Font("Arial", Font.ITALIC, 15));
		btnGestionarIngre.setBounds(55, 177, 138, 24);
		contentPane.add(btnGestionarIngre);

		lblIngredientes = new JLabel("INGREDIENTES");
		lblIngredientes.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblIngredientes.setBounds(45, 98, 153, 24);
		contentPane.add(lblIngredientes);

		lblRecetas = new JLabel("RECETAS");
		lblRecetas.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblRecetas.setBounds(374, 98, 153, 24);
		contentPane.add(lblRecetas);

		lblPlatillos = new JLabel("PLATILLOS");
		lblPlatillos.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblPlatillos.setBounds(221, 98, 153, 24);
		contentPane.add(lblPlatillos);

		btnAgregarIngre = new JButton("AGREGAR");
		btnAgregarIngre.setFont(new Font("Arial", Font.ITALIC, 15));
		btnAgregarIngre.setBackground(new Color(255, 255, 102));
		btnAgregarIngre.setBounds(55, 133, 138, 24);
		contentPane.add(btnAgregarIngre);

		btnAgregarRece = new JButton("AGREGAR");
		btnAgregarRece.setFont(new Font("Arial", Font.ITALIC, 15));
		btnAgregarRece.setBackground(new Color(255, 255, 102));
		btnAgregarRece.setBounds(363, 133, 138, 24);
		contentPane.add(btnAgregarRece);

		btnGestionarRece = new JButton("GESTIONAR");
		btnGestionarRece.setFont(new Font("Arial", Font.ITALIC, 15));
		btnGestionarRece.setBackground(new Color(255, 255, 102));
		btnGestionarRece.setBounds(363, 177, 138, 24);
		contentPane.add(btnGestionarRece);

		btnAgregarPlati = new JButton("AGREGAR");
		btnAgregarPlati.setFont(new Font("Arial", Font.ITALIC, 15));
		btnAgregarPlati.setBackground(new Color(255, 255, 102));
		btnAgregarPlati.setBounds(211, 133, 138, 24);
		contentPane.add(btnAgregarPlati);

		btnGestionarPlat = new JButton("GESTIONAR");
		btnGestionarPlat.setFont(new Font("Arial", Font.ITALIC, 15));
		btnGestionarPlat.setBackground(new Color(255, 255, 102));
		btnGestionarPlat.setBounds(211, 177, 138, 24);
		contentPane.add(btnGestionarPlat);
		Image imagen = new ImageIcon(this.getClass().getResource("/fontoPrincipal.jpg")).getImage();
		
		JButton btnReportes = new JButton("REPORTES");
		btnReportes.setFont(new Font("Arial", Font.ITALIC, 15));
		btnReportes.setBackground(new Color(255, 255, 102));
		btnReportes.setBounds(136, 218, 138, 24);
		contentPane.add(btnReportes);
				
				JButton btnFiltros = new JButton("FILTROS");
				btnFiltros.setFont(new Font("Arial", Font.ITALIC, 15));
				btnFiltros.setBackground(new Color(255, 255, 102));
				btnFiltros.setBounds(284, 220, 138, 24);
				contentPane.add(btnFiltros);
				
						JLabel fondo = new JLabel("");
						fondo.setIcon(new ImageIcon(imagen));
						fondo.setBounds(0, 0, 567, 320);
						contentPane.add(fondo);
		
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
