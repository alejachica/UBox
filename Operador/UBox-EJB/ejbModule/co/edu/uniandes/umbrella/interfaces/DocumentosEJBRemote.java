package co.edu.uniandes.umbrella.interfaces;

import java.util.List;

import javax.ejb.Remote;

import co.edu.uniandes.umbrella.dto.DocumentoDTO;

@Remote
public interface DocumentosEJBRemote {
	
	public void crearDocumento(DocumentoDTO documentoDTO) throws Exception;
	
	DocumentoDTO consultarDocumento(int documentoId);
	
	List<DocumentoDTO> listarDocumentosPapelera(int usuarioId);
	
	List<DocumentoDTO> listarDocumentosCarpeta(int carpetaId);
	
	/***
	 * Carga un documento en el listado de doucmentos del usuario Destino y crea 
	 * @param tipoIdentificacionOrigen 
	 * Tipo de documento del usuario que comparte el documento
	 * @param identificacionOrigen 
	 * numero de documento del usuario que comparte el documento
	 * @param tipoIdentificacionDestino
	 * Tipo de documento del usuario al que le comparten el documento
	 * @param identificacionDestino
	 * Número de documento del usuario al que le comparten el documento
	 * @param documento
	 * 
	 */
	void recibirDocumentoCompartido(String tipoIdentificacionOrigen, String identificacionOrigen, String tipoIdentificacionDestino, String identificacionDestino, DocumentoDTO documento);
	
	public boolean eliminarDocumento(int documentoId);
	
	public boolean enviarAPapelera(int documentoId);
	
	public boolean vaciarPapelera(int usuarioId);
	
}
