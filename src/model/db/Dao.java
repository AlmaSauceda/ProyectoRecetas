package model.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.db.ConectionPostgresql;
import modelo.Platillos;

public class Dao {

	public  void registrarPlatillos(Platillos platillos)  throws SQLException,ClassNotFoundException{
		ConectionPostgresql connectionPostgresql = ConectionPostgresql.getInstance();
		PreparedStatement preparedStatement = connectionPostgresql.getStatement("INSERT INTO platillos (nombre, descripcion, costo, categoria,nacionalidad) VALUES(?,?,?,?,?)");
			
		
		preparedStatement.setString(1, platillos.getNombre());
		preparedStatement.setString(2, platillos.getDescripcion());
		preparedStatement.setString(4, platillos.getCategoria());
		preparedStatement.setDouble(3, platillos.getCosto());
		preparedStatement.setString(5, platillos.getNacionalidad());
	        
		preparedStatement.executeUpdate();
		preparedStatement.close();
	        
		}
	}

	
	

