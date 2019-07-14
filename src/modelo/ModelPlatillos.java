
package modelo;

import java.sql.SQLException;
import java.util.List;

import model.db.DaoPlatillo;

/**
 * Develop by joseline
 * 
 * Clase desarrollada para mandar a llamar metodos que se estan ejecutando en el dao para sentencias en bd
 * **/


public class ModelPlatillos {
	
	private DaoPlatillo dao;
	
	public ModelPlatillos(){
	
		dao=new DaoPlatillo();
	}
	
	public void registrarPlato(Platillos platillos) throws ClassNotFoundException, SQLException {
		dao.registrarPlatillos(platillos);
	}

	public List<Platillos> getPlatillos() throws ClassNotFoundException, SQLException {
		return dao.getDatos();
	}

}

