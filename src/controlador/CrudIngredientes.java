package controlador;

import vistas.IngredientesFiltro;
import vistas.IngredientesGestionar;
import vistas.IngredientesRegistrar;
import vistas.Principal;

public class CrudIngredientes {

	/**
	 * Metodo para regresar la ventana desde Ingredientes registrar
	 * @param ingreReg
	 */
	public void RegresarVentana(IngredientesRegistrar ingreReg) {
		ingreReg.setVisible(false);
		Principal p = new Principal();
		p.setVisible(true);
		ingreReg.dispose();
	}
	/**
	 * Metodo para regresar la ventana desde Ingredientes Filtro
	 * @param ingreReg
	 */
	public void RegresarVentana(IngredientesFiltro ingreReg) {
		ingreReg.setVisible(false);
		Principal p = new Principal();
		p.setVisible(true);
		ingreReg.dispose();
	}

	/**
	 * Metodo para regresar la ventana desde Ingredientes Gestionars
	 * @param ingreGes
	 */
	public void RegresarVentana(IngredientesGestionar ingreGes) {
		ingreGes.setVisible(false);
		Principal p = new Principal();
		p.setVisible(true);
		ingreGes.dispose();
	}
}
