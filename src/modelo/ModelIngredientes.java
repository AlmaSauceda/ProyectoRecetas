package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.db.Dao;

public class ModelIngredientes {

private Dao dao;
	
	public ModelIngredientes(){
	
		dao=new Dao();
	}
	
	public void registrarIngrediente(Ingredientes ingrediente) throws ClassNotFoundException, SQLException {
		dao.registrarIngredientes(ingrediente);
	}
	
	public ArrayList<Ingredientes> consultarIngrediente() throws ClassNotFoundException, SQLException {
		return dao.consultarIngredientes();
	}
}
