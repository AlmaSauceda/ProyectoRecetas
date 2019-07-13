package modelo;

import vistas.PlatilloGestionar;
import vistas.PlatilloRegistrar;
import vistas.Principal;

public class CrudPlatillos {

	public void CrearVentanaAtras(PlatilloGestionar platiGes) {
		platiGes.setVisible(false);
		Principal p = new Principal();
		p.setVisible(true);
		platiGes.dispose();
		
	}

	public void CrearVentanaAtras(PlatilloRegistrar platiReg) {
		platiReg.setVisible(false);
		Principal p = new Principal();
		p.setVisible(true);
		platiReg.dispose();
		
	}

}
