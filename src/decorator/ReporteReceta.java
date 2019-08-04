package decorator;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteReceta extends Reporte{

	private static final String REPORTE_RECETAS = "Inf_Report_RecetaSimple.jasper";
	
	@Override
	public void obtenerInforme() { 
		try {
			jasperPrint = JasperFillManager.fillReport("reportes/"+REPORTE_RECETAS, null,conexion);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void compilarInforme() {
		try {
		exportar = new JRPdfExporter();
		exportar.setExporterInput(new SimpleExporterInput(jasperPrint));
		exportar.setExporterOutput(new SimpleOutputStreamExporterOutput("reporteRecetaSimple.pdf"));
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
				jasperPrintWindow = JasperFillManager.fillReport("reportes/"+REPORTE_RECETAS, null,conexion);
			JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow,false);
			jasperViewer.setVisible(true);	 
		} catch (JRException e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
		} 
		
	} 

}
