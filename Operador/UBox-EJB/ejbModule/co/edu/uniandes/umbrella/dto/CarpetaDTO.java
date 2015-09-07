package co.edu.uniandes.umbrella.dto;

public class CarpetaDTO {
	
	private int idCarpeta;
	private String descripcion;
	private String nombreCarpeta;
	private int carpetaPadre = -1;
	
	public CarpetaDTO(){
	}
	
	public CarpetaDTO(int idCarpeta, String descripcion, String nombreCarpeta) {
		super();
		this.idCarpeta = idCarpeta;
		this.descripcion = descripcion;
		this.nombreCarpeta = nombreCarpeta;
	}

	public int getIdCarpeta() {
		return idCarpeta;
	}

	public void setIdCarpeta(int idCarpeta) {
		this.idCarpeta = idCarpeta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreCarpeta() {
		return nombreCarpeta;
	}

	public void setNombreCarpeta(String nombreCarpeta) {
		this.nombreCarpeta = nombreCarpeta;
	}
	
	public int getCarpetaPadre() {
		return carpetaPadre;
	}

	public void setCarpetaPadre(int carpetaPadre) {
		this.carpetaPadre = carpetaPadre;
	}
	
}
