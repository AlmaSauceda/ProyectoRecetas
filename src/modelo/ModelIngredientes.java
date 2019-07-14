
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.db.DaoIngrediente;

public class ModelIngredientes {

private DaoIngrediente dao;
	
	public ModelIngredientes(){
		dao=new DaoIngrediente();
	}
	
	public void registrarIngrediente(Ingredientes ingrediente) throws ClassNotFoundException, SQLException {
		dao.registrarIngredientes(ingrediente);
	}
	
	public ArrayList<Ingredientes> consultarIngrediente() throws ClassNotFoundException, SQLException {
		return dao.consultarIngredientes();
	}
	
	public void actualizarIngrediente(Ingredientes ingrediente) throws ClassNotFoundException, SQLException{
		dao.actualizarIngrediente(ingrediente);
	}
	
	public void eliminarIngrediente(Ingredientes ingrediente) throws ClassNotFoundException, SQLException{
		dao.eliminarIngrediente(ingrediente);
	}
}
