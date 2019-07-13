package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.CrudRecetas;
import vistas.RecetasGestionar;
import vistas.RecetasRegistrar;

public class RecetasControlador implements ActionListener {

	private RecetasGestionar recGes;
	private RecetasRegistrar recReg;
	private CrudRecetas crudRec;

	public RecetasControlador(RecetasGestionar recGes) {
		this.recGes = recGes;
	}

	public RecetasControlador(RecetasRegistrar recReg) {
		this.recReg = recReg;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		crudRec = new CrudRecetas();
		
		if(recReg != null) {
			if(source == recReg.getBtnRegistrar()) {
				System.out.println("Aqui va Registrar");
			}else if(source == recReg.getBtnAtrasVentana()) {
				crudRec.CrearVentanaAtras(recReg);
			}
		}else {
			if(source == recGes.getBtnActualizar()) {
				System.out.println("Aqui va Actualizar");
			}else if(source == recGes.getBtnAnterior()) {
				System.out.println("Aqui va Anterior");
			}else if(source == recGes.getBtnEliminar()) {
				System.out.println("Aqui va Eliminar");
			}else if(source == recGes.getBtnSiguiente()) {
				System.out.println("Aqui va Siguiente");
			}else if(source == recGes.getBtnAtrasVentana()) {
				crudRec.CrearVentanaAtras(recGes);
			}
		}

	}

}
