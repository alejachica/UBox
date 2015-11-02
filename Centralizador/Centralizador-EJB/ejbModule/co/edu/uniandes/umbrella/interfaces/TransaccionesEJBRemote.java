package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Remote;

import co.edu.uniandes.umbrella.dto.DatosOperadorDTO;
import co.edu.uniandes.umbrella.dto.ServiciosOperadorUsuarioDTO;

@Remote
public interface TransaccionesEJBRemote {

	/**
	 * Servicio que permite consultar los datos del operador de un usuario 
	 * al que se le compartira un documento
	 * @param datos Filtro para la consulta
	 * @return DatosOperadorDTO Datos del operador para compartir documentos
	 */
	DatosOperadorDTO consultarOperadorUsuarioParaCompartir(
			ServiciosOperadorUsuarioDTO datos);
	
	/**
	 * Servicio que permite realizar el traslado de un usuario a un nuevo operador
	 * @param tipoDocUsuario Tipo de documento del usuario	
	 * @param nroDocUsuario Numero de documento del usuario
	 * @param idNuevoOperador Id del nuevo operador al que se trasladara el usuario
	 * @return true si el traslado fue exitoso, false en caso contrario.
	 */
	boolean trasladarUsuarioDeOperador(String tipoDocUsuario, String nroDocUsuario, long idNuevoOperador);
	
}
