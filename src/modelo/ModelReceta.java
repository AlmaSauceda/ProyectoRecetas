package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import model.db.DaoReceta;

public class ModelReceta {

	private DaoReceta dao;

	public ModelReceta() {
		dao = new DaoReceta();
	}

	public ArrayList<Receta> consultarReceta() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return dao.consultarRecetas();
	}

	public ArrayList<DetalleReceta> consultarDetalleReceta(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return dao.consultarDetalleReceta(id);
	}

	public void eliminarReceta(int id_receta) throws ClassNotFoundException, SQLException{
		dao.eliminarReceta(id_receta);
		
	}

}
