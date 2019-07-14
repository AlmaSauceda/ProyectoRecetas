/***
 * Develop by Angel
 * 
 * Clase que contiene los metodos necesarios para la interacción con la base de datos 
 * 
 * **/

package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import model.db.ConectionPostgresql;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import View.Dialogs.Messages;

public class CrudRecetas {

	private int index;
	private ConectionPostgresql conexion;

	/**
	 * Metodo que inserta items en un combobox en donde se pide
	 * 
	 * @param combo
	 * @param tabla para que con el nombre de la tabla se generare la consulta en la
	 *              base de datos y se llene el combo
	 * @return el combo lleno con los datos de la tabla
	 */
	public JComboBox cargarCombo(JComboBox combo, String tabla) {
		String consulta = "SELECT Nombre FROM " + tabla;
		try {

			conexion = ConectionPostgresql.getInstance();
			PreparedStatement ps = conexion.getStatement(consulta);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				combo.addItem(rs.getString(1));
			}
			ps.close();
			return combo;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return combo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return combo;
		}
	}

	/**
	 * Metodo para insertar datos en la tabla donde se piden
	 * 
	 * @param table
	 * @param cmbIngrediente
	 * @param txtCantidad
	 * @param txtPorcion
	 * @param txtImplementacion para que se generen las filas
	 * @return tabla con la fila insertada
	 */
	public JTable InsertarFilas(JTable table, String cmbIngrediente, String txtCantidad, String txtPorcion,
			String txtImplementacion) {
		int numCols = table.getModel().getColumnCount();
		Object[] fila = new Object[numCols];
		fila[0] = cmbIngrediente;
		fila[1] = txtCantidad;
		fila[2] = txtPorcion;
		fila[3] = txtImplementacion;
		((DefaultTableModel) table.getModel()).addRow(fila);
		return table;

	}

	/**
	 * Metodo para registrar en la tabla "Recetas" de la base de datos donde se
	 * piden los parametros
	 * 
	 * @param cmbPlatilloS
	 * @param txtTitulo
	 * @param txtProcedimiento
	 * @param txtTerminologia
	 * @param comensales
	 * 
	 */
	public void RegistrarReceta(String cmbPlatilloS, String txtTitulo, String txtProcedimiento, String txtTerminologia,
			String comensales) {

		int id_platillos = consultarID(cmbPlatilloS);
		try {
			String consulta = "INSERT INTO recetas(titulo, procedimiento,terminologia, comensales, id_platillo ) VALUES(?,?,?,?,?)";
			conexion = ConectionPostgresql.getInstance();
			PreparedStatement ps = conexion.getStatement(consulta);
			ps.setString(1, txtTitulo);
			ps.setString(2, txtProcedimiento);
			ps.setString(3, txtTerminologia);
			ps.setString(4, comensales);
			ps.setInt(5, id_platillos);
			ps.executeUpdate();
			// ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para realizar una consulta para regresar el ID del platillo con el
	 * parametro Nombre
	 * 
	 * @param cmbPlatilloS
	 * @return id del platillo
	 */
	private int consultarID(String cmbPlatilloS) {
		int id = 0;
		String consulta = "SELECT id_platillo FROM platillos where nombre = ?";
		try {
			conexion = ConectionPostgresql.getInstance();
			PreparedStatement ps = conexion.getStatement(consulta);
			ps.setString(1, cmbPlatilloS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = (rs.getInt(1));
			}
			return id;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return id;
		}
	}

	/**
	 * Metodo para insertar datos de la tabla de la vista a la tabla detalle_receta
	 * 
	 * @param table
	 * @return table vacia
	 */
	public JTable registrarDetReceta(JTable table) {

		if (table.getRowCount() > 0) {
			for (int i = 0; i < table.getRowCount(); i++) {
				try {
					String consulta = "INSERT INTO detalle_receta(cantidad , porcion ,implementacion, id_ingrediente , id_receta) VALUES(?,?,?,?,?)";
					conexion = ConectionPostgresql.getInstance();
					PreparedStatement ps = conexion.getStatement(consulta);
					ps.setInt(1, Integer.parseInt(table.getValueAt(i, 1).toString()));

					ps.setString(2, table.getValueAt(i, 2).toString());
					ps.setString(3, table.getValueAt(i, 3).toString());
					ps.setInt(4, recuperarIdIngrediente(table.getValueAt(i, 0).toString()));
					ps.setInt(5, recuperarIdReceta());
					ps.executeUpdate();
					ps.close();

					return eliminarValoresTabla(table);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return eliminarValoresTabla(table);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return eliminarValoresTabla(table);
				}

			}
		}else {
			Messages.showError("Ingrese los ingredientes de la receta");
		}
		return eliminarValoresTabla(table);

	}

	/**
	 * Metodo para vaciar la tabla y la retorna
	 * 
	 * @param table
	 * @return table
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
	 * Metodo para realizar una consulta para regresar el ID del la ultima receta
	 * 
	 * @return
	 */
	private int recuperarIdReceta() {
		int id = 0;
		String consulta = "SELECT id_receta FROM recetas ORDER BY id_receta DESC LIMIT 1 ";
		try {
			conexion = ConectionPostgresql.getInstance();
			PreparedStatement ps = conexion.getStatement(consulta);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = (rs.getInt(1));
			}
			return id;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return id;
		}
	}

	/**
	 * Metodo para realizar una consulta para regresar el ID del ingrediente con el
	 * parametro Nombre
	 * 
	 * @param string
	 * @return id
	 */
	private int recuperarIdIngrediente(String string) {
		int id = 0;
		String consulta = "SELECT id_ingrediente FROM ingredientes where nombre = ?";
		try {
			conexion = ConectionPostgresql.getInstance();
			PreparedStatement ps = conexion.getStatement(consulta);
			ps.setString(1, string);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = (rs.getInt(1));
			}
			return id;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return id;
		}
	}

	public String recuperarNombre(int id_platillo) {
		String id = "";
		String consulta = "SELECT nombre FROM platillos where id_platillo= ?";
		try {
			conexion = ConectionPostgresql.getInstance();
			PreparedStatement ps = conexion.getStatement(consulta);
			ps.setInt(1, id_platillo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = (rs.getString(1));
			}
			return id;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return id;
		}
	}
}
