package decorator;

import java.sql.Connection;
 
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter; 
import net.sf.jasperreports.export.SimplePdfExporterConfiguration; 

public abstract class Reporte implements Informe{


	protected JasperPrint  jasperPrint;
	protected String name;
	protected Connection conexion;
	protected JRPdfExporter exportar;
	protected JasperPrint jasperPrintWindow; 
	protected SimplePdfExporterConfiguration conf;
	
	@Override
	public void obtenerInforme() { }

	@Override
	public void compilarInforme() {}

	@Override
	public void MuestraInforme() {}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
	
	
}
