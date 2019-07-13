package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import View.Dialogs.Messages;
import modelo.Ingredientes;
import modelo.ModelIngredientes;
import vistas.IngredientesGestionar;
import vistas.IngredientesRegistrar;

public class IngredientesControlador implements ActionListener {

	private IngredientesGestionar ingreGes;
	private IngredientesRegistrar viewIngrediente;
	private CrudIngredientes crudIng;
	private ModelIngredientes modelIngr;
	private Ingredientes ingredientes;

	public IngredientesControlador(IngredientesRegistrar ingreReg) {
		viewIngrediente = ingreReg;
		modelIngr = new ModelIngredientes();
		ingredientes = new Ingredientes();

	}

	public IngredientesControlador(IngredientesGestionar ingreGes) {
		this.ingreGes = ingreGes;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		crudIng = new CrudIngredientes();

		if (ingreGes != null) {
			if (source == ingreGes.getBtnActualizar()) {
				System.out.println("Aqui va Actualizar");
			} else if (source == ingreGes.getBtnAnterior()) {
				System.out.println("Aqui va Anterior");
			} else if (source == ingreGes.getBtnEliminar()) {
				System.out.println("Aqui va Eliminar");
			} else if (source == ingreGes.getBtnSiguiente()) {
				System.out.println("Aqui va Siguiente");
			} else if (source == ingreGes.getBtnAtrasVentana()) {
				crudIng.RegresarVentana(ingreGes);
			}
		} else {
			if (source == viewIngrediente.getBtnAtrasVentana()) {
				crudIng.RegresarVentana(viewIngrediente);
			} else if (source == viewIngrediente.getBtnRegistrar()) {

				System.out.println("Entro a controlador");
				registrar();
			}
		}
	}

	private void registrar() {
		ingredientes.setNombre(viewIngrediente.getTxtNombre());
		ingredientes.setTipo(viewIngrediente.getCmbIngrediente());
		ingredientes.setMarca(viewIngrediente.getTxtMarca());
		ingredientes.setCaducidad(viewIngrediente.getTxtCaducidad());
		ingredientes.setCosto(Double.parseDouble(viewIngrediente.getTxt_Costo()));

		System.out.println("" + ingredientes.getNombre() + ingredientes.getTipo() + ingredientes.getMarca()
				+ ingredientes.getCaducidad() + ingredientes.getCosto());

		try {
			modelIngr.registrarIngrediente(ingredientes);
			Messages.showMessage("\nSe agrego de forma correcta");
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
