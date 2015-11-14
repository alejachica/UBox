package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Local;

import co.edu.uniandes.umbrella.dto.DatosBasicosUsuarioDTO;
import co.edu.uniandes.umbrella.dto.DatosOperadorDTO;

@Local
public interface UsuariosEJBLocal {
	
	/**
	 * Servicio que permite registrar un usuario en el centralizador
	 * @param usuarioDto Datos del usuario a registrar
	 * @return codigo de respuesta
	 */
	String crearUsuario(DatosBasicosUsuarioDTO usuarioDto);
	
	/**
	 * Servicio que permite consultar un usuario en el centralizador
	 * @param TipoDoc tipo de documento del usuario
	 * @param NroDoc nro de document del usuario
	 * @return DatosBasicosUsuarioDTO Resultado de la consulta
	 */
	DatosBasicosUsuarioDTO consultarUsuario(String tipoDoc, String nroDoc);
	
	/**
	 * Servicio que permite consultar el operador en el que esta registrado un usuario en el centralizador
	 * @param TipoDoc tipo de documento del usuario
	 * @param NroDoc nro de document del usuario
	 * @return DatosOperadorDTO Datos del operador donde esta registrado el usuario
	 */
	DatosOperadorDTO consultarOperadorUsuario(String tipoDoc, String nroDoc);
	
}
