
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;

import model.db.DaoIngrediente;

public class ModelIngredientes {

private DaoIngrediente dao;
	
	public ModelIngredientes(){
		dao=new DaoIngrediente();
	}
	
	public void registrarIngrediente(Ingredientes ingrediente) throws ClassNotFoundException, SQLException {
		dao.registrarIngredientes(ingrediente);
	}
	
	public ArrayList<Ingredientes> consultarIngrediente() throws ClassNotFoundException, SQLException {
		return dao.consultarIngredientes();
	}
	
	public void actualizarIngrediente(Ingredientes ingrediente) throws ClassNotFoundException, SQLException{
		dao.actualizarIngrediente(ingrediente);
	}
	
	public void eliminarIngrediente(Ingredientes ingrediente) throws ClassNotFoundException, SQLException{
		dao.eliminarIngrediente(ingrediente);
	}

	public JComboBox cargarComboFiltro(String cmbFiltroString, JComboBox jComboBox) throws ClassNotFoundException, SQLException{
		return dao.cargarComboFiltro(cmbFiltroString, jComboBox);
	}

	public JTable llenarTablaF(JTable table, String cmbDatosString, String string) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		return dao.llenarTablaF(table, cmbDatosString, string);
	}
}
