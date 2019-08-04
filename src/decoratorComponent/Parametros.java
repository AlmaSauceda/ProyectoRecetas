package decoratorComponent;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import controlador.ReporteControlador;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

public class Parametros extends DecoradorReporte{

	private static final String REPORTE_RECETAS = "Inf_Report_Receta.jasper";
	private ReporteControlador control;
	private Map<String, Object> parameters;
	public Parametros(ReporteControlador reporteControlador) {
		this.control = reporteControlador;
	}

	@Override
	public void obtenerInforme() { 
		try {
			 parameters = new HashMap<String, Object>();
			 parameters.put("busqueda", control.obtenerParametro());
			jasperPrint = JasperFillManager.fillReport("reportes/"+REPORTE_RECETAS, parameters,conexion);
		} catch (JRException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void compilarInforme() {
		try {
		exportar = new JRPdfExporter();
		exportar.setExporterInput(new SimpleExporterInput(jasperPrint));
		exportar.setExporterOutput(new SimpleOutputStreamExporterOutput("reporteRecetas.pdf"));
		conf = new SimplePdfExporterConfiguration();
		exportar.setConfiguration(conf);
		exportar.exportReport();
		} catch (JRException e) { 
			e.printStackTrace();
		}  
	} 
	@Override
	public void MuestraInforme() {
		try {		
				jasperPrintWindow = JasperFillManager.fillReport("reportes/"+REPORTE_RECETAS, parameters,conexion);
			JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow,false);
			jasperViewer.setVisible(true);	 
		} catch (JRException e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
		} 
		
	} 


}
