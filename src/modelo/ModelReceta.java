/***
 * Develop by Angel
 * 
 * Clase de union entre el controlador y el DAO para gestionar las recetas
 * 
 * **/

package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;

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

	public void actualizarReceta(Receta receta) throws ClassNotFoundException, SQLException{
		dao.actualizarReceta(receta);
		
	}

	public void registrarReceta(Receta receta) throws ClassNotFoundException, SQLException{
		dao.registrarReceta(receta);
		
	}

	public int consultarID(String cmbPlatilloS) throws ClassNotFoundException, SQLException{
		return dao.consultarID(cmbPlatilloS);
	}

	public JTable registrarDetReceta(JTable table) throws ClassNotFoundException, SQLException{
		return dao.registrarDetReceta(table);
	}

	public JTable eliminarValoresTabla(JTable table) {
		return dao.eliminarValoresTabla(table);
	}

	public JComboBox cargarCombo(JComboBox cmbIngrediente, String string) throws ClassNotFoundException, SQLException{
		return dao.cargarCombo(cmbIngrediente, string);
	}

	public String recuperarNombre(int id_platillo) throws ClassNotFoundException, SQLException{
		return dao.recuperarNombre(id_platillo);
	}

	public int recuperarIdIngrediente(String cmbIngredienteS) throws ClassNotFoundException, SQLException{
		return dao.recuperarIdIngrediente(cmbIngredienteS);
	}

	public JTable InsertarFilas(JTable table, DetalleReceta crearDetalle)  throws ClassNotFoundException, SQLException{
		return dao.InsertarFilas(table, crearDetalle);
	}

}
