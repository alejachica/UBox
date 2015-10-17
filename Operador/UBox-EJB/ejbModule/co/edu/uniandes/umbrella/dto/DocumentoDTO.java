package co.edu.uniandes.umbrella.dto;

import java.math.BigDecimal;
import java.util.Date;


public class DocumentoDTO {
	
	private int idDocumento;
	
	private int fkCarpeta;
	
	private int fkUsuario;
	
	private byte[] documento;
	private Date fecha;
	private boolean firmado;
	private BigDecimal idTipoDocumento;
	private String idTipoMime;
	private String nombre;
	private String palabrasClave;
	private boolean papelera;
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

	public int getFkCarpeta() {
		return fkCarpeta;
	}

	public void setFkCarpeta(int fkCarpeta) {
		this.fkCarpeta = fkCarpeta;
	}

	public int getFkUsuario() {
		return fkUsuario;
	}

	public void setFkUsuario(int fkUsuario) {
		this.fkUsuario = fkUsuario;
	}

	public byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean getFirmado() {
		return firmado;
	}

	public void setFirmado(boolean firmado) {
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

	public boolean getPapelera() {
		return papelera;
	}

	public void setPapelera(boolean papelera) {
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
