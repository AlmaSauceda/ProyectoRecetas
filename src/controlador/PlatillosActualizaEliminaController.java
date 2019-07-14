package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modelo.ModelPlatillos;
import modelo.Platillos;
import vistas.PlatilloGestionar;
import vistas.Principal;

/**
 * Develop by joseline
 * Clase con el objetivo de actualizar, eliminar y consultar los registros
 * 
 * ***/

public class PlatillosActualizaEliminaController implements ActionListener {

	private PlatilloGestionar viewGestion;
	private ModelPlatillos modelPlat;
	private Platillos platillos;
	
	public PlatillosActualizaEliminaController(PlatilloGestionar platilloGestionar) {
		this.viewGestion=platilloGestionar;
		modelPlat= new ModelPlatillos();
		platillos=new Platillos();
	}

	private void llenar() {
		try {
	    List<Platillos> listPlatillos = modelPlat.getPlatillos();
		Iterator<Platillos> it = listPlatillos.iterator();
		while(it.hasNext())
		System.out.println(it.next().toString());
		} catch (ClassNotFoundException | SQLException e) {
	    e.printStackTrace();
		}	
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
	
		if(source == viewGestion.getBtnActualizar()) {
		System.out.println("Aqui va Actualizar");
		llenar();
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
