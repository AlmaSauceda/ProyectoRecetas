package model.db;
/**
 * 
 * Clase que tiene por objetivo proporcionar una interfaz para unificar las operaciones que se realizan
 * en el patron  dao, haciendola una clase generica.
 * 
 * @author: jorge
 * @Date: 01/05/2019
 * 
 */
import java.sql.SQLException;

import java.util.List;

public interface DaoInterface<Model> {

	/**
	 * add
	 * 
	 * Agrega los valores de los atributos de la clase
	 * 
	 */
	Object add(Model dto) throws SQLException, ClassNotFoundException;

	/**
	 * update
	 * 
	 * Actualiza los valores de los atributos 
	 */
	boolean update(Model dto) throws SQLException, ClassNotFoundException;

	/**
	 * delete
	 * 
	 * Elimina el registro 
	 * 
	 */
	boolean delete(Object key) throws SQLException, ClassNotFoundException;

	/**
	 * get
	 * 
	 * Obtiene una instancia 
	 */
	Model get(Object key) throws SQLException, ClassNotFoundException;

	/**
	 * get all
	 * 
	 * Obtiene una istancia de la interface {@link List}  con todos los registros almacenado
	 */
	List<Model> getAll() throws SQLException, ClassNotFoundException;

}

