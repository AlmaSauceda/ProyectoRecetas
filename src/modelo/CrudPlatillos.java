package modelo;

import vistas.PlatilloGestionar;
import vistas.PlatilloRegistrar;
import vistas.Principal;

public class CrudPlatillos {

	/**
	 * Metodo para cambiar de ventana
	 * @param platiGes
	 */
	public void CrearVentanaAtras(PlatilloGestionar platiGes) {
		platiGes.setVisible(false);
		Principal p = new Principal();
		p.setVisible(true);
		platiGes.dispose();
		
	}

	/**
	 * Metodo para cambiar de ventana
	 * @param platiReg
	 */
	public void CrearVentanaAtras(PlatilloRegistrar platiReg) {
		platiReg.setVisible(false);
		Principal p = new Principal();
		p.setVisible(true);
		platiReg.dispose();
		
	}

}
