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
	
	//pendiente
	public ArrayList<Ingredientes> consultarIngredientes() throws SQLException, ClassNotFoundException {
		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
		
		PreparedStatement preparedStatement = connectionPostgresql.getStatement(
				"SELECT * FROM receta.ingredientes order by id_ingrediente");
				
		ResultSet resultSet = preparedStatement.executeQuery();
		
		ArrayList<Ingredientes> listaIng = new ArrayList<Ingredientes>();
		
	    while (resultSet.next()) {
			
	    	Ingredientes ing = new Ingredientes();
			
			ing.setId_ingrediente(resultSet.getInt("id_ingrediente"));
			ing.setNombre(resultSet.getString("nombre"));
			ing.setTipo(resultSet.getString("tipo"));
			ing.setMarca(resultSet.getString("marca"));			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");			
			ing.setCaducidad( dateFormat.format(resultSet.getDate("caducidad")));
						
			ing.setCosto(resultSet.getDouble("costo"));
			
            System.out.println(ing);
            listaIng.add(ing);
        }		
		preparedStatement.close();		
		return listaIng;
	}
}
