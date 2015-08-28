package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Remote;

import co.edu.uniandes.umbrella.dto.DatosBasicosUsuarioDTO;

@Remote
public interface UsuariosEJBRemote {
	
	void crearUsuario(DatosBasicosUsuarioDTO usuarioDto);
	
	DatosBasicosUsuarioDTO consultarUsuario(String tipoDoc, String nroDoc);

}
