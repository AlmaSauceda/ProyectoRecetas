package decoratorComponent;

import decorator.Informe;
import decorator.Reporte; 

public abstract class DecoradorReporte extends Reporte implements Informe {
	private Informe informe;

	public DecoradorReporte(Informe informe) { 
		this.informe = informe;
	}

	public Informe getInforme() {
		return informe;
	}

	public void setInforme(Informe informe) {
		this.informe = informe;
	}
	
}
