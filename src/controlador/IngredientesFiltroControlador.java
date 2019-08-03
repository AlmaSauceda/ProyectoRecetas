package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

import modelo.Ingredientes;
import modelo.ModelIngredientes;
import vistas.IngredientesFiltro;

public class IngredientesFiltroControlador implements ActionListener {

	private CrudIngredientes crudIng;
	private IngredientesFiltro vista;
	private ModelIngredientes modelIngr;

	public IngredientesFiltroControlador(IngredientesFiltro vista) {
		this.vista = vista;
		this.modelIngr = new ModelIngredientes();
		this.crudIng = new CrudIngredientes();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getCmbFiltro()) {
			cargarCombo();
		} else if (e.getSource() == vista.getButton()) {
			crudIng.RegresarVentana(vista);
		} else if (e.getSource() == vista.getCmbDatos()) {
			llenarTabla();
		}
	}

	private void llenarTabla() {

		try {
			vista.setTable(eliminarValoresTabla(vista.getTable()));
			vista.setTable(
					modelIngr.llenarTablaF(vista.getTable(), vista.getCmbDatosString(), vista.getCmbFiltroString()));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public JTable eliminarValoresTabla(JTable table) {
		DefaultTableModel tb = (DefaultTableModel) table.getModel();
		int a = table.getRowCount() - 1;
		for (int i = a; i >= 0; i--) {
			tb.removeRow(tb.getRowCount() - 1);
		}
		table.setModel(tb);
		return table;
	}

	public void cargarCombo() {
		try {
			limpiarCombo();
			vista.setCmbDatos(modelIngr.cargarComboFiltro(vista.getCmbFiltroString(), vista.getCmbDatosCmb()));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void limpiarCombo() {
		vista.cmbDatos.setModel(new DefaultComboBoxModel(new String[] { "-Seleccione-" }));

	}

}
