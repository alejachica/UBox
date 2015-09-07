package co.edu.uniandes.umbrella.dto;

import java.math.BigDecimal;


public class DocumentoDTO {
	
	private int idDocumento;
	private byte[] documento;
	private String fecha;
	private byte firmado;
	private BigDecimal idTipoDocumento;
	private String idTipoMime;
	private String nombre;
	private String palabrasClave;
	private byte papelera;
	private String ruta;
	private int size;
	private String version;

	public DocumentoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public byte getFirmado() {
		return firmado;
	}

	public void setFirmado(byte firmado) {
		this.firmado = firmado;
	}

	public BigDecimal getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(BigDecimal idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getIdTipoMime() {
		return idTipoMime;
	}

	public void setIdTipoMime(String idTipoMime) {
		this.idTipoMime = idTipoMime;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPalabrasClave() {
		return palabrasClave;
	}

	public void setPalabrasClave(String palabrasClave) {
		this.palabrasClave = palabrasClave;
	}

	public byte getPapelera() {
		return papelera;
	}

	public void setPapelera(byte papelera) {
		this.papelera = papelera;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	

}
