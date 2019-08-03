package vistas;

import java.awt.BorderLayout; 
import java.awt.Dimension; 
import java.awt.GridLayout;  
import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import controlador.ReporteControlador; 

public class VistaReportes extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final int MIN_V = 550;
	private static final int MIN_H = 300;
	 

	private static  String title = "REPORTES";
   
	private ReporteControlador controller;
 
	public VistaReportes() {
		createGui();
		 controller = new ReporteControlador(this);
	} 
	private void createGui() {
		this.setLayout(new BorderLayout()); 
		JButton btnFiltrado = new JButton("Reporte Filtrado"); 
		JButton btnSimple = new JButton("Reporte Simple"); 
		JButton btnParametros = new JButton("Reporte con Párametros");
	//	btnTicket.setIcon(new ImageIcon("imgs/ticket.png"));
		 
		JPanel piedPaginaTitle= new JPanel();
		piedPaginaTitle.setLayout(new GridLayout());
		piedPaginaTitle.add(btnFiltrado);
		piedPaginaTitle.add(btnSimple);
		piedPaginaTitle.add(btnParametros); 
			   
		this.setMinimumSize(new Dimension(MIN_V, MIN_H));
		this.add(piedPaginaTitle, BorderLayout.CENTER);
		this.pack();	
		this.setLocationRelativeTo(null);
		this.setVisible(true); 
		
		btnFiltrado.addActionListener(controller);
		btnSimple.addActionListener(controller);
		btnParametros.addActionListener(controller);
	}
	
}
