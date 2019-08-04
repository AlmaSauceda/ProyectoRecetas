package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
 
import decorator.Reporte;
import decorator.ReporteReceta;
import decoratorComponent.Parametros; 
import model.db.ConectionPostgresql;
import vistas.VistaReportes;

public class ReporteControlador implements ActionListener{

	private VistaReportes view;
	public ReporteControlador(VistaReportes vistaReportes) {
		view = vistaReportes;
		addListener();
	}
	private void addListener() {
		view.getBtnFiltrado().addActionListener(this);
		view.getBtnSimple().addActionListener(this); 
		view.addWindowListener(new ControllerWindowAdapter());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
  
			if (e.getSource() == view.getBtnFiltrado()) {
				llamarReporteFiltros(); 
			} 
			if (e.getSource() == view.getBtnSimple()) {
				llamarReporteSimple(); 
			}
	}
	public void llamarReporteSimple() {
		Reporte reporte = new ReporteReceta(); 
		try { 
			ConectionPostgresql.getInstance();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		reporte.setConexion(ConectionPostgresql.getConnection());
		reporte.obtenerInforme();
		reporte.compilarInforme();
		reporte.MuestraInforme(); 
	}
	public void llamarReporteFiltros() {
		Reporte reporte = new Parametros(this, new ReporteReceta()); 
		try { 
			ConectionPostgresql.getInstance();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		reporte.setConexion(ConectionPostgresql.getConnection());
		reporte.obtenerInforme();
		reporte.compilarInforme();
		reporte.MuestraInforme(); 
	}
	public String obtenerParametro() {
		return view.solicitaParametro();
	}
	
	public class ControllerWindowAdapter extends WindowAdapter{		
		public void windowClosing(WindowEvent arg0) {  
			view.dispose();
			view.getPrincipal().setVisible(true);
		}
	}
}
