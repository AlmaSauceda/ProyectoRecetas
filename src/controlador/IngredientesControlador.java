package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.CrudIngredientes;
import vistas.IngredientesGestionar;
import vistas.IngredientesRegistrar;

public class IngredientesControlador implements ActionListener {

	IngredientesRegistrar ingreReg;
	IngredientesGestionar ingreGes;
	CrudIngredientes crudIn;

	public IngredientesControlador(IngredientesRegistrar ingreReg) {
		this.ingreReg = ingreReg;
	}

	public IngredientesControlador(IngredientesGestionar ingreGes) {
		this.ingreGes = ingreGes;

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		crudIn = new CrudIngredientes();

		if (ingreReg != null) {
			if (source == ingreReg.getBtnRegistrar()) {
				System.out.println("Aqui va agregar!");
			} else if (source == ingreReg.getBtnAtrasVentana()) {
				crudIn.RegresarVentana(ingreReg);
			}
		} else {
			if (source == ingreGes.getBtnActualizar()) {
				System.out.println("Aqui va el metodo Actualizar");
			} else if (source == ingreGes.getBtnAnterior()) {
				System.out.println("Aqui va el metodo Anterior");
			} else if (source == ingreGes.getBtnEliminar()) {
				System.out.println("Aqui va el metodo Eliminar");
			} else if (source == ingreGes.getBtnSiguiente()) {
				System.out.println("Aqui va el metodo Siguiente!!");
			} else if (source == ingreGes.getBtnAtrasVentana()) {
				crudIn.RegresarVentana(ingreGes);
			}
		}

	}

}
