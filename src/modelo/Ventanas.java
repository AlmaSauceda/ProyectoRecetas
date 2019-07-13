package modelo;

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
}
