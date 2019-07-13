package model.db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.db.ConectionPostgresql;
import modelo.Ingredientes;
import modelo.Platillos;

public class Dao {

	public void registrarPlatillos(Platillos platillos) throws SQLException, ClassNotFoundException {
		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
		PreparedStatement preparedStatement = connectionPostgresql.getStatement(
				"INSERT INTO platillos (nombre, descripcion, costo, categoria,nacionalidad) VALUES(?,?,?,?,?)");

		preparedStatement.setString(1, platillos.getNombre());
		preparedStatement.setString(2, platillos.getDescripcion());
		preparedStatement.setString(4, platillos.getCategoria());
		preparedStatement.setDouble(3, platillos.getCosto());
		preparedStatement.setString(5, platillos.getNacionalidad());

		preparedStatement.executeUpdate();
		preparedStatement.close();

	}

	// Pendiente
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
}
