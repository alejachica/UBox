package co.edu.uniandes.umbrella.interfaces;

import java.util.List;

import javax.ejb.Remote;

import co.edu.uniandes.umbrella.dto.DocumentoDTO;

@Remote
public interface DocumentosEJBRemote {
	
	public void crearDocumento(DocumentoDTO documentoDTO) throws Exception;
	
	DocumentoDTO consultarDocumento(int id);
	
	List<DocumentoDTO> listarDocumentosUsuario(String id);
	
	List<DocumentoDTO> listarDocumentosCarpeta(int id);
	
	/***
	 * Carga un documento en el listado de doucmentos del usuario Destino y crea 
	 * @param tipoIdentificacionOrigen 
	 * Tipo de documento del usuario que comparte el documento
	 * @param identificacionOrigen 
	 * numero de documento del usuario que comparte el documento
	 * @param tipoIdentificacionDestino
	 * Tipo de documento del usuario al que le comparten el documento
	 * @param identificacionDestino
	 * N�mero de documento del usuario al que le comparten el documento
	 * @param documento
	 * 
	 */
	void recibirDocumentoCompartido(String tipoIdentificacionOrigen, String identificacionOrigen, String tipoIdentificacionDestino, String identificacionDestino, DocumentoDTO documento);
	
	public boolean eliminarDocumento(int id);
	
}
