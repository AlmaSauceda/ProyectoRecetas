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
import modelo.DetalleReceta;
import modelo.ModelReceta;
import modelo.Receta;
import View.Dialogs.*;
import vistas.Principal;
import vistas.RecetasGestionar;
import vistas.RecetasRegistrar;

public class RecetasControlador implements ActionListener {

	private RecetasGestionar recGes;
	private RecetasRegistrar recReg;
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
				try {
					recReg.setTable(modelRece.InsertarFilas(recReg.getTable(), crearDetalle()));
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			if (source == recGes.getBtnActualizar()) {
				//

				if (recGes.btnActualizar.getText().equals("ACTUALIZAR")) {
					habilitarCampos();
				} else {
					actualizar();
					deshabilitarCampos();
					cargarIngredientes();
					consultar();
				}

				//
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
				if (recGes.getBtnEliminar().equals("Cancelar")) {
					deshabilitarCampos();
					cargarIngredientes();
				} else {
					eliminar();
					cargarIngredientes();
				}
				consultar();

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
				try {
					recGes.setTable(modelRece.InsertarFilas(recGes.getTable(), crearDetalle()));
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Metodo para consultar el detalle de la receta
	 */
	private void consultarDetalle() {
		try {
			listaDetRece = modelRece.consultarDetalleReceta(listaRece.get(indice).getId_receta());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (listaDetRece.size() > 0) {
			recGes.setTable(modelRece.eliminarValoresTabla(recGes.getTable()));

			for (int i = 0; i < listaDetRece.size(); i++) {
				int numCols = recGes.getTable().getModel().getColumnCount();
				Object[] fila = new Object[numCols];
				fila[0] = listaDetRece.get(i).getNombre();
				fila[1] = listaDetRece.get(i).getCantidad();
				fila[2] = listaDetRece.get(i).getPorcion();
				fila[3] = listaDetRece.get(i).getImplementacion();
				((DefaultTableModel) recGes.getTable().getModel()).addRow(fila);
			}
			recGes.setTable(recGes.getTable());
		}
	}

	/**
	 * Metodo para consultar las recetas
	 */
	private void consultar() {
		if (listaRece.size() > 0) {
			try {
				recGes.setMandarCmbPlatillo(modelRece.recuperarNombre(listaRece.get(indice).getId_platillo()));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			recGes.setTxtTitulo(listaRece.get(indice).getTitulo());
			recGes.setTxtProcedimiento(listaRece.get(indice).getProcedimiento());
			recGes.setTxtTerminologia(listaRece.get(indice).getTerminologia());
			recGes.setTxtComenzales(listaRece.get(indice).getComensales());
		} else {
			System.out.println("No hay registros para mostrar");
		}

	}

	/**
	 * Metodo para cargar las listas de las recetas
	 */
	private void cargarIngredientes() {
		listaRece = new ArrayList<Receta>();
		try {
			indice = 0;
			listaRece = modelRece.consultarReceta();
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
		Receta receta = new Receta();
		receta.setTitulo(recReg.getTxtTitulo());
		receta.setProcedimiento(recReg.getTxtProcedimiento());
		receta.setTerminologia(recReg.getTxtTerminologia());
		receta.setComensales(recReg.getTxtComenzales());
		try {
			receta.setId_platillo(modelRece.consultarID(recReg.getCmbPlatilloS()));
			modelRece.registrarReceta(receta);
			recReg.setTable(modelRece.registrarDetReceta(recReg.getTable()));
			Messages.showMessage("\nSe agrego de forma correcta");
		} catch (ClassNotFoundException e) {
			Messages.showError("\nNo se registro\n" + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			Messages.showError("\nNo se registro\n" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		borrarDatos();
		Messages.showMessage("Registro de receta");
	}

	/**
	 * Metodo que interactua entre la clase CrudRecetas y la vista RecetasGestionar
	 * para realizar el llenado de los combos
	 */
	public void CargarCombosGes() {
		try {
			recGes.setCmbIngrediente(modelRece.cargarCombo(recGes.getCmbIngrediente(), "ingredientes"));
			recGes.setCmbPlatillo(modelRece.cargarCombo(recGes.getCmbPlatillo(), "platillos"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Metodo que interactua entre la clase CrudRecetas y la vista RecetasRegistrar
	 * para realizar el llenado de los combos
	 */

	public void CargarCombosReg() {
		try {
			recReg.setCmbPlatillo(modelRece.cargarCombo(recReg.getCmbPlatillo(), "platillos"));
			recReg.setCmbIngrediente(modelRece.cargarCombo(recReg.getCmbIngrediente(), "ingredientes"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	/**
	 * Metodo para deshabilitar los campos de la vista
	 */
	private void deshabilitarCampos() {
		recGes.txtCantidad.setEnabled(false);
		recGes.txtComenzales.setEnabled(false);
		recGes.txtImplementacion.setEditable(false);
		recGes.txtPorcion.setEditable(false);
		recGes.txtTerminologia.setEditable(false);
		recGes.txtTitulo.setEditable(false);
		recGes.btnActualizar.setText("ACTUALIZAR");
		recGes.btnEliminar.setText("ELIMINAR");
	}

	/**
	 * Metodo para habilitar los campos de la vista
	 */
	private void habilitarCampos() {
		recGes.txtCantidad.setEnabled(true);
		recGes.txtComenzales.setEnabled(true);
		recGes.txtImplementacion.setEditable(true);
		recGes.txtPorcion.setEditable(true);
		recGes.txtTerminologia.setEditable(true);
		recGes.txtTitulo.setEditable(true);
		recGes.btnActualizar.setText("GUARDAR");
		recGes.btnEliminar.setText("CANCELAR");

	}

	/**
	 * Metodo para eliminar
	 */

	public void eliminar() {
		try {
			modelRece.eliminarReceta(listaRece.get(indice).getId_receta());
			;
			Messages.showMessage("\nSe eliminó correctamente");
		} catch (ClassNotFoundException e) {
			Messages.showError("\nNo se eliminó\n" + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			Messages.showError("\nNo se eliminó\n" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para Actualizar la receta
	 */
	public DetalleReceta crearDetalle() {
		DetalleReceta dt = new DetalleReceta();

		dt.setCantidad(recReg.getTxtCantidad());
		dt.setPorcion(recReg.getTxtPorcion());
		dt.setImplementacion(recReg.getTxtImplementacion());
		try {
			dt.setId_ingrediente(modelRece.recuperarIdIngrediente(recReg.getCmbIngredienteS()));
			return dt;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dt;
	}

	/**
	 * Metodo para actualizar recetas (sin actualizar el detalle)
	 */
	private void actualizar() {
		Receta receta = new Receta();
		receta.setTitulo(recGes.getTxtTitulo());
		receta.setProcedimiento(recGes.getTxtProcedimiento());
		receta.setTerminologia(recGes.getTxtTerminologia());
		receta.setComensales(recGes.getTxtComenzales());
		receta.setId_receta(listaRece.get(indice).getId_receta());
		try {
			receta.setId_platillo(modelRece.consultarID(recGes.getCmbPlatilloS()));
			modelRece.actualizarReceta(receta);
			Messages.showMessage("\nSe actualizó correctamente");
		} catch (ClassNotFoundException e) {
			Messages.showError("\nNo se actualizó\n" + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			Messages.showError("\nNo se actualizó\n" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
