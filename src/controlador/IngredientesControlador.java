package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
	private ArrayList<Ingredientes> listaIng = new ArrayList<Ingredientes>();
	private int indice = 0;
	
	public IngredientesControlador(IngredientesRegistrar ingreReg) {
		viewIngrediente = ingreReg;
		modelIngr = new ModelIngredientes();
		ingredientes = new Ingredientes();		
	}

	public IngredientesControlador(IngredientesGestionar ingreGes) {
		this.ingreGes = ingreGes;
		modelIngr = new ModelIngredientes();
		cargarIngredientes();
		consultar();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		crudIng = new CrudIngredientes();
		
		if (ingreGes != null) {
			
			if (source == ingreGes.getBtnActualizar()) {
				System.out.println("Aqui va Actualizar");
			} else if (source == ingreGes.getBtnAnterior()) {
				
				if(indice > 0){
					indice--;					
				} else{
					JOptionPane.showMessageDialog(null, "Este es el primer registro");
				}
				consultar();
				
			} else if (source == ingreGes.getBtnEliminar()) {
				System.out.println("Aqui va Eliminar");
			} else if (source == ingreGes.getBtnSiguiente()) {

				if(indice + 1 < listaIng.size()){
					indice++;					
				} else{
					JOptionPane.showMessageDialog(null, "Este es el último registro");
				}
				consultar();
				
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


	public void consultar(){	
		
		if(listaIng.size() > 0){
			ingreGes.setTxtNombre(listaIng.get(indice).getNombre());
			ingreGes.setCmbTipoIn(listaIng.get(indice).getTipo());
			ingreGes.setTxtMarca(listaIng.get(indice).getMarca());
			ingreGes.setTxtCaducidad(listaIng.get(indice).getCaducidad());
			ingreGes.setTxt_Costo(String.valueOf(listaIng.get(indice).getCosto()));
		}else{
			System.out.println("No hay registros para mostrar");
		}		
	}

	public void cargarIngredientes(){
		listaIng = new ArrayList<Ingredientes>();
		try {
			indice = 0;
			listaIng = modelIngr.consultarIngrediente();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	
}
