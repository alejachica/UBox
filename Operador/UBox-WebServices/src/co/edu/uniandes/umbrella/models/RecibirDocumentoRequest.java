package co.edu.uniandes.umbrella.models;

public class RecibirDocumentoRequest {
	private String tipoIdentificacionOrigen;
	private String identificacionOrigen;
	private String tipoIdentificacionDestino;
	private String identificacionDestino;
	private DocumentoRequest documento;
	
	public DocumentoRequest getDocumento() {
		return documento;
	}
	public void setDocumento(DocumentoRequest documento) {
		this.documento = documento;
	}
	public String getTipoIdentificacionOrigen() {
		return tipoIdentificacionOrigen;
	}
	public void setTipoIdentificacionOrigen(String tipoIdentificacionOrigen) {
		this.tipoIdentificacionOrigen = tipoIdentificacionOrigen;
	}
	public String getIdentificacionOrigen() {
		return identificacionOrigen;
	}
	public void setIdentificacionOrigen(String identificacionOrigen) {
		this.identificacionOrigen = identificacionOrigen;
	}
	public String getTipoIdentificacionDestino() {
		return tipoIdentificacionDestino;
	}
	public void setTipoIdentificacionDestino(String tipoIdentificacionDestino) {
		this.tipoIdentificacionDestino = tipoIdentificacionDestino;
	}
	public String getIdentificacionDestino() {
		return identificacionDestino;
	}
	public void setIdentificacionDestino(String identificacionDestino) {
		this.identificacionDestino = identificacionDestino;
	}
	
	
}