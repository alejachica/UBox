package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Remote;

import co.edu.uniandes.umbrella.dto.DatosOperadorDTO;

@Remote
public interface TransaccionesEJBRemote {

	/**
	 * Servicio que permite consultar los datos del operador de un usuario 
	 * al que se le compartira un documento
	 * @param datos Filtro para la consulta
	 * @return DatosOperadorDTO Datos del operador para compartir documentos
	 */
	public DatosOperadorDTO consultarOperadorUsuarioParaCompartir(String tipoDoc, String nroDoc);
	
	/**
	 * Servicio que permite realizar el traslado de un usuario a un nuevo operador
	 * @param tipoDocUsuario Tipo de documento del usuario	
	 * @param nroDocUsuario Numero de documento del usuario
	 * @param idNuevoOperador Id del nuevo operador al que se trasladara el usuario
	 * @return String codigo de respuesta
	 */
	public String trasladarUsuarioDeOperador(String tipoDocUsuario, String nroDocUsuario, int idNuevoOperador);
	
}
