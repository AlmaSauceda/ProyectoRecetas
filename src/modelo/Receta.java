package modelo;
/***
 * Develop by joseline
 * 
 * Clase de getter y setter para modelo de tabla recetas
 * 
 * **/

public class Receta {
	
	private int id_receta;
	private int id_platillo;
	private String titulo;
	private String procedimiento;
	private String terminologia;
	private int comensales;
	
	//getter y setters
	
	public int getId_receta() {
		return id_receta;
	}
	public void setId_receta(int id_receta) {
		this.id_receta = id_receta;
	}
	public int getId_platillo() {
		return id_platillo;
	}
	public void setId_platillo(int id_platillo) {
		this.id_platillo = id_platillo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getProcedimiento() {
		return procedimiento;
	}
	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}
	public String getTerminologia() {
		return terminologia;
	}
	public void setTerminologia(String terminologia) {
		this.terminologia = terminologia;
	}
	public int getComensales() {
		return comensales;
	}
	public void setComensales(int comensales) {
		this.comensales = comensales;
	}
	
	//getter y setters
	
	
}
