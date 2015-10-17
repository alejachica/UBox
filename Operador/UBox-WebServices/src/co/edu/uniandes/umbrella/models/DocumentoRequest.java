package co.edu.uniandes.umbrella.models;

import java.util.Date;

public class DocumentoRequest {
	private String nombre;
	private String tipoDocumento;
	private String tipoMime;
	private Date fechaCreacion;
	private byte[] archivo;
	private boolean firmado;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getTipoMime() {
		return tipoMime;
	}
	public void setTipoMime(String tipoMime) {
		this.tipoMime = tipoMime;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public byte[] getArchivo() {
		return archivo;
	}
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}
	public boolean isFirmado() {
		return firmado;
	}
	public void setFirmado(boolean firmado) {
		this.firmado = firmado;
	}
	
	
	
}
