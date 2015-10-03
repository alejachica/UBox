package co.edu.uniandes.umbrella.dto;

public class DataTreeTable {
	
	private int id;
	private String nombre;
	private String descripcion;
	private String size;
	private String type;

	public DataTreeTable(){
	}
	
	public DataTreeTable(int id, String nombre, String descripcion, String size, String type) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.size = size;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}