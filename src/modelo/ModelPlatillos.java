package modelo;

import java.sql.SQLException;

import model.db.DaoIngrediente;
import model.db.DaoReceta;

/**
 * Develop by joseline
 * 
 * Clase desarrollada para mandar a llamar metodos que se estan ejecutando en el dao para sentencias en bd
 * **/


public class ModelPlatillos {
	
	private DaoReceta dao;
	
	public ModelPlatillos(){
	
		dao=new DaoReceta();
	}
	
	public void registrarPlato(Platillos platillos) throws ClassNotFoundException, SQLException {
		dao.registrarPlatillos(platillos);
	}

}
