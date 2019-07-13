package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/***
 * Develop by joseline
 * 
 * Clase que contiene conexion a base de datos
 * 
 * **/


public class ConectionPostgresql {

	private static ConectionPostgresql instance;
	private static Connection connection;

	private static final String _DRIVER = "org.postgresql.Driver";

	private static final String _JDBC = "jdbc:postgresql://";
	private static final String _HOST = "54.39.151.174:5432";

	private static final String _DB_NAME = "restaurante?currentSchema=receta";

	private static final String _USER = "proyectBE";
	private static final String _PASSWORD = "proyectBE@@";

	private ConectionPostgresql() {}

	public static ConectionPostgresql getInstance() throws ClassNotFoundException, SQLException {
		String url = "";
		if (instance == null) {
			instance = new ConectionPostgresql();
			System.out.println("Good instance");
		}
		if (connection == null) {
			Class.forName(_DRIVER);
			url = _JDBC + _HOST + "/" + _DB_NAME;
			connection = DriverManager.getConnection(url, _USER, _PASSWORD);
			System.out.println("Good connection");
		}
		return instance;
	}

	public PreparedStatement getStatement(String sql) throws SQLException {
		return connection.prepareStatement(sql);
	}

	public void close() throws SQLException {
		System.out.println("Close");
		connection.close();
	}//End close

} //End class