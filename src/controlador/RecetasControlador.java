/***
 * Develop by Angel
 * 
 * Clase que contiene los metodos necesarios para controlar los botones de la clase RecetasRegistrar
 * 
 **/
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.CrudRecetas;
import View.Dialogs.*;
import vistas.Principal;
import vistas.RecetasGestionar;
import vistas.RecetasRegistrar;

public class RecetasControlador implements ActionListener {

	private RecetasGestionar recGes;
	private RecetasRegistrar recReg;
	private CrudRecetas crudRec = new CrudRecetas();

	public RecetasControlador(RecetasGestionar recGes) {
		this.recGes = recGes;
	}

	public RecetasControlador(RecetasRegistrar recReg) {
		this.recReg = recReg;
	}

	public RecetasControlador() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que acciona los botones y realiza la unión entre la vista y el modelo
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (recReg != null) {
			if (source == recReg.getBtnRegistrar()) {
				registrarReceta();
			} else if (source == recReg.getBtnAtrasVentana()) {
				CrearVentanaAtrasReg();
			} else if (source == recReg.getBtnAgregar()) {
				recReg.setTable(crudRec.InsertarFilas(recReg.getTable(), recReg.getCmbIngredienteS(),
						recReg.getTxtCantidad(), recReg.getTxtPorcion(), recReg.getTxtImplementacion()));
			}
		} else {
			if (source == recGes.getBtnActualizar()) {
				System.out.println("Aqui va Actualizar");
			} else if (source == recGes.getBtnAnterior()) {
				System.out.println("Aqui va Anterior");
			} else if (source == recGes.getBtnEliminar()) {
				System.out.println("Aqui va Eliminar");
			} else if (source == recGes.getBtnSiguiente()) {
				System.out.println("Aqui va Siguiente");
			} else if (source == recGes.getBtnAtrasVentana()) {
				CrearVentanaAtras();
			} else if (source == recReg.getBtnAgregar()) {
				recGes.setTable(crudRec.InsertarFilas(recGes.getTable(), recGes.getCmbIngredienteS(),
						recGes.getTxtCantidad(), recGes.getTxtPorcion(), recGes.getTxtImplementacion()));
			}
		}
	}

	/**
	 * Metodo que interactua entre la clase CrudRecetas y la vista RecetasRegistrar
	 * para realizar la consulta
	 */
	private void registrarReceta() {
		crudRec.RegistrarReceta(recReg.getCmbPlatilloS(), recReg.getTxtTitulo(), recReg.getTxtProcedimiento(),
				recReg.getTxtTerminologia(), recReg.getTxtComenzales());
		crudRec.registrarDetReceta(recReg.getTable());
		borrarDatos();
		Messages.showMessage("Registro de receta");
	}

	/**
	 * Metodo que interactua entre la clase CrudRecetas y la vista RecetasGestionar
	 * para realizar el llenado de los combos
	 */
	public void CargarCombosGes() {
		recGes.setCmbIngrediente(crudRec.cargarCombo(recGes.getCmbIngrediente(), "platillos"));
		recGes.setCmbPlatillo(crudRec.cargarCombo(recGes.getCmbPlatillo(), "platillos"));
	}

	/**
	 * Metodo que interactua entre la clase CrudRecetas y la vista RecetasRegistrar
	 * para realizar el llenado de los combos
	 */

	public void CargarCombosReg() {
		recReg.setCmbPlatillo(crudRec.cargarCombo(recReg.getCmbPlatillo(), "platillos"));
		recReg.setCmbIngrediente(crudRec.cargarCombo(recReg.getCmbIngrediente(), "platillos"));
	}

	/**
	 * Metodo para crear la ventana principal y ocultar la ventana RecetasRegistrar
	 * 
	 */
	public void CrearVentanaAtrasReg() {
		recReg.setVisible(false);
		Principal p = new Principal();
		p.setVisible(true);
		recReg.dispose();
	}

	/**
	 * Metodo para crear la ventana principal y ocultar la ventana RecetasGestionar
	 * 
	 */

	public void CrearVentanaAtras() {
		recGes.setVisible(false);
		Principal p = new Principal();
		p.setVisible(true);
		recGes.dispose();
	}
	
	/**
	 * Metodo para limpiar el formulario del JFrame RecetasRegistrar
	 */
	
	public void borrarDatos() {
		recReg.setCmbIngredienteCambio(1);
		recReg.setCmbPlatillo(1);
		recReg.setTxtTitulo("");
		recReg.setTxtTerminologia("");
		recReg.setTxtProcedimiento("");
		recReg.setTxtPorcion("");
		recReg.setTxtImplementacion("");
		recReg.setTxtComenzales(0);
		recReg.setTxtCantidad(0);
	}
}
