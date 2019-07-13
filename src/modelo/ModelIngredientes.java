package modelo;

import java.sql.SQLException;

import model.db.Dao;

public class ModelIngredientes {

private Dao dao;
	
	public ModelIngredientes(){
	
		dao=new Dao();
	}
	
	public void registrarIngrediente(Ingredientes ingrediente) throws ClassNotFoundException, SQLException {
		dao.registrarIngredientes(ingrediente);
	}
}
