package modelo;

/***
 * Develop by joseline
 * 
 * Clase de getter y setter para modelo de tabla platillos
 * 
 * **/

public class Platillos {

	private int id_platillo;
	private String nombre;
	private String descripcion;
	private String categoria;
	private String nacionalidad;
	private double costo;
	
	//getter y setters
	public int getId_platillo() {
		return id_platillo;
	}
	public void setId_platillo(int id_platillo) {
		this.id_platillo = id_platillo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	@Override
	public String toString() {
		return "Platillos [id_platillo=" + id_platillo + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", categoria=" + categoria + ", nacionalidad=" + nacionalidad + ", costo=" + costo + "]";
	}
	
	
}//end class
