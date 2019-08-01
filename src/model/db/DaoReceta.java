package model.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.DetalleReceta;
import modelo.Platillos;
import modelo.Receta;

public class DaoReceta {

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

	public void eliminarReceta(int id_receta) throws SQLException, ClassNotFoundException {
		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
		PreparedStatement preparedStatement = connectionPostgresql
				.getStatement("DELETE FROM receta.detalle_receta WHERE id_receta=?");

		preparedStatement.setInt(1, id_receta);

		preparedStatement.executeUpdate();
		
		preparedStatement = connectionPostgresql
				.getStatement("DELETE FROM receta.recetas WHERE id_receta=?");

		preparedStatement.setInt(1, id_receta);

		preparedStatement.executeUpdate();
		
		
		preparedStatement.close();

	}
}
