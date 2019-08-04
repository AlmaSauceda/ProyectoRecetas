package modelo;

/***
 * Develop by Angel
 * 
 * Clase para cambia de ventanas en diferentes partes del programa
 * 
 * **/

import vistas.*;

public class Ventanas {

	public void crearVentanaAgregarIngre(Principal princi) {
		princi.setVisible(false);
		IngredientesRegistrar p = new IngredientesRegistrar();
		p.setVisible(true);
		princi.dispose();
	}

	public void crearVentanaGestionarIngre(Principal princi) {
		princi.setVisible(false);
		IngredientesGestionar p = new IngredientesGestionar();
		p.setVisible(true);
		princi.dispose();

	}

	public void crearVentanaAgregarPlati(Principal princi) {
		princi.setVisible(false);
		PlatilloRegistrar p = new PlatilloRegistrar();
		p.setVisible(true);
		princi.dispose();

	}

	public void crearVentanaGestionarPlat(Principal princi) {
		princi.setVisible(false);
		PlatilloGestionar p = new PlatilloGestionar();
		p.setVisible(true);
		princi.dispose();
	}

	public void crearVentanaAgregarRece(Principal princi) {
		princi.setVisible(false);
		RecetasRegistrar p = new RecetasRegistrar();
		p.setVisible(true);
		princi.dispose();

	}

	public void crearVentanaGestionarRece(Principal princi) {
		princi.setVisible(false);
		RecetasGestionar p = new RecetasGestionar();
		p.setVisible(true);
		princi.dispose();

	}

	public void crearVentanaFiltroIngrediente(Principal princi) {
		princi.setVisible(false);
		IngredientesFiltro p = new IngredientesFiltro();
		p.setVisible(true);
		princi.dispose();
	}

	public void crearVentanaFiltroPlatillos(Principal princi) {
		princi.setVisible(false);
		PlatilloFiltro p = new PlatilloFiltro();
		p.setVisible(true);
		princi.dispose();
	}
		
	//Dev. by M.G.
	public void crearVentanaReporte(Principal princi) {
		princi.setVisible(false);
		VistaReportes p = new VistaReportes(princi);
		p.setVisible(true);
		princi.dispose();

	}
}
