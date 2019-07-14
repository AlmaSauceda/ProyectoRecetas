package model.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Platillos;

public class DaoPlatillo {

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


	
	public List<Platillos> getDatos() throws SQLException, ClassNotFoundException {
		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
		PreparedStatement preparedStatement = connectionPostgresql.getStatement(
				"SELECT * FROM platillos;");

		ResultSet tableResultSet = preparedStatement.executeQuery();

		Platillos platillos;

		List<Platillos> listPlatillos = new ArrayList<Platillos>();

		while (tableResultSet.next()) {
			
			platillos = new Platillos();
			
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
	
}
