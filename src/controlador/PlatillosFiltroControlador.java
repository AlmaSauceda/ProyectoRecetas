package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.ModelPlatillos;
import modelo.Platillos;
import vistas.PlatilloFiltro;
import vistas.Principal;

public class PlatillosFiltroControlador implements ActionListener {

	private PlatilloFiltro vista;
	private CrudIngredientes crudIng;
	private ModelPlatillos modelPlat;

	public PlatillosFiltroControlador(PlatilloFiltro vista) {
		this.vista = vista;
		modelPlat = new ModelPlatillos();
	}

	/**
	 * Metodo para utilizar el ActionEvent para el uso de los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vista.getButton()) {
			cerrarAbrir();
		} else if (e.getSource() == vista.getCmbFiltro()) {
			cargarCombo();
		} else if (e.getSource() == vista.getCmbDatos()) {
			llenarTabla();
		}

	}

	/**
	 * Metodo para llenar la tabla con valores de la base de datos
	 */
	private void llenarTabla() {
		try {
			vista.setTable(eliminarValoresTabla(vista.getTable()));
			vista.setTable(
					modelPlat.llenarTablaF(vista.getTable(), vista.getCmbDatosString(), vista.getCmbFiltroString()));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para vaciar la tabla y posteriormente llenarla
	 * @param table
	 * @return
	 */
	public JTable eliminarValoresTabla(JTable table) {
		DefaultTableModel tb = (DefaultTableModel) table.getModel();
		int a = table.getRowCount() - 1;
		for (int i = a; i >= 0; i--) {
			tb.removeRow(tb.getRowCount() - 1);
		}
		table.setModel(tb);
		return table;
	}

	/**
	 * Metodo para cargar el 2do combo con datos de la base de datos
	 */
	public void cargarCombo() {
		try {
			limpiarCombo();
			vista.setCmbDatos(modelPlat.cargarComboFiltro(vista.getCmbFiltroString(), vista.getCmbDatosCmb()));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para vaciar el segundo combo box
	 */
	private void limpiarCombo() {
		vista.cmbDatos.setModel(new DefaultComboBoxModel(new String[] { "-Seleccione-" }));

	}
	
	/**
	 * Metodo para cambiar de ventana
	 */
	private void cerrarAbrir() {
		vista.setVisible(false);
		Principal viewPrincipal = new Principal();
		viewPrincipal.setVisible(true);
		vista.dispose();

	}

}
