package modelo;

/***
 * Develop by joseline
 * 
 * Clase de getter y setter para modelo de tabla ingredientes
 * 
 * **/

public class Ingredientes {

	private int id_ingrediente;
	private String nombre;
	private String tipo;
	private String marca;
	private String caducidad;
	private double costo;
	
	//getter y setters
	public int getId_ingrediente() {
		return id_ingrediente;
	}
	public void setId_ingrediente(int id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCaducidad() {
		return caducidad;
	}
	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	//getter y setters
}//end class

