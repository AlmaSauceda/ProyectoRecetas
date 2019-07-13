package modelo;

import vistas.Principal;
import vistas.RecetasGestionar;
import vistas.RecetasRegistrar;

public class CrudRecetas {

	public void CrearVentanaAtras(RecetasRegistrar recReg) {
		recReg.setVisible(false);
		Principal p = new Principal();
		p.setVisible(true);
		recReg.dispose();		
	}

	public void CrearVentanaAtras(RecetasGestionar recGes) {
		recGes.setVisible(false);
		Principal p = new Principal();
		p.setVisible(true);
		recGes.dispose();	
		
	}

}
