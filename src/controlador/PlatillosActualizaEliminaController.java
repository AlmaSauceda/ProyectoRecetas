package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vistas.PlatilloGestionar;
import vistas.Principal;

/**
 * Develop by joseline
 * Clase con el objetivo de actualizar, eliminar y consultar los registros
 * 
 * ***/

public class PlatillosActualizaEliminaController implements ActionListener {

	private PlatilloGestionar viewGestion;

	
	public PlatillosActualizaEliminaController(PlatilloGestionar platilloGestionar) {
		this.viewGestion=platilloGestionar;
	}



	@Override
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		
		
		
		if(source == viewGestion.getBtnActualizar()) {
		System.out.println("Aqui va Actualizar");
		}else if (source == viewGestion.getBtnAnterior()) {
			System.out.println("Anterir");
		}else if(source == viewGestion.getBtnEliminar()) {
			
			System.out.println("Aqui va Eliminar");
		}else if(source == viewGestion.getBtnSiguiente()) {
			System.out.println("Aqui va Siguiente");
	
		}else if (source == viewGestion.getBtnVentanaAtras()) {
			System.out.println("Aqui va atras");
			cerrarAbrir();
	
		}
	}
	
	private void cerrarAbrir() {
		viewGestion.setVisible(false);
		Principal viewPrincipal = new Principal();
		viewPrincipal.setVisible(true);
		viewGestion.dispose();
		
	}

	

}
