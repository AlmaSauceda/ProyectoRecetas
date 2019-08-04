package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.*;
/***
 * Develop by joseline
 * 
 * Clase que contiene conexion a base de datos usando un pool de conexiones
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
	
	/**
	 * Variables para el pool de conexiones
	 */

	private ConectionPostgresql() {}

	public static ConectionPostgresql getInstance() throws ClassNotFoundException, SQLException {
		
		BasicDataSource basicDataSource=  new BasicDataSource();
		DataSource dataSource;
		
		String url = "";
		if (instance == null) {
			instance = new ConectionPostgresql();
			System.out.println("Good instance");
		}
		if (connection == null) {
		//	Class.forName(_DRIVER);
			url = _JDBC + _HOST + "/" + _DB_NAME;
		//	connection = DriverManager.getConnection(url, _USER, _PASSWORD);
			basicDataSource.setDriverClassName(_DRIVER);
			basicDataSource.setUsername(_USER);
			basicDataSource.setPassword(_PASSWORD);
			basicDataSource.setUrl(url);
			basicDataSource.setMaxActive(5);
			dataSource = basicDataSource;
			connection = dataSource.getConnection();
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

	public static Connection getConnection() {
		return connection;
	}
	

} //End class