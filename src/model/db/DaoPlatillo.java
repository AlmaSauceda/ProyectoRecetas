package model.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Platillos;

public class DaoPlatillo {

	private static final String _ADD = "INSERT INTO platillos (nombre, descripcion, costo, categoria,nacionalidad) VALUES(?,?,?,?,?)";
	private static final String _ALL = "SELECT * FROM platillos order by id_platillo ;";
	private static final String _DELETE = "DELETE FROM platillos  WHERE id_platillo=?";
	private static final String _UPDATE = "UPDATE platillos SET nombre=?,"
			+ "descripcion=?,costo=?,categoria=?,nacionalidad=? WHERE id_platillo=?";

	/**
	 * Medoto para agregar platillos a la BD
	 * @param platillos
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void addPlatillo(Platillos platillos) throws SQLException, ClassNotFoundException {
		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
		PreparedStatement preparedStatement = connectionPostgresql.getStatement(_ADD);

		preparedStatement.setString(1, platillos.getNombre());
		preparedStatement.setString(2, platillos.getDescripcion());
		preparedStatement.setString(4, platillos.getCategoria());
		preparedStatement.setDouble(3, platillos.getCosto());
		preparedStatement.setString(5, platillos.getNacionalidad());

		preparedStatement.executeUpdate();
		preparedStatement.close();

	}

	/**
	 * Metodo para cargar todos los datos y mandarlos como una lista
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Platillos> getDatos() throws SQLException, ClassNotFoundException {
		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
		PreparedStatement preparedStatement = connectionPostgresql.getStatement(_ALL);

		ResultSet tableResultSet = preparedStatement.executeQuery();

		ArrayList<Platillos> listPlatillos = new ArrayList<Platillos>();

		while (tableResultSet.next()) {

			Platillos platillos = new Platillos();
			platillos.setId_platillo(tableResultSet.getInt(1));
			platillos.setNombre(tableResultSet.getString(2));
			platillos.setDescripcion(tableResultSet.getString(3));
			platillos.setCosto(tableResultSet.getDouble(4));
			platillos.setCategoria(tableResultSet.getString(5));
			platillos.setNacionalidad(tableResultSet.getString(6));

			listPlatillos.add(platillos);
		}

		tableResultSet.close();
		preparedStatement.close();

		return listPlatillos;
	}

	/**
	 * Metodo para eliminar los platillos
	 * @param platillo
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void deletePlatillo(Platillos platillo) throws SQLException, ClassNotFoundException {
		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
		PreparedStatement preparedStatement = connectionPostgresql.getStatement(_DELETE);
		preparedStatement.setInt(1, platillo.getId_platillo());
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

	/**
	 * Metodo para eliminar los platillos de la bd
	 * @param platillos
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void updatePlatillo(Platillos platillos) throws SQLException, ClassNotFoundException {

		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
		PreparedStatement preparedStatement = connectionPostgresql.getStatement(_UPDATE);

		preparedStatement.setString(1, platillos.getNombre());
		preparedStatement.setString(2, platillos.getDescripcion());
		preparedStatement.setDouble(3, platillos.getCosto());
		preparedStatement.setString(4, platillos.getCategoria());
		preparedStatement.setString(5, platillos.getNacionalidad());
		preparedStatement.setInt(6, platillos.getId_platillo());

		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	/**
	 * Metodo para cargar el segundo combo de los filtros
	 * @param cmbFiltroString
	 * @param combo
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public JComboBox cargarComboFiltro(String cmbFiltroString, JComboBox combo)
			throws SQLException, ClassNotFoundException {
		if (cmbFiltroString.equalsIgnoreCase("-Seleccione-")) {
			return combo;
		} else {
			String consulta = "SELECT " + cmbFiltroString + " FROM receta.platillos group by " + cmbFiltroString + ";";
			// System.out.println(consulta);
			ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
			PreparedStatement preparedStatement = connectionPostgresql.getStatement(consulta);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				combo.addItem(resultSet.getString(1));
			}
			resultSet.close();
			return combo;
		}

	}
	
	/**
	 * Metodo para llenar la tabla con valores de l BD
	 * @param table
	 * @param cmbDatosString
	 * @param cmb
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public JTable llenarTablaF(JTable table, String cmbDatosString, String cmb)
			throws SQLException, ClassNotFoundException {
		if (cmbDatosString.equalsIgnoreCase("-Seleccione-")) {
			return table;
		} else {
			String consulta = "SELECT * FROM receta.platillos where " + cmb + " = '" + cmbDatosString + "';";
			ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
			PreparedStatement preparedStatement = connectionPostgresql.getStatement(consulta);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int numCols = table.getModel().getColumnCount();
				Object[] fila = new Object[numCols];
				fila[0] = resultSet.getString("nombre");
				fila[1] = resultSet.getString("descripcion");
				fila[2] = "$ " + resultSet.getString("costo");
				fila[3] = resultSet.getString("categoria");
				fila[4] = resultSet.getString("nacionalidad");
				((DefaultTableModel) table.getModel()).addRow(fila);
			}
			resultSet.close();
			return table;
		}
	}
}
