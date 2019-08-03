package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import View.Dialogs.Messages;
import vistas.PlatilloRegistrar;
import vistas.Principal;
import modelo.ModelPlatillos;
import modelo.Platillos;

/**
 * Develop by joseline Clase dedicada al control de los platillos
 * 
 ***/

public class PlatillosControlador implements ActionListener {

	private PlatilloRegistrar viewPlatillo;
	private ModelPlatillos modelPlat;
	private Platillos platillos;

	public PlatillosControlador(PlatilloRegistrar contactEditView) {
		viewPlatillo = contactEditView;
		modelPlat = new ModelPlatillos();
		platillos = new Platillos();

	}

	/**
	 * Metodo para utilizar el ActionEvent para el uso de los botones
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();

		if (source == viewPlatillo.getBtnAtrasVentana()) {
			cerrarAbrir2();

		} else if (source == viewPlatillo.getBtnRegistrar()) {
			System.out.println("Entro a controlador");
			validar();

		}

	}

	/**
	 * Metodo para validar campos vacios
	 */
	private void validar() {
		if (viewPlatillo.getTxtNombre().isEmpty() || viewPlatillo.getTxtDescripcion().isEmpty()
				|| viewPlatillo.getTxtCosto().isEmpty() || viewPlatillo.getTxtNacionalidad().isEmpty()
				|| viewPlatillo.getSelectedItem().equalsIgnoreCase("Selecciona...")) {
			Messages.showError("  campos vacios");
		} else {
			registrar();
		}
	}

	/**
	 * Metodo para limpiar
	 */
	private void limpiar() {
		reset();
	}

	/**
	 * Metodo para limpiar todo
	 */
	private void reset() {
		viewPlatillo.setTxtNombre("");
		viewPlatillo.setTxtDescripcion("");
		viewPlatillo.setTxtCosto("");
		viewPlatillo.setTxtNacionalidad("");
		viewPlatillo.setJcbCtegorias(0);
	}

	/**
	 * Metodo para cambiar de ventana
	 */
	private void cerrarAbrir2() {
		viewPlatillo.setVisible(false);
		Principal viewPrincipal = new Principal();
		viewPrincipal.setVisible(true);
		viewPlatillo.dispose();

	}

	/**
	 * Metodo para registrar los platillos
	 */
	private void registrar() {
		platillos.setNombre(viewPlatillo.getTxtNombre());
		platillos.setDescripcion(viewPlatillo.getTxtDescripcion());
		platillos.setCosto(Double.parseDouble(viewPlatillo.getTxtCosto()));
		platillos.setNacionalidad(viewPlatillo.getTxtNacionalidad());
		platillos.setCategoria(viewPlatillo.getSelectedItem());
		try {
			modelPlat.addPlatillos(platillos);

			Messages.showMessage("\nSe agrego de forma correcta");
			limpiar();
		} catch (ClassNotFoundException e) {
			Messages.showError("\nNo se registro\n" + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			Messages.showError("\nNo se registro\n" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
