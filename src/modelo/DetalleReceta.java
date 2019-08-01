package modelo;

/***
 * Develop by joseline
 * 
 * Clase de getter y setter para modelo de tabla detalle receta
 * 
 * **/

public class DetalleReceta {

	private int id_detalle;
	private int id_ingrediente;
	private int id_receta;
	private int cantidad;
	private String porcion;
	private String implementacion;
	private String nombre;
	
	//getter y setters
	public int getId_detalle() {
		return id_detalle;
	}
	public void setId_detalle(int id_detalle) {
		this.id_detalle = id_detalle;
	}
	public int getId_ingrediente() {
		return id_ingrediente;
	}
	public void setId_ingrediente(int id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}
	public int getId_receta() {
		return id_receta;
	}
	public void setId_receta(int id_receta) {
		this.id_receta = id_receta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getPorcion() {
		return porcion;
	}
	public void setPorcion(String porcion) {
		this.porcion = porcion;
	}
	public String getImplementacion() {
		return implementacion;
	}
	public void setImplementacion(String implementacion) {
		this.implementacion = implementacion;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	//getter y setters
	
	
}
