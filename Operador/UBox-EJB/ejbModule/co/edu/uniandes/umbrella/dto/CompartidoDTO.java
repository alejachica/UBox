package co.edu.uniandes.umbrella.dto;
/****
 * Contiene la información de un archivo compartido
 * @author Beto
 *
 */
public class CompartidoDTO {

	private DocumentoDTO documento;
	
	private String clave;

	public DocumentoDTO getDocumento() {
		return documento;
	}

	public void setDocumento(DocumentoDTO documento) {
		this.documento = documento;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
}
