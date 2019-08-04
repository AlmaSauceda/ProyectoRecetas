package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controlador.ReporteControlador;

/**
 * @author MARCK 1
 *
 */
public class VistaReportes extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int MIN_V = 550;
	private static final int MIN_H = 250;
	private JButton btnFiltrado;
	private JButton btnSimple;  
	private Principal principal;
	
	public VistaReportes(Principal principal) {
		this.principal =principal;
		createGui();
		new ReporteControlador(this);
	}

	private void createGui() {
		this.setLayout(new BorderLayout());
		btnFiltrado = new JButton("Reporte Filtrado");
	    btnSimple = new JButton("Reporte Simple");
	   
		JPanel piedPaginaTitle = new JPanel();
		piedPaginaTitle.setLayout(new GridLayout());
		piedPaginaTitle.add(btnFiltrado);
		piedPaginaTitle.add(btnSimple); 
		
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout()); 
		jpanel.setBackground(Color.cyan);
		
		this.setMinimumSize(new Dimension(MIN_V, MIN_H)); 
		this.add(jpanel, BorderLayout.CENTER); 
		this.add(piedPaginaTitle, BorderLayout.BEFORE_FIRST_LINE); 
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
 
	}

	public JButton getBtnFiltrado() {
		return btnFiltrado;
	}

	public JButton getBtnSimple() {
		return btnSimple;
	}

	public String solicitaParametro() { 
		return JOptionPane.showInputDialog(null, "Ingresa Párametro de Busqueda");
	}

	public Principal getPrincipal() {
		return principal;
	}
	
}
