/***
 * Develop by Angel
 * 
 * Clase que contiene los metodos necesarios para controlar los botones de la clase RecetasRegistrar
 * 
 **/
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.CrudRecetas;
import modelo.DetalleReceta;
import modelo.Ingredientes;
import modelo.ModelReceta;
import modelo.Receta;
import View.Dialogs.*;
import vistas.Principal;
import vistas.RecetasGestionar;
import vistas.RecetasRegistrar;

public class RecetasControlador implements ActionListener {

	private RecetasGestionar recGes;
	private RecetasRegistrar recReg;
	private CrudRecetas crudRec = new CrudRecetas();
	private ArrayList<Receta> listaRece = new ArrayList<Receta>();
	private ArrayList<DetalleReceta> listaDetRece = new ArrayList<DetalleReceta>();
	private int indice = 0;
	private int indiceDet;
	private ModelReceta modelRece;

	public RecetasControlador(RecetasGestionar recGes) {
		this.recGes = recGes;
		modelRece = new ModelReceta();
		cargarIngredientes();

	}

	public RecetasControlador(RecetasRegistrar recReg) {
		this.recReg = recReg;
		modelRece = new ModelReceta();
		cargarIngredientes();
	}

	public RecetasControlador() {
		modelRece = new ModelReceta();
		cargarIngredientes();
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

				if (indiceDet > 0) {
					indiceDet--;
				}
				if (indice > 0) {
					indice--;
				} else {
					JOptionPane.showMessageDialog(null, "Este es el primer registro");
				}
				consultar();

				consultarDetalle();
			} else if (source == recGes.getBtnEliminar()) {
				System.out.println("Aqui va Eliminar");
			} else if (source == recGes.getBtnSiguiente()) {

				if (indice + 1 < listaRece.size()) {
					indice++;

				} else {
					JOptionPane.showMessageDialog(null, "Este es el último registro");
				}

				if (indiceDet + 1 < listaDetRece.size()) {
					indiceDet++;
				}
				consultar();
				consultarDetalle();
			} else if (source == recGes.getBtnAtrasVentana()) {
				CrearVentanaAtras();
			} else if (source == recReg.getBtnAgregar()) {
				recGes.setTable(crudRec.InsertarFilas(recGes.getTable(), recGes.getCmbIngredienteS(),
						recGes.getTxtCantidad(), recGes.getTxtPorcion(), recGes.getTxtImplementacion()));
			}
		}
	}

	private void consultarDetalle() {
		if (listaDetRece.size() > 0) {
			recGes.setTable(crudRec.eliminarValoresTabla(recGes.getTable()));
			int numCols = recGes.getTable().getModel().getColumnCount();
			Object[] fila = new Object[numCols];
			fila[0] = listaDetRece.get(indiceDet).getId_ingrediente();
			fila[1] = listaDetRece.get(indiceDet).getCantidad();
			fila[2] = listaDetRece.get(indiceDet).getPorcion();
			fila[3] = listaDetRece.get(indiceDet).getImplementacion();

			((DefaultTableModel) recGes.getTable().getModel()).addRow(fila);

			recGes.setTable(recGes.getTable());
		}
	}

	private void consultar() {
		if (listaRece.size() > 0) {
			recGes.setMandarCmbPlatillo(crudRec.recuperarNombre(listaRece.get(indice).getId_platillo()));
			recGes.setTxtTitulo(listaRece.get(indice).getTitulo());
			recGes.setTxtProcedimiento(listaRece.get(indice).getProcedimiento());
			recGes.setTxtTerminologia(listaRece.get(indice).getTerminologia());
			recGes.setTxtComenzales(listaRece.get(indice).getComensales());
		} else {
			System.out.println("No hay registros para mostrar");
		}

	}

	private void cargarIngredientes() {
		listaRece = new ArrayList<Receta>();
		try {
			indice = 0;
			listaRece = modelRece.consultarReceta();
			listaDetRece = modelRece.consultarDetalleReceta();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo que interactua entre la clase CrudRecetas y la vista RecetasRegistrar
	 * para realizar la consulta
	 */
	private void registrarReceta() {
		crudRec.RegistrarReceta(recReg.getCmbPlatilloS(), recReg.getTxtTitulo(), recReg.getTxtProcedimiento(),
				recReg.getTxtTerminologia(), recReg.getTxtComenzales());
		recReg.setTable(crudRec.registrarDetReceta(recReg.getTable()));
		borrarDatos();
		Messages.showMessage("Registro de receta");
	}

	/**
	 * Metodo que interactua entre la clase CrudRecetas y la vista RecetasGestionar
	 * para realizar el llenado de los combos
	 */
	public void CargarCombosGes() {
		recGes.setCmbIngrediente(crudRec.cargarCombo(recGes.getCmbIngrediente(), "ingredientes"));
		recGes.setCmbPlatillo(crudRec.cargarCombo(recGes.getCmbPlatillo(), "platillos"));
	}

	/**
	 * Metodo que interactua entre la clase CrudRecetas y la vista RecetasRegistrar
	 * para realizar el llenado de los combos
	 */

	public void CargarCombosReg() {
		recReg.setCmbPlatillo(crudRec.cargarCombo(recReg.getCmbPlatillo(), "platillos"));
		recReg.setCmbIngrediente(crudRec.cargarCombo(recReg.getCmbIngrediente(), "ingredientes"));
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
