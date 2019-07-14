package modelo;

import java.sql.SQLException;
import java.util.List;

import model.db.DaoPlatillos;

/**
 * Develop by joseline
 * 
 * Clase desarrollada para mandar a llamar metodos que se estan ejecutando en el dao para sentencias en bd
 * **/


public class ModelPlatillos {
	
	private DaoPlatillos dao;
	
	public ModelPlatillos(){
	
		dao=new DaoPlatillos();
	}
	
	public void registrarPlato(Platillos platillos) throws ClassNotFoundException, SQLException {
		dao.registrarPlatillos(platillos);
	}

	public List<Platillos> getPlatillos() throws ClassNotFoundException, SQLException {
		return dao.getDatos();
	}

}
