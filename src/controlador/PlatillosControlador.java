package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import View.Dialogs.Messages;
import vistas.PlatilloGestionar;
import vistas.PlatilloRegistrar;
import modelo.CrudPlatillos;
import modelo.ModelPlatillos;
import modelo.Platillos;

/**
 * Develop by joseline
 * Clase dedicada al control de los platillos
 * 
 * ***/


public class PlatillosControlador implements ActionListener {

	private PlatilloGestionar platiGes;
	private PlatilloRegistrar viewPlatillo;
	private CrudPlatillos crudPla;
	private ModelPlatillos modelPlat;
	private Platillos platillos;

	
	public PlatillosControlador(PlatilloRegistrar contactEditView){
		viewPlatillo = contactEditView;
		modelPlat= new ModelPlatillos();
		platillos=new Platillos();
	
	}
	
	public PlatillosControlador(PlatilloGestionar platiGes) {
		this.platiGes = platiGes;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		crudPla = new CrudPlatillos();

		if (platiGes != null) {
			if(source == platiGes.getBtnActualizar()) {
				System.out.println("Aqui va Actualizar");
			}else if (source == platiGes.getBtnAnterior()) {
				System.out.println("Aqui va Anterior");
			}else if (source == platiGes.getBtnEliminar()) {
				System.out.println("Aqui va Eliminar");
			}else if (source == platiGes.getBtnSiguiente()) {
				System.out.println("Aqui va Siguiente");
			}else if (source == platiGes.getBtnVentanaAtras()) {
				crudPla.CrearVentanaAtras(platiGes);
			}
		} else {
			if (source == viewPlatillo.getBtnAtrasVentana()) {
				crudPla.CrearVentanaAtras(viewPlatillo);
			}else if (source == viewPlatillo.getBtnRegistrar()) {
			
				System.out.println("Entro a controlador");
				registrar();
			}
		}
	}

	private void registrar() {
		platillos.setNombre(viewPlatillo.getTxtNombre());
		platillos.setDescripcion(viewPlatillo.getTxtDescripcion());
		platillos.setCosto(Double.parseDouble(viewPlatillo.getTxtCosto()));
		platillos.setNacionalidad(viewPlatillo.getTxtNacionalidad());
	platillos.setCategoria(viewPlatillo.getSelectedItem());
	
	System.out.println(""+platillos.getNombre()+ platillos.getDescripcion()+platillos.getCategoria()
	+platillos.getCosto()+platillos.getNacionalidad());
	
		
		try {
			modelPlat.registrarPlato(platillos);
			Messages.showMessage("\nSe agrego de forma correcta");
		} catch (ClassNotFoundException e) {
			Messages.showError("\nNo se registro\n"+e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			Messages.showError("\nNo se registro\n"+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
