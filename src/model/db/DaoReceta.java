package model.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import View.Dialogs.Messages;
import modelo.DetalleReceta;
import modelo.Receta;

public class DaoReceta {

	private ConectionPostgresql conexion;

	/**
	 * Metodo que inserta items en un combobox en donde se pide
	 * 
	 * @param combo
	 * @param tabla para que con el nombre de la tabla se generare la consulta en la
	 *              base de datos y se llene el combo
	 * @return el combo lleno con los datos de la tabla
	 */
	public JComboBox cargarCombo(JComboBox combo, String tabla) throws SQLException, ClassNotFoundException {
		String consulta = "SELECT Nombre FROM " + tabla;
		conexion = ConectionPostgresql.getInstance();
		PreparedStatement ps = conexion.getStatement(consulta);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			combo.addItem(rs.getString(1));
		}
		ps.close();
		return combo;

	}

	/**
	 * Metodo para consultar de la tabla RECETAS
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Receta> consultarRecetas() throws SQLException, ClassNotFoundException {
		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
		PreparedStatement preparedStatement = connectionPostgresql
				.getStatement("SELECT * FROM receta.recetas order by id_receta");
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<Receta> listaIng = new ArrayList<Receta>();
		while (resultSet.next()) {
			Receta ing = new Receta();
			ing.setId_receta(resultSet.getInt("id_receta"));
			ing.setTitulo(resultSet.getString("Titulo"));
			ing.setProcedimiento(resultSet.getString("Procedimiento"));
			ing.setTerminologia(resultSet.getString("Terminologia"));
			ing.setComensales(resultSet.getInt("Comensales"));
			ing.setId_platillo(resultSet.getInt("id_platillo"));
			listaIng.add(ing);
		}
		preparedStatement.close();
		return listaIng;
	}

	/**
	 * Metodo para consultar la tabla Detalle_Receta
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<DetalleReceta> consultarDetalleReceta(int id) throws SQLException, ClassNotFoundException {
		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
		PreparedStatement preparedStatement = connectionPostgresql.getStatement(
				"SELECT id_detalle, i.nombre, cantidad, porcion, dr.id_receta, dr.id_ingrediente, implementacion  FROM receta.detalle_receta dr\r\n"
						+ "inner join receta.ingredientes i on i.id_ingrediente = dr.id_ingrediente where id_receta=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<DetalleReceta> listaIng = new ArrayList<DetalleReceta>();
		while (resultSet.next()) {
			DetalleReceta ing = new DetalleReceta();
			ing.setId_detalle(resultSet.getInt("id_detalle"));
			ing.setCantidad(resultSet.getInt("cantidad"));
			ing.setPorcion(resultSet.getString("porcion"));
			ing.setImplementacion(resultSet.getString("implementacion"));
			ing.setId_ingrediente(resultSet.getInt("id_ingrediente"));
			ing.setId_receta(resultSet.getInt("id_receta"));
			ing.setNombre(resultSet.getString("nombre"));
			listaIng.add(ing);
		}
		preparedStatement.close();
		return listaIng;
	}

	/**
	 * Metodo para eliminar en la tabla RECETA
	 * 
	 * @param id_receta
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void eliminarReceta(int id_receta) throws SQLException, ClassNotFoundException {
		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
		PreparedStatement preparedStatement = connectionPostgresql
				.getStatement("DELETE FROM receta.detalle_receta WHERE id_receta=?");

		preparedStatement.setInt(1, id_receta);
		preparedStatement.executeUpdate();
		preparedStatement = connectionPostgresql.getStatement("DELETE FROM receta.recetas WHERE id_receta=?");
		preparedStatement.setInt(1, id_receta);
		preparedStatement.executeUpdate();
		preparedStatement.close();

	}

	/**
	 * Metodo para actualizar solo en la tabla RECETA
	 * 
	 * @param receta
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void actualizarReceta(Receta receta) throws SQLException, ClassNotFoundException {
		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
		PreparedStatement preparedStatement = connectionPostgresql.getStatement(
				"UPDATE receta.recetas SET titulo=?, procedimiento=?, terminologia=?, comensales=?, id_platillo=? WHERE id_receta=?");
		preparedStatement.setString(1, receta.getTitulo());
		preparedStatement.setString(2, receta.getProcedimiento());
		preparedStatement.setString(3, receta.getTerminologia());
		preparedStatement.setInt(4, receta.getComensales());
		preparedStatement.setInt(5, receta.getId_platillo());
		preparedStatement.setInt(6, receta.getId_receta());
		preparedStatement.executeUpdate();
		preparedStatement.close();

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
	public void registrarReceta(Receta receta) throws SQLException, ClassNotFoundException {
		String consulta = "INSERT INTO recetas(titulo, procedimiento,terminologia, comensales, id_platillo ) VALUES(?,?,?,?,?)";
		conexion = ConectionPostgresql.getInstance();
		PreparedStatement ps = conexion.getStatement(consulta);
		ps.setString(1, receta.getTitulo());
		ps.setString(2, receta.getProcedimiento());
		ps.setString(3, receta.getTerminologia());
		ps.setInt(4, receta.getComensales());
		ps.setInt(5, receta.getId_platillo());
		ps.executeUpdate();
	}

	/**
	 * Metodo para realizar una consulta para regresar el ID del platillo con el
	 * parametro Nombre
	 * 
	 * @param cmbPlatilloS
	 * @return id del platillo
	 */
	public int consultarID(String cmbPlatilloS) throws SQLException, ClassNotFoundException {
		int id = 0;
		String consulta = "SELECT id_platillo FROM platillos where nombre = ?";
		conexion = ConectionPostgresql.getInstance();
		PreparedStatement ps = conexion.getStatement(consulta);
		ps.setString(1, cmbPlatilloS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			id = (rs.getInt(1));
		}
		return id;
	}

	/**
	 * Metodo para insertar datos de la tabla de la vista a la tabla detalle_receta
	 * 
	 * @param table
	 * @return table vacia
	 */

	public JTable registrarDetReceta(JTable table) throws SQLException, ClassNotFoundException {
		if (table.getRowCount() > 0) {
			for (int i = 0; i < table.getRowCount();) {
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
				i++;
			}
			return eliminarValoresTabla(table);
		} else {
			Messages.showError("Ingrese los ingredientes de la receta");
		}
		return eliminarValoresTabla(table);
	}

	/**
	 * Metodo para realizar una consulta para regresar el ID del ingrediente con el
	 * parametro Nombre
	 * 
	 * @param string
	 * @return id
	 */
	public int recuperarIdIngrediente(String string) throws SQLException, ClassNotFoundException {
		int id = 0;
		String consulta = "SELECT id_ingrediente FROM ingredientes where nombre = ?";
		conexion = ConectionPostgresql.getInstance();
		PreparedStatement ps = conexion.getStatement(consulta);
		ps.setString(1, string);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			id = (rs.getInt(1));
		}
		return id;

	}

	/**
	 * Metodo para recuperar el Nombre del ingrediente con el ID del ingrediente
	 * @param string
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public String recuperarNombreIngrediente(int string) throws SQLException, ClassNotFoundException {
		String id = "";
		String consulta = "SELECT nombre  FROM ingredientes where id_ingrediente= ?";
		conexion = ConectionPostgresql.getInstance();
		PreparedStatement ps = conexion.getStatement(consulta);
		ps.setInt(1, string);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			id = (rs.getString(1));
		}
		return id;

	}

	/**
	 * Metodo para realizar una consulta para regresar el ID del la ultima receta
	 * 
	 * @return
	 */
	private int recuperarIdReceta() throws SQLException, ClassNotFoundException {
		int id = 0;
		String consulta = "SELECT id_receta FROM recetas ORDER BY id_receta DESC LIMIT 1 ";
		conexion = ConectionPostgresql.getInstance();
		PreparedStatement ps = conexion.getStatement(consulta);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			id = (rs.getInt(1));
		}
		return id;
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
	 * Metodo para consultar el Nombre del platillo usando el id
	 * @param id_platillo
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public String recuperarNombre(int id_platillo) throws SQLException, ClassNotFoundException {
		String id = "";
		String consulta = "SELECT nombre FROM platillos where id_platillo= ?";
		conexion = ConectionPostgresql.getInstance();
		PreparedStatement ps = conexion.getStatement(consulta);
		ps.setInt(1, id_platillo);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			id = (rs.getString(1));
		}
		return id;
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
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public JTable InsertarFilas(JTable table, DetalleReceta crearDetalle) throws ClassNotFoundException, SQLException {
		int numCols = table.getModel().getColumnCount();
		Object[] fila = new Object[numCols];
		fila[0] = recuperarNombreIngrediente(crearDetalle.getId_ingrediente());
		fila[1] = crearDetalle.getCantidad();
		fila[2] = crearDetalle.getPorcion();
		fila[3] = crearDetalle.getImplementacion();
		((DefaultTableModel) table.getModel()).addRow(fila);
		return table;

	}
}
