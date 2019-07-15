package model.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Platillos;

public class DaoPlatillo {

	private static final String _ADD="INSERT INTO platillos (nombre, descripcion, costo, categoria,nacionalidad) VALUES(?,?,?,?,?)";
	private static final String _ALL="SELECT * FROM platillos order by id_platillo ;";
	private static final String _DELETE = "DELETE FROM platillos  WHERE id_platillo=?";
	private static final String _UPDATE = "UPDATE platillos SET nombre=?,"
			+ "descripcion=?,costo=?,categoria=?,nacionalidad=? WHERE id_platillo=?";
	
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
	
	public void deletePlatillo(Platillos platillo) throws SQLException, ClassNotFoundException{
		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
		PreparedStatement preparedStatement = connectionPostgresql.getStatement(_DELETE);

		preparedStatement.setInt(1, platillo.getId_platillo());

		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
public void updatePlatillo(Platillos platillos) throws SQLException, ClassNotFoundException{
		
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
}
