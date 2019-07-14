package modelo;

import java.sql.SQLException;

import model.db.DaoPlatillos;

public class ModelIngredientes {

private DaoPlatillos dao;
	
	public ModelIngredientes(){
	
		dao=new DaoPlatillos();
	}
	
	public void registrarIngrediente(Ingredientes ingrediente) throws ClassNotFoundException, SQLException {
		dao.registrarIngredientes(ingrediente);
	}
}
