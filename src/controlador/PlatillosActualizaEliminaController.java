package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import View.Dialogs.Messages;
import modelo.Ingredientes;
import modelo.ModelPlatillos;
import modelo.Platillos;
import vistas.PlatilloGestionar;
import vistas.Principal;

/**
 * Develop by joseline Clase con el objetivo de actualizar, eliminar y consultar
 * los registros
 * 
 ***/

public class PlatillosActualizaEliminaController implements ActionListener {

	private PlatilloGestionar viewGestion;
	private ModelPlatillos modelPlat;
	private Platillos platillos;
	private int indice = 0;
	private ArrayList<Platillos> listPlatillos = new ArrayList<Platillos>();

	// constructor con parametros
	public PlatillosActualizaEliminaController(PlatilloGestionar platilloGestionar) {
		this.viewGestion = platilloGestionar;
		modelPlat = new ModelPlatillos();
		platillos = new Platillos();
		fill();
		consultar();
		disableTxt();
	}

	/**
	 * Metodo para utilizar el ActionEvent para el uso de los botones
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();

		if (viewGestion != null) {
			if (source == viewGestion.getBtnActualizar()) {
				doActualizar();
			} else if (source == viewGestion.getBtnAnterior()) {
				doAnterior();
			} else if (source == viewGestion.getBtnEliminar()) {
				doEliminar();
			} else if (source == viewGestion.getBtnSiguiente()) {
				doSiguiente();
			} else if (source == viewGestion.getBtnVentanaAtras()) {
				cerrarAbrir();
			}
		}
	}

	/**
	 * Metodo para unir metodos necesarios para actualizar
	 */
	private void doActualizar() {
		if (viewGestion.getBtnActualizar().getText().equals("ACTUALIZAR")) {
			enableTxt();
		} else {
			actualizar();
			disableTxt();
			fill();
			consultar();
		}

	}

	/**
	 * metodo para actualizar platillos
	 */
	public void actualizar() {
		platillos.setNombre(viewGestion.getNombre());
		platillos.setDescripcion(viewGestion.getDescripcion());
		platillos.setCosto(Double.parseDouble(viewGestion.getCosto()));
		platillos.setCategoria(viewGestion.getSelectedItem());
		platillos.setNacionalidad(viewGestion.getNacionalidad());

		try {
			modelPlat.updatePlatillos(platillos);
			Messages.showMessage("\n Se realizo la actualización");
		} catch (ClassNotFoundException e) {
			Messages.showError("\nNo se actualizó\n" + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			Messages.showError("\nNo se actualizó\n" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para consultar platillos
	 */
	private void consultar() {

		if (listPlatillos.size() > 0) {
			viewGestion.setTxtNombre(listPlatillos.get(indice).getNombre());
			viewGestion.setTxtDescripcion(listPlatillos.get(indice).getDescripcion());
			viewGestion.setTxtCosto(String.valueOf(listPlatillos.get(indice).getCosto()));
			viewGestion.setJcbCtegorias(listPlatillos.get(indice).getCategoria());
			viewGestion.setTxtNacionalidad(listPlatillos.get(indice).getNacionalidad());

			platillos = listPlatillos.get(indice);
		} else {
			Messages.showError(" No hay registros para mostrar");
			disableButton();

		}
	}

	/**
	 * Metodo para llenar la lista de platillos
	 */
	public void fill() {
		listPlatillos = new ArrayList<Platillos>();
		try {
			indice = 0;
			listPlatillos = modelPlat.getPlatillos();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para validar el boton siguiente
	 */
	private void doSiguiente() {
		if (indice + 1 < listPlatillos.size()) {
			indice++;
		} else {
			Messages.showAlert(" Este es el último registro");
		}
		consultar();
	}

	/**
	 * Metodo para validar el boton de eliminar
	 */
	private void doEliminar() {
		if (viewGestion.getBtnActualizar().getText().equals("Cancelar")) {
			disableTxt();
			fill();
		} else {
			eliminar();
			fill();
		}
		consultar();
	}

	/**
	 * Metodo para validar el boton anterior
	 */
	private void doAnterior() {
		if (indice > 0) {
			indice--;
		} else {
			Messages.showAlert(" Este es el primer registro");
		}
		consultar();

	}

	/**
	 * Metodo para eliminar platillos
	 */
	public void eliminar() {
		try {
			modelPlat.deletePlatillos(platillos);
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
	 * Metodo para cambiar de pantalla
	 */
	private void cerrarAbrir() {
		viewGestion.setVisible(false);
		Principal viewPrincipal = new Principal();
		viewPrincipal.setVisible(true);
		viewGestion.dispose();

	}

	/**
	 * Metodo para habilitar los componentes del formulario
	 */
	private void enableTxt() {

		viewGestion.getTxtNombre().setEditable(true);
		viewGestion.getTxtDescripcion().setEditable(true);
		viewGestion.getTxtCosto().setEditable(true);
		viewGestion.getTxtNacionalidad().setEditable(true);
		viewGestion.getJcbCtegorias().setEditable(true);
		viewGestion.getBtnActualizar().setText("Guardar");
		viewGestion.getBtnEliminar().setText("Cancelar");

	}

	/**
	 * Metodo para deshabilitar los botones
	 */
	private void disableButton() {
		viewGestion.getBtnAnterior().setEnabled(false);
		viewGestion.getBtnSiguiente().setEnabled(false);
		viewGestion.getBtnActualizar().setEnabled(false);
		viewGestion.getBtnEliminar().setEnabled(false);

	}

	/**
	 * Metodo para deshabilitar los componentes del formulario
	 */
	public void disableTxt() {
		viewGestion.getBtnAnterior().setEnabled(true);
		viewGestion.getBtnSiguiente().setEnabled(true);
		viewGestion.getBtnActualizar().setText("ACTUALIZAR");
		viewGestion.getBtnEliminar().setText("ELIMINAR");
		viewGestion.getTxtNombre().setEditable(false);
		viewGestion.getTxtDescripcion().setEditable(false);
		viewGestion.getTxtCosto().setEditable(false);
		viewGestion.getTxtNacionalidad().setEditable(false);
		viewGestion.getJcbCtegorias().setEditable(false);
	}

}
