package modelo;

import java.sql.SQLException;

import model.db.Dao;

/**
 * Develop by joseline
 * 
 * Clase desarrollada para mandar a llamar metodos que se estan ejecutando en el dao para sentencias en bd
 * **/


public class ModelPlatillos {
	
	private Dao dao;
	
	public ModelPlatillos(){
	
		dao=new Dao();
	}
	
	public void registrarPlato(Platillos platillos) throws ClassNotFoundException, SQLException {
		dao.registrarPlatillos(platillos);
	}

}
