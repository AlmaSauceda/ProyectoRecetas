
package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
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
	
	public void addPlatillos(Platillos platillos) throws ClassNotFoundException, SQLException {
		dao.addPlatillo(platillos);
	}

	

	public ArrayList<Platillos> getPlatillos() throws ClassNotFoundException, SQLException {
		return dao.getDatos();
	}

	public void updatePlatillos(Platillos platillos) throws ClassNotFoundException, SQLException{
		dao.updatePlatillo(platillos);
	}
	
	public void deletePlatillos(Platillos platillos) throws ClassNotFoundException, SQLException{
		dao.deletePlatillo(platillos);
	}

}

