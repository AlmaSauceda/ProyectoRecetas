package modelo;

import vistas.IngredientesGestionar;
import vistas.IngredientesRegistrar;
import vistas.Principal;

public class CrudIngredientes {

	public void RegresarVentana(IngredientesRegistrar ingreReg) {
		ingreReg.setVisible(false);
		Principal p = new Principal();
		p.setVisible(true);
		ingreReg.dispose();
	}

	public void RegresarVentana(IngredientesGestionar ingreGes) {
		ingreGes.setVisible(false);
		Principal p = new Principal();
		p.setVisible(true);
		ingreGes.dispose();
	}
}
