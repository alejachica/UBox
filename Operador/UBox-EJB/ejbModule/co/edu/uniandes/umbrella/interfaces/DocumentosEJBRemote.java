package co.edu.uniandes.umbrella.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import co.edu.uniandes.umbrella.dto.CompartidoDTO;
import co.edu.uniandes.umbrella.dto.DocumentoDTO;
import co.edu.uniandes.umbrella.entidades.Documento;
import co.edu.uniandes.umbrella.utils.ResultadoOperacion;

@Remote
public interface DocumentosEJBRemote {
	
	public boolean crearDocumento(DocumentoDTO documentoDTO) throws Exception;
	
	DocumentoDTO consultarDocumento(int documentoId);
	
	List<DocumentoDTO> listarDocumentosPapelera(int usuarioId);
	
	List<DocumentoDTO> listarDocumentosCarpeta(int carpetaId);
	
	/****
	 * Permite compartir un documento sea por un usuario interno o externo. Si no tiene operador retorna false con la informaci�n
	 * @param idUsuario id de usuario que comparte el documento
	 * @param documentoDestino documento del usuario destino 
	 * @param tipoDocumentoDestino tipo de documento del usuario destino
	 * @param idDocumentoCompartir id del documento que se va a compartir
	 * @param fechaExpiracion fecha limite para poder ver el archivo
	 * @return
	 */
	public ResultadoOperacion compartirDocumento(int idUsuario, String documentoDestino, String tipoDocumentoDestino, int idDocumentoCompartir, Date fechaExpiracion);
	
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
	public void recibirDocumentoCompartido(String tipoIdentificacionOrigen, String identificacionOrigen, boolean esEmpresaPublica, String tipoIdentificacionDestino, String identificacionDestino, String idOperadorExterno, DocumentoDTO documento);
	
	/****
	 * Permite compartir un documento entre un usuario del mismo operador
	 * @param idUsuarioOrigen 
	 * usuario que comparte el documento
	 * @param idUsuarioDestino
	 * Usuario al que le comparten el doucmento
	 * @param soloLectura
	 * true: solo lectura false: se puede descargar tambi�n
	 * @param idDocumento
	 * Id del documento que se desea compartir
	 */
	public ResultadoOperacion compartirDocumentoInterno(int idUsuarioOrigen, int idUsuarioDestino, boolean soloLectura, int idDocumento, Date fechaExpiracion);
	
	/***
	 * Permite compartir un documento por medio de un link, con fecha de expiracion
	 * Retorna el link para ser compartido y envia un correo al usuario destinatario
	 * @param idDocumento
	 * @param soloLectura
	 * @param fechaExpiracion
	 * @return
	 */
	public ResultadoOperacion compartirDocumentoPorLink(int idDocumento, int idUsuarioOrigen, String identificacionDestino, String tipoIdentificacionDestino, String emailDestino, Date fechaExpiracion, String clave);
	
	
	/****
	 * Consulta un documento por la llave link y retorna los datos del documento
	 * @param link
	 * @return
	 */
	public CompartidoDTO ConsultarDocumentoPorLink(String link);
	
	public boolean eliminarDocumento(int documentoId);
	
	public boolean manejoPapelera(int documentoId, boolean papelera);
	
	public boolean vaciarPapelera(int usuarioId);
	
	public boolean restaurarPapelera(int usuarioId);
	
}
