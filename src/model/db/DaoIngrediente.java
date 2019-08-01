package model.db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.db.ConectionPostgresql;
import modelo.Ingredientes;
import modelo.Platillos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DaoIngrediente {

	public void registrarIngredientes(Ingredientes ingrediente) throws SQLException, ClassNotFoundException {
		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
		PreparedStatement preparedStatement = connectionPostgresql.getStatement(
				"INSERT INTO receta.ingredientes (nombre, tipo, marca, caducidad,costo) VALUES(?,?,?,?,?)");

		preparedStatement.setString(1, ingrediente.getNombre());
		preparedStatement.setString(2, ingrediente.getTipo());
		preparedStatement.setString(3, ingrediente.getMarca());
		preparedStatement.setDate(4, Date.valueOf(ingrediente.getCaducidad()));
		preparedStatement.setDouble(5, ingrediente.getCosto());

		preparedStatement.executeUpdate();
		preparedStatement.close();

	}

	// pendiente
	public ArrayList<Ingredientes> consultarIngredientes() throws SQLException, ClassNotFoundException {
		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();

		PreparedStatement preparedStatement = connectionPostgresql
				.getStatement("SELECT * FROM receta.ingredientes order by id_ingrediente");

		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Ingredientes> listaIng = new ArrayList<Ingredientes>();

		while (resultSet.next()) {

			Ingredientes ing = new Ingredientes();

			ing.setId_ingrediente(resultSet.getInt("id_ingrediente"));
			ing.setNombre(resultSet.getString("nombre"));
			ing.setTipo(resultSet.getString("tipo"));
			ing.setMarca(resultSet.getString("marca"));
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			ing.setCaducidad(dateFormat.format(resultSet.getDate("caducidad")));

			ing.setCosto(resultSet.getDouble("costo"));

			listaIng.add(ing);
		}
		preparedStatement.close();
		return listaIng;
	}

	public void actualizarIngrediente(Ingredientes ingrediente) throws SQLException, ClassNotFoundException {

		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
		PreparedStatement preparedStatement = connectionPostgresql.getStatement(
				"UPDATE receta.ingredientes SET nombre=?, tipo=?, marca=?, caducidad=?, costo=? WHERE id_ingrediente=?");

		preparedStatement.setString(1, ingrediente.getNombre());
		preparedStatement.setString(2, ingrediente.getTipo());
		preparedStatement.setString(3, ingrediente.getMarca());
		preparedStatement.setDate(4, Date.valueOf(ingrediente.getCaducidad()));
		preparedStatement.setDouble(5, ingrediente.getCosto());
		preparedStatement.setInt(6, ingrediente.getId_ingrediente());

		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

	public void eliminarIngrediente(Ingredientes ingrediente) throws SQLException, ClassNotFoundException {
		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
		PreparedStatement preparedStatement = connectionPostgresql
				.getStatement("DELETE FROM receta.ingredientes WHERE id_ingrediente=?");

		preparedStatement.setInt(1, ingrediente.getId_ingrediente());

		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
}
