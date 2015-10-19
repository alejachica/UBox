package co.edu.uniandes.umbrella.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import co.edu.uniandes.umbrella.dto.DocumentoDTO;
import co.edu.uniandes.umbrella.entidades.Documento;
import co.edu.uniandes.umbrella.utils.ResultadoOperacion;

@Remote
public interface DocumentosEJBRemote {
	
	public Documento crearDocumento(DocumentoDTO documentoDTO) throws Exception;
	
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
	public void recibirDocumentoCompartido(String tipoIdentificacionOrigen, String identificacionOrigen, boolean esEmpresaPublica, String tipoIdentificacionDestino, String identificacionDestino, String idOperadorExterno, DocumentoDTO documento);
	
	/****
	 * Permite compartir un documento entre un usuario del mismo operador
	 * @param idUsuarioOrigen 
	 * usuario que comparte el documento
	 * @param idUsuarioDestino
	 * Usuario al que le comparten el doucmento
	 * @param soloLectura
	 * true: solo lectura false: se puede descargar también
	 * @param idDocumento
	 * Id del documento que se desea compartir
	 */
	public ResultadoOperacion compartirDocumentoInterno(int idUsuarioOrigen, int idUsuarioDestino, boolean soloLectura, int idDocumento, Date fechaExpiracion);
	
	public boolean eliminarDocumento(int documentoId);
	
	public boolean enviarAPapelera(int documentoId);
	
	public boolean vaciarPapelera(int usuarioId);
	
}
